package info.keyal.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller class for sales
 */
@RestController
@RequestMapping("/items/")
public class SalesController {
    /**
     * Returns total price (in CENTS) for a list of fruits
     * The client will need to perform the conversion of cents to pound/pence
     *
     * @param fruits a list of fruits
     * @return total price in cents.
     */
    @PostMapping("/totalprice")
    public double getTotalPrice(@RequestBody List<String> fruits) {

        // TODO add business service method instead of performing calculation inside controller
        double totalPrice = 0d;
        for (String fruit : fruits) {
            totalPrice = totalPrice + getPrice(fruit);
        }
        return totalPrice;
    }

    /**
     * Helper method to get price of a fruit
     * TODO get price for item from database using DAO method. it is hard coded right now for simplicity
     *
     * @param fruit the fruit whose price is needed
     * @return the price of the fruit
     */
    private double getPrice(String fruit) {

        if (fruit.equalsIgnoreCase("APPLE")) {
            return 60d;
        } else if (fruit.equalsIgnoreCase("ORANGE")) {
            return 25d;
        }
        throw new RuntimeException("Invalid fruit");
    }
}
