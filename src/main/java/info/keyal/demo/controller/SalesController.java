package info.keyal.demo.controller;

import info.keyal.demo.service.SalesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for sales
 */
@RestController
@RequestMapping("/cart/")
public class SalesController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SalesController.class);
    @Autowired
    private SalesService salesService;

    /**
     * Returns total price (in pence) for a list of fruits
     * The client will need to perform the conversion of cents to pound/pence
     *
     * @param fruits a list of fruits
     * @return total price in pence.
     */
    @PostMapping("/total")
    public int getTotalPrice(@RequestBody List<String> fruits) {
        LOGGER.info("Getting total price for {} ", fruits);
        return salesService.getTotalPrice(fruits);
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
    public int getTotalPriceWithAppleOffer(@RequestBody List<String> fruits) {
        LOGGER.info("Getting total price with apple offer for {} ", fruits);
        return salesService.getTotalPriceWithAppleOffer(fruits);
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
    public int getTotalPriceWithOrangeOffer(@RequestBody List<String> fruits) {
        LOGGER.info("Getting total price with orange offer for {} ", fruits);
        return salesService.getTotalPriceWithOrangeOffer(fruits);
    }


    /**
     * Returns total price (in pence) for a list of fruits
     *
     * This method contains the following offers
     * - Buy 1 apple, get 1 free apple
     * - Buy 2 oranges, and get 1 free orange
     * *
     * The client will need to perform the conversion of cents to pound/pence
     *
     * @param fruits a list of fruits
     * @return total price in pence with given offer
     */
    @PostMapping("/total/offer/all")
    public int getTotalPriceWithAllOffer(@RequestBody List<String> fruits) {
        LOGGER.info("Getting total price with all offer for {} ", fruits);
        return salesService.getTotalPriceWithAllOffers(fruits);
    }

    /**
     * Test Get method
     *
     * @return test hello string
     */
    @GetMapping("/test")
    public String test() {
        return "Hello from Sales Controller";
    }
}
