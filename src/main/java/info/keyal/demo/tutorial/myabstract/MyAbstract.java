package info.keyal.demo.tutorial.myabstract;

/**
 * Abstract class must be declared with keyword abstract
 */
public abstract class MyAbstract {

    // Abstract class can have constructor. Interface cannot have constructors
    public MyAbstract() {
        System.out.println("MyAbstract constructor called");
    }

    // Abstract methods
    abstract void add(int a, int b);

    abstract void subtract(int a, int b);


    // Abstract class can have implemented methods.
    void multiply(int a, int b) {
        int c = a * b;
        System.out.println(" multiplying " + c);
    }
}
