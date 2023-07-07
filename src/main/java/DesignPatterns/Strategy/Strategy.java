package DesignPatterns.Strategy;

// Step 1: Define the strategy interface
interface Strategy {
    void doOperation();
}

// Step 2: Implement the concrete strategy classes
class ConcreteStrategyA implements Strategy {
    @Override
    public void doOperation() {
        System.out.println("Using Strategy A");
        // Perform strategy A logic
    }
}

class ConcreteStrategyB implements Strategy {
    @Override
    public void doOperation() {
        System.out.println("Using Strategy B");
        // Perform strategy B logic
    }
}

// Step 3: Create the context class
class Context {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void executeOperation() {
        strategy.doOperation();
    }
}

// Step 4: Client code sets the strategy and uses the context
class Main {
    public static void main(String[] args) {
        Context context = new Context();

        // Use Strategy A
        context.setStrategy(new ConcreteStrategyA());
        context.executeOperation();
        // Output: Using Strategy A

        // Use Strategy B
        context.setStrategy(new ConcreteStrategyB());
        context.executeOperation();
        // Output: Using Strategy B
    }
}
