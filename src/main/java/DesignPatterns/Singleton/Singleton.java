package DesignPatterns.Singleton;

public class Singleton {
    private static Singleton instance;

    // Private constructor to prevent direct instantiation
    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    // Other methods and properties...

    class Main {
        public static void main(String[] args) {
            Singleton singleton = Singleton.getInstance();
        }
    }
}
