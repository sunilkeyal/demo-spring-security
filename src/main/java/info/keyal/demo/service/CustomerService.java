package info.keyal.demo.service;

import info.keyal.demo.model.Customer;
import info.keyal.demo.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    /**
     * As of Spring 4.3, classes with a single constructor can omit the @Autowired annotation.
     * A nice little bit of convenience and boilerplate removal!
     */
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;

    }

    /**
     * saves a customer in database and sends the customer to jms queue
     *
     * @param customer the customer
     * @return saved customer
     */
    public Customer saveCustomer(Customer customer) {
        Customer savedCustomer = customerRepository.saveAndFlush(customer);

        // Send the customer object to JMS queue for further processing.
        return savedCustomer;
    }

    /**
     * Get all customers
     *
     * @return list of customers
     */
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    /**
     * get a customer
     *
     * @param customerId customer id
     * @return Customer
     */
    public Customer getCustomer(Integer customerId) {
        return customerRepository.findById(customerId).get();
    }

    /**
     * Delete a customer
     *
     * @param customerId customer id
     */
    public void deleteCustomer(Integer customerId) {
        customerRepository.deleteById(customerId);
    }
}
