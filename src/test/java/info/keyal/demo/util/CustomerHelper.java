package info.keyal.demo.util;

import info.keyal.demo.model.Customer;

public class CustomerHelper {

    /**
     * Creates and returns customer with given parameters
     *
     * @param firstName first name
     * @param lastName  last name
     * @param phone     phone number
     * @param email     email address
     * @return Customer
     */
    public static Customer getCustomer(String firstName, String lastName, String phone, String email) {
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setPhone(phone);
        customer.setEmail(email);
        return customer;
    }
}
