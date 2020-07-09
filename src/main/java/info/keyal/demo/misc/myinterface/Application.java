package info.keyal.demo.misc.myinterface;

public class Application {

    public static void main(String[] args) {

        // Calling static method of interface
        System.out.println(MyInterface.add(10, 2));


        MyInterface myInterface = new MyInterfaceImplementation();
        // Calling default method of interface
        System.out.println(myInterface.subtract(10,2));

        // Calling abstract method implementation of interface.
        System.out.println(myInterface.multiply(10, 2));
        System.out.println(myInterface.divide(10, 2));

        // Calling duplicate method throws error
        myInterface.duplicate("hello");
    }
}
