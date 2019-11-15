package info.keyal.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.keyal.demo.model.Customer;
import info.keyal.demo.repository.CustomerRepository;

/**
 * Customer service
 */
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /**
     * saves a customer
     *
     * @param customer the customer
     * @return saved customer
     */
    public Customer saveCustomer(Customer customer) {
        return customerRepository.saveAndFlush(customer);
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
