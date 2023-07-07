package DesignPatterns.Observer;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

// Step 1: Define the subject interface
interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}

// Step 2: Define the observer interface
interface Observer {
    void update();
}

// Step 3: Implement the subject class
@Getter
class ConcreteSubject implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    private int state;

    public void setState(int state) {
        this.state = state;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

// Step 4: Implement the observer class(es)
class ConcreteObserver implements Observer {
    private final ConcreteSubject subject;

    public ConcreteObserver(ConcreteSubject subject) {
        this.subject = subject;
        this.subject.registerObserver(this);
    }

    @Override
    public void update() {
        System.out.println("Observer updated with state: " + subject.getState());
    }
}

// Client code
class Main {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        ConcreteObserver observer1 = new ConcreteObserver(subject);
        ConcreteObserver observer2 = new ConcreteObserver(subject);

        subject.setState(42);
        // Output:
        // Observer updated with state: 42
        // Observer updated with state: 42

        subject.setState(123);
        // Output:
        // Observer updated with state: 123
        // Observer updated with state: 123

        subject.removeObserver(observer2);
        subject.setState(999);
        // Output:
        // Observer updated with state: 999
    }
}
