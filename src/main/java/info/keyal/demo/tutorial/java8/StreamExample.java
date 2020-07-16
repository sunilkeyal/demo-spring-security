package info.keyal.demo.tutorial.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {

        // creating sample Collection
        List<Integer> myList = new ArrayList<>();
        for (int i = 0; i < 100; i++) myList.add(i);

        //sequential stream
        Stream<Integer> sequentialStream = myList.stream();

        //parallel stream
        Stream<Integer> parallelStream = myList.parallelStream();

        //using lambda with Stream API, filter items greater than 90 on parallel stream
        Stream<Integer> highNums = parallelStream.filter(p -> p > 90);
        highNums.forEach(p -> System.out.println("High Nums parallel=" + p));

        //using lambda with Stream API, filter items greater than 90 on sequential stream
        Stream<Integer> highNumsSeq = sequentialStream.filter(p -> p > 90);
        highNumsSeq.forEach(p -> System.out.println("High Nums sequential=" + p));

    }

    public void asdf() {

    }


}
