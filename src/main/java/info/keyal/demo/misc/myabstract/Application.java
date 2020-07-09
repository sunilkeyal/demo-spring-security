package info.keyal.demo.misc.myabstract;

/**
 * Main application for abstract class tutorial
 */
public class Application {

    public static void main(String[] args) {

        // This is not allowed since MyAbstract still has abstract methods
        // MyAbstract myAbstract = new MyAbstract();


        MyAbstract myAbstract = new MyAbstractExtended();

        // Call methods from extended class
        myAbstract.add(15, 10);
        myAbstract.add(10, 15);
        myAbstract.subtract( 15, 10);

        // Call method from abstract class
        myAbstract.multiply(15, 10);
    }
}
