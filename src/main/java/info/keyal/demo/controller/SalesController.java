package info.keyal.demo.controller;

import info.keyal.demo.service.SalesService;


import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private SalesService salesService;

    /**
     * Returns total price (in pence) for a list of fruits
     * The client will need to perform the conversion of cents to pound/pence
     *
     * @param fruits a list of fruits
     * @return total price in pence.
     */
    @PostMapping("/totalprice")
    public double getTotalPrice(@RequestBody List<String> fruits) {
        return salesService.getTotalPrice(fruits);
    }

}
