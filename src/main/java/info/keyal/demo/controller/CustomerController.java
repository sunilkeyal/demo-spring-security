package info.keyal.demo.controller;

import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
     * Only user with ROLE_ADMIN or ROLE_USER authorities can get a list of customers
     *
     * @return List of Customers
     */
    @GetMapping(path = "/customers")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER')")
    public @ResponseBody
    ResponseEntity<List<Customer>> getCustomers() {
        LOGGER.info("Getting all customers");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof DemoUserDetails) {
            DemoUserDetails principal = (DemoUserDetails) authentication.getPrincipal();
            LOGGER.info("logged in user name: {}, authorities: {}", principal.getUsername(), principal.getAuthorities());
        }
        return ResponseEntity.ok(customerService.getAllCustomer());
    }

    /**
     * Get a customer by id
     *
     * Only user with ROLE_ADMIN or ROLE_USER authorities can get a customer
     *
     * @param customerId customer id
     * @return Customer
     */
    @GetMapping(value="/customers/{customerId}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER')")
    public @ResponseBody
    ResponseEntity<Customer> getCustomer(@PathVariable Integer customerId) {
        LOGGER.info("Getting customer {}", customerId);
        Customer customer = customerService.getCustomer(customerId);
        return new ResponseEntity<>(customer, OK);
    }

    /**
     * Create new customer with given Customer object
     * Only user with ROLE_ADMIN or ROLE_USER authorities can create a customer
     *
     * @param customer customer object
     * @return ResponseEntity with created customer
     */
    @PostMapping(path = "/customers")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER')")
    public @ResponseBody
    ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer) {
        LOGGER.info("Creating customer {}", customer);
        return ResponseEntity.ok(customerService.saveCustomer(customer));
    }

    /**
     * Delete a customer
     * Only user with ROLE_ADMIN authority can delete a customer
     *
     * @param customerId customer id
     * @return void
     */
    @DeleteMapping(value = "/customers/{customerId}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public @ResponseBody
    ResponseEntity<Void> deleteCustomer(@PathVariable Integer customerId) {
        LOGGER.info("Deleting customer {}", customerId);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof DemoUserDetails) {
            DemoUserDetails principal = (DemoUserDetails) authentication.getPrincipal();
            LOGGER.info("logged in user name: {}, authorities: {}", principal.getUsername(), principal.getAuthorities());
        }
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<>(OK);
    }
}
