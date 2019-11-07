package info.keyal.demo.service;

import info.keyal.demo.model.Customer;
import info.keyal.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Customer service
 */
@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.saveAndFlush(customer);
    }

    public List<Customer> getAllCustomer() {
        return  customerRepository.findAll();
    }
}
