package info.keyal.demo.misc.myinterface;

/**
 * Interface must be created with keyword interface
 */
public interface MyInterface2 {

    // Since java 8, interface can have default methods
    // We are creating duplicate method in both interfaces.
    default void duplicate(String str) {
        System.out.println("str in duplicate method in MyInterface2 is " + str);
    }
}
