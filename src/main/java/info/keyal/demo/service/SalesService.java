package info.keyal.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Sales service
 */
@Service
public class SalesService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SalesService.class);
    private static final int APPLE_PRICE = 60;
    private static final int ORANGE_PRICE = 25;

    /**
     * Returns total price (in pence) for a list of fruits
     * The client will need to perform the conversion of pence to pound/pence
     *
     * @param fruits a list of fruits
     * @return total price in pence.
     */
    public int getTotalPrice(List<String> fruits) {
        LOGGER.debug("Calculating fruits price ");
        return (int) fruits.stream().filter("apple"::equalsIgnoreCase).count() * APPLE_PRICE +
                (int) fruits.stream().filter("orange"::equalsIgnoreCase).count() * ORANGE_PRICE;
    }

    /**
     * Returns total price (in pence) for a list of fruits
     * This method contains buy 1 apple, get 1 free apple offer
     * *
     * The client will need to perform the conversion of cents to pound/pence
     *
     * @param fruits a list of fruits
     * @return total price in pence with given offer
     */
    @PostMapping("/total/offer/apple")
    public int getTotalPriceWithAppleOffer(List<String> fruits) {
        LOGGER.debug("Calculating fruits prices with offer");

        int totalApples = getAppleCount(fruits);
        LOGGER.info("Total Apples = {} ", totalApples);

        int totalOranges = getOrangeCount(fruits);
        LOGGER.info("Total Oranges = {}", totalOranges);

        // Buy 1, get 1 apple free
        int totalApplesWithOffer = totalApples - totalApples / 2;
        LOGGER.info("total apple with offer = {}", totalApplesWithOffer);

        return totalApplesWithOffer * APPLE_PRICE + totalOranges * ORANGE_PRICE;
    }


    /**
     * Returns total price (in pence) for a list of fruits
     * This method contains the Buy 2 oranges, and get 1 free orange offer
     * *
     * The client will need to perform the conversion of cents to pound/pence
     *
     * @param fruits a list of fruits
     * @return total price in pence with given offer
     */
    @PostMapping("/total/offer/orange")
    public int getTotalPriceWithOrangeOffer(List<String> fruits) {
        LOGGER.debug("Calculating fruits prices with offer");

        int totalApples = getAppleCount(fruits);
        LOGGER.info("Total Apples = {} ", totalApples);

        int totalOranges = getOrangeCount(fruits);
        LOGGER.info("Total Oranges = {}", totalOranges);

        // Buy 2, get 1 orange free
        int totalOrangesWithOffer = totalOranges - totalOranges / 3;
        LOGGER.info("total orange with offer = {}", totalOrangesWithOffer);

        return totalApples * APPLE_PRICE + totalOrangesWithOffer * ORANGE_PRICE;
    }

    /**
     * Returns total price (in pence) for a list of fruits
     * This method contains the following offer
     * - Buy 1 apple, get 1 free apple
     * - Buy 2 oranges, and get 1 free orange
     * The client will need to perform the conversion of pence to pound/pence
     *
     * @param fruits a list of fruits
     * @return total price in pence with given offer
     */
    public int getTotalPriceWithAllOffers(List<String> fruits) {
        LOGGER.debug("Calculating fruits prices with offer");

        int totalApples = getAppleCount(fruits);
        LOGGER.info("Total Apples = {} ", totalApples);

        int totalOranges = getOrangeCount(fruits);
        LOGGER.info("Total Oranges = {}", totalOranges);

        // Buy 1, get 1 apple free
        int totalApplesWithOffer = totalApples - totalApples / 2;
        LOGGER.info("total apple for calculation purpose = {}", totalApplesWithOffer);

        // Buy 2, get 1 orange free
        int totalOrangesWithOffer = totalOranges - totalOranges / 3;
        LOGGER.info("total orange for calculation = {}", totalOrangesWithOffer);

        return totalApplesWithOffer * APPLE_PRICE + totalOrangesWithOffer * ORANGE_PRICE;
    }

    /**
     * Method to return total apple count from the list
     *
     * @param fruits list of fruits
     * @return total count of apples
     */
    private int getAppleCount(List<String> fruits) {
        return (int) fruits.stream().filter("apple"::equalsIgnoreCase).count();
    }

    /**
     * Method to return total orange count from the list
     *
     * @param fruits list of fruits
     * @return total count of oranges
     */
    private int getOrangeCount(List<String> fruits) {
        return (int) fruits.stream().filter("orange"::equalsIgnoreCase).count();
    }

}
