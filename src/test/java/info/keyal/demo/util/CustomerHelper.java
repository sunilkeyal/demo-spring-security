package info.keyal.demo.util;

import com.github.javafaker.Faker;

import info.keyal.demo.model.Customer;

public class CustomerHelper {
    private static Faker faker = new Faker();

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

    public static Customer getFakeCustomer() {
        Customer customer = new Customer();
        customer.setFirstName(faker.name().firstName());
        customer.setLastName(faker.name().lastName());
        customer.setPhone(faker.phoneNumber().cellPhone());
        customer.setEmail("test@test.com");
        return customer;
    }
}
