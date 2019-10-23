package info.keyal.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import info.keyal.demo.model.Customer;
import info.keyal.demo.repository.CustomerRepository;

/**
 * Customer Controller
 */
@RestController
@RequestMapping("/cusgtomer/")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    /**
     * Add new customer with given customer parameters
     *
     * @param firstName first name
     * @param lastName  last name
     * @param phone     phone number
     * @param email     email address
     * @return
     */
    @PostMapping(path = "/add") // Map ONLY POST Requests
    public @ResponseBody
    String addNewUser(@RequestParam String firstName,
                      @RequestParam String lastName,
                      @RequestParam String phone,
                      @RequestParam String email) {

        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setPhone(phone);
        customer.setEmail(email);
        customerRepository.save(customer);
        return "Saved";
    }

    /**
     * Get all customers
     *
     * @return List of Customers
     */
    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
