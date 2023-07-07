package DesignPatterns.Facade;

// Step 1: Identify the complex subsystem
class SubsystemA {
    public void operationA() {
        System.out.println("Subsystem A: Operation A");
    }
}

class SubsystemB {
    public void operationB() {
        System.out.println("Subsystem B: Operation B");
    }
}

// Step 2: Create the facade class
class Facade {
    private final SubsystemA subsystemA;
    private final SubsystemB subsystemB;

    public Facade() {
        this.subsystemA = new SubsystemA();
        this.subsystemB = new SubsystemB();
    }

    public void performOperations() {
        subsystemA.operationA();
        subsystemB.operationB();
    }
}

// Step 4: Client code interacts with the subsystem through the facade
class Main {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.performOperations();
        // Output:
        // Subsystem A: Operation A
        // Subsystem B: Operation B
    }
}
