package DesignPatterns.Builder;

import lombok.Getter;

// Step 1: Define the builder class
class ProductBuilder {
    private String property1;
    private int property2;
    private boolean property3;

    public ProductBuilder setProperty1(String property1) {
        this.property1 = property1;
        return this;
    }

    public ProductBuilder setProperty2(int property2) {
        this.property2 = property2;
        return this;
    }

    public ProductBuilder setProperty3(boolean property3) {
        this.property3 = property3;
        return this;
    }

    public Product build() {
        // Apply construction logic and return the final object
        return new Product(property1, property2, property3);
    }
}

// Step 2: Define the product class
@Getter
class Product {
    private final String property1;
    private final int property2;
    private final boolean property3;

    public Product(String property1, int property2, boolean property3) {
        this.property1 = property1;
        this.property2 = property2;
        this.property3 = property3;
    }

    // Getters and other methods...
}

// Step 3: Client code uses the builder to create objects
class Main {
    public static void main(String[] args) {
        Product product = new ProductBuilder()
                .setProperty1("Value 1")
                .setProperty2(42)
                .setProperty3(true)
                .build();

        // Use the created product
        System.out.println(product.getProperty1());
        System.out.println(product.getProperty2());
        System.out.println(product.isProperty3());
    }
}
