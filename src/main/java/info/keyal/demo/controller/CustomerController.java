package info.keyal.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import info.keyal.demo.model.Customer;
import info.keyal.demo.service.CustomerService;

/**
 * Customer Controller
 */
@RestController
@CrossOrigin
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * Create new customer with given Customer object
     *
     * @param customer customer object
     * @return ResponseEntity with created customer
     */
    @PostMapping(path = "/customers")
    public @ResponseBody
    ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.saveCustomer(customer));
    }

    /**
     * Get all customers
     *
     * @return List of Customers
     */
    @GetMapping(path = "/customers")
    public @ResponseBody
    ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomer());
    }

}
