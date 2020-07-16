package info.keyal.demo.tutorial.myinterface;

/**
 * Interface must be created with keyword interface
 */
public interface MyInterface {

    // Since Java 8, interface can have constants.
    // They are implicit public static final and do not need to be specified.
    String HELLO_WORLD = "hello world";

    // Since Java 8, interface can have static implementation.
    static int add(int a, int b) {
        System.out.println(HELLO_WORLD + " adding");
        return a + b;
    }

    // Since Java 8, interface can have default implementation.
    default int subtract(int a, int b) {
        System.out.println(HELLO_WORLD + " subtracting");
        return a - b;
    }

    // public and abstract methods. We must need to implement these methods in implementation classes.
    int multiply(int a, int b);

    int divide(int a, int b);

    // Since java 8, interface can have default methods
    // We are creating duplicate method in both interfaces.
    default void duplicate(String str) {
        System.out.println("str in duplicate method in MyInterface is " + str);
    }

}
