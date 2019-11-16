package info.keyal.demo.controller;

import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import info.keyal.demo.model.Customer;
import info.keyal.demo.model.DemoUserDetails;
import info.keyal.demo.service.CustomerService;

/**
 * Customer Controller
 */
@RestController
@CrossOrigin
@RequestMapping("/api/v1/")
public class CustomerController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * Get list of customers
     *
     * @return List of Customers
     */
    @GetMapping(path = "/customers")
    public @ResponseBody
    ResponseEntity<List<Customer>> getCustomers() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        DemoUserDetails principal = (DemoUserDetails) authentication.getPrincipal();
        LOGGER.info("logged in user name: {}", principal.getUsername());

        return ResponseEntity.ok(customerService.getAllCustomer());
    }

    /**
     * Get a customer by id
     *
     * @param customerId customer id
     * @return Customer
     */
    @GetMapping(value="/customers/{customerId}")
    public @ResponseBody
    ResponseEntity<Customer> getCustomer(@PathVariable Integer customerId) {
        Customer customer = customerService.getCustomer(customerId);
        return new ResponseEntity<>(customer, OK);
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
     * Delete a customer
     *
     * @param customerId customer id
     * @return void
     */
    @DeleteMapping(value = "/customers/{customerId}")
    public @ResponseBody
    ResponseEntity<Void> deleteCustomer(@PathVariable Integer customerId) {
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<>(OK);
    }
}
