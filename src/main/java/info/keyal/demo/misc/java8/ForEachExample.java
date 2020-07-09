package info.keyal.demo.misc.java8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 * Java 8 has introduced forEach method in java.lang.Iterable interface so that while writing code we focus on business logic only.
 * forEach method takes java.util.function.Consumer object as argument, so it helps in having our business logic at a separate location that we can reuse.
 * Let’s see forEach usage with simple example.
 */
public class ForEachExample {
    public static void main(String[] args) {

        // creating sample Collection
        List<Integer> myList = new ArrayList<>();
        for (int i = 0; i < 10; i++) myList.add(i);


        // traversing using Iterator
        System.out.println("Using Iterator");
        Iterator<Integer> it = myList.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            System.out.println("Collection Value:: " + i);
        }


        // traversing using enhanced for loop
        System.out.println("");
        System.out.println("Using Enhanced for loop");
        for (Integer i : myList) {
            System.out.println("Collection Value:: " + i);
        }


        // using an implementation of Consumer Functional Interface
        System.out.println("");
        System.out.println("Using For Each loop on collection using Consumer implementation class");
        MyConsumer<Integer> myConsumer = new MyConsumer<>();
        myList.forEach(myConsumer);


        // using anonymous consumer implementation
        System.out.println("");
        System.out.println("Using For Each loop on collection using anonymous consumer implementation");
        Consumer<Integer> myAnonymusConsumer= new Consumer<Integer>() {
            public void accept(Integer value) {
                System.out.println("Collection value:: " + value);
            }
        };
        myList.forEach(myAnonymusConsumer);


        // traversing using for each on collection using lambda
        // Benefit of Java 8 functional interfaces is that we can use Lambda expressions to instantiate them and avoid using bulky anonymous class implementations
        // As Consumer Interface is a functional interface, we can express it in Lambda in the form of:  (argument) -> { body }
        System.out.println("");
        System.out.println("Using For Each loop on collection using lambda");
        myList.forEach(value -> System.out.println("Collection Value:: " + value));


        // We can use method reference syntax instead of the normal Lambda syntax where a method already exists to perform an operation on the class:
        System.out.println("");
        System.out.println("Using method reference");
        myList.forEach(System.out::println);
    }
}

class MyConsumer<Integer> implements Consumer<Integer> {
    @Override
    public void accept(Integer value) {
        System.out.println("Collection value:: " + value);
    }
}
