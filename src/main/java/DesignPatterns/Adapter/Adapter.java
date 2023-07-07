package DesignPatterns.Adapter;

// Step 2: Create the adapter class implementing the target interface (Target)
interface Target {
    void request();
}

// Step 1: Identify the existing interface (Adaptee)
class Adaptee {
    public void specificRequest() {
        System.out.println("Adaptee's specific request");
    }
}

// Step 3: Implement the adapter class and wrap the adaptee object
class Adapter implements Target {
    private final Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specificRequest();
    }
}

// Step 4: Client code uses the target interface to interact with the adapted object
class Main {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Target target = new Adapter(adaptee);

        target.request();
        // Output: Adaptee's specific request
    }
}
