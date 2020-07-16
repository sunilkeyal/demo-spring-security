package info.keyal.demo.tutorial.java8;

/**
 * lambda can be used to create instance of functional interfaces
 */
public class LambdaExample {
    public static void main(String[] args) {

        MathOperation addition = (a, b) -> a + b;

        // The above code is similar to below

//        MathOperation addition = new MathOperation() {
//            @Override
//            public int operation(int a, int b) {
//                return a + b;
//            }
//        };
        System.out.println(addition.operation(20, 10));

        MathOperation subtraction = (a, b) -> a - b;
        System.out.println(subtraction.operation(20, 10));

        MathOperation multiplication = (a, b) -> a * b;
        System.out.println(multiplication.operation(20, 10));

        MathOperation division = (a, b) -> a / b;
        System.out.println(division.operation(20, 10));

    }
}


@FunctionalInterface
interface MathOperation {
    int operation(int a, int b);

}
