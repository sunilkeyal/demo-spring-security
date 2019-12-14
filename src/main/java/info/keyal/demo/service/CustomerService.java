package info.keyal.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.keyal.demo.jms.Sender;
import info.keyal.demo.model.Customer;
import info.keyal.demo.repository.CustomerRepository;

/**
 * Customer service
 */
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final Sender sender;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, Sender sender) {
        this.customerRepository = customerRepository;
        this.sender = sender;
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
        sender.sendMessage(customer);
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
