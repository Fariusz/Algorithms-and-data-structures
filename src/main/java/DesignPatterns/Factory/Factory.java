package DesignPatterns.Factory;

// Step 1: Define the interface or abstract class
interface Product {
    void operation();
}

// Step 2: Create concrete classes
class ConcreteProductA implements Product {
    @Override
    public void operation() {
        System.out.println("ConcreteProductA operation");
    }
}

class ConcreteProductB implements Product {
    @Override
    public void operation() {
        System.out.println("ConcreteProductB operation");
    }
}

// Step 3: Create the factory class
class ProductFactory {
    public Product createProduct(String productType) {
        if (productType.equals("A")) {
            return new ConcreteProductA();
        } else if (productType.equals("B")) {
            return new ConcreteProductB();
        } else {
            throw new IllegalArgumentException("Invalid product type");
        }
    }
}

// Step 4: Client code uses the factory to create objects
class Main {
    public static void main(String[] args) {
        ProductFactory factory = new ProductFactory();
        Product productA = factory.createProduct("A");
        Product productB = factory.createProduct("B");

        productA.operation(); // Output: "ConcreteProductA operation"
        productB.operation(); // Output: "ConcreteProductB operation"
    }
}
