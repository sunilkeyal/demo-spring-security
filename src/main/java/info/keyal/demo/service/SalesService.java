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
        if (totalApples > 1) {
            totalApplesForCalculation = totalApples - totalApples / 2;
        } else {
            totalApplesForCalculation = totalApples;
        }

        // Every 3rd orange is free
        if (totalOranges > 2) {
            totalOrangesForCalculation = totalOranges - totalOranges / 3;
        } else {
            totalOrangesForCalculation = totalOranges;
        }
        System.out.println("total apple for calculation = " + totalApplesForCalculation);
        System.out.println("total orange for calculation = " + totalOrangesForCalculation);


        int totalprice = totalApplesForCalculation * 60 + totalOrangesForCalculation * 25;
        System.out.println("Total Price " + totalprice);
        return totalprice;
    }
}
