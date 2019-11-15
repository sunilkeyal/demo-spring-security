package info.keyal.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import info.keyal.demo.service.SalesService;

/**
 * Controller class for sales
 */
@RestController
@RequestMapping("/api/v1/")
public class SalesController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SalesController.class);
    private final SalesService salesService;

    @Autowired
    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    /**
     * Returns total price (in pence) for a list of fruits
     * The client will need to perform the conversion of cents to pound/pence
     *
     * @param fruits a list of fruits
     * @return total price in pence.
     */
    @PostMapping("/sales/total")
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
    @PostMapping("/sales/total/offer/apple")
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
    @PostMapping("/sales/total/offer/orange")
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
    @PostMapping("/sales/total/offer/all")
    public int getTotalPriceWithAllOffer(@RequestBody List<String> fruits) {
        LOGGER.info("Getting total price with all offer for {} ", fruits);
        return salesService.getTotalPriceWithAllOffers(fruits);
    }
}
