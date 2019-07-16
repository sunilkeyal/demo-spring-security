package info.keyal.demo.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Sales service
 */
@Service
public class SalesService {
    /**
     * Returns total price (in CENTS) for a list of fruits
     * The client will need to perform the conversion of cents to pound/pence
     *
     * @param fruits a list of fruits
     * @return total price in pence.
     */
    public double getTotalPrice(List<String> fruits) {
        int totalApplesForCalculation = 0;
        int totalOrangesForCalculation = 0;

        int totalApples = (int) fruits.stream().filter("apple"::equalsIgnoreCase).count();

        //TODO add logger insead of System.out.println
        System.out.println("Total Apples = " + totalApples);

        int totalOranges = (int) fruits.stream().filter("orange"::equalsIgnoreCase).count();
        System.out.println("Total Oranges = " + totalOranges);

        // Every 2nd apple is free
        totalApplesForCalculation = totalApples - totalApples / 2;
        System.out.println("total apple for calculation = " + totalApplesForCalculation);

        // Every 3rd orange is free
        totalOrangesForCalculation = totalOranges - totalOranges / 3;
        System.out.println("total orange for calculation = " + totalOrangesForCalculation);

        int totalprice = totalApplesForCalculation * 3 + totalOrangesForCalculation * 4;
        System.out.println("Total Price " + totalprice);

        return totalprice;
    }
}
