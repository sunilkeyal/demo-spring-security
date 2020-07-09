package info.keyal.demo.misc.myabstract;

/**
 * Extended class which extends Abstract class and implements all methods.
 */
public class MyAbstractExtended extends MyAbstract {

    public MyAbstractExtended() {
        System.out.println("MyAbstractExtended constructor called");
    }

    @Override
    void add(int a, int b) {
        int c = a + b;
        System.out.println(" adding " + c);
    }

    @Override
    void subtract(int a, int b) {
        int c = a - b;
        System.out.println(" subtracting " + c);
    }
}
