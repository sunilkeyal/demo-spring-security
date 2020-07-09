package info.keyal.demo.misc.myinterface;

public class MyInterfaceImplementation implements  MyInterface, MyInterface2 {

    @Override
    public int multiply(int a, int b) {
        System.out.println(HELLO_WORLD + " multiplying");
        return a * b;
    }

    @Override
    public int divide(int a, int b) {
        System.out.println(HELLO_WORLD + " dividing");
        if (b != 0) {
            return a/b;
        } else {
            throw new RuntimeException("Cannot divide by zero");
        }
    }

    // duplicate default method is present in both Interfaces.
    // If the implementation class implements both interfaces, it must override this method (as done in this class)
    @Override
    public void duplicate(String str) {
        System.out.println("str in duplicate method in implementation is " + str);
    }
}
