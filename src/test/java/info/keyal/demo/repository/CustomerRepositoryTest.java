package info.keyal.demo.repository;

import static info.keyal.demo.util.CustomerHelper.getCustomer;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import info.keyal.demo.model.Customer;

/**
 * Tests for Customer Repository
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryTest {
    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void createCustomerTest() {
        Customer customer = getCustomer("Sunil", "Keyal", "9199248857", "sunilkeyal@hotmail.com");

        Customer savedCustomer = customerRepository.saveAndFlush(customer);
        assertThat(savedCustomer, is(notNullValue()));
        assertThat(savedCustomer.getFirstName(), equalTo("Sunil"));
        assertThat(savedCustomer.getLastName(), equalTo("Keyal"));
        assertThat(savedCustomer.getPhone(), equalTo("9199248857"));
        assertThat(savedCustomer.getEmail(), equalTo("sunilkeyal@hotmail.com"));

        List<Customer> customers = customerRepository.findAll();
        assertThat(customers, is(not(empty())));
        assertThat(customers.get(0).getFirstName(), equalTo("Sunil"));
        assertThat(customers.get(0).getLastName(), equalTo("Keyal"));
        assertThat(customers.get(0).getPhone(), equalTo("9199248857"));
        assertThat(customers.get(0).getEmail(), equalTo("sunilkeyal@hotmail.com"));
    }

    @Test
    public void deleteCustomerTest() {
        Customer customer = getCustomer("Sunil", "Keyal", "9199248857", "sunilkeyal@hotmail.com");
        Customer savedCustomer = customerRepository.saveAndFlush(customer);
        assertThat(savedCustomer, is(notNullValue()));
        assertThat(savedCustomer.getFirstName(), equalTo("Sunil"));
        assertThat(savedCustomer.getLastName(), equalTo("Keyal"));
        assertThat(savedCustomer.getPhone(), equalTo("9199248857"));
        assertThat(savedCustomer.getEmail(), equalTo("sunilkeyal@hotmail.com"));

        List<Customer> customers = customerRepository.findAll();
        assertThat(customers, is(not(empty())));
        assertThat(customers.get(0).getFirstName(), equalTo("Sunil"));
        assertThat(customers.get(0).getLastName(), equalTo("Keyal"));
        assertThat(customers.get(0).getPhone(), equalTo("9199248857"));
        assertThat(customers.get(0).getEmail(), equalTo("sunilkeyal@hotmail.com"));

        customerRepository.delete(savedCustomer);
        customers = customerRepository.findAll();
        assertThat(customers, is(empty()));
    }

    @Test(expected = ConstraintViolationException.class)
    public void invalidEmailThrowsErrorTest() {
        Customer customer = getCustomer(null, "Keyal", "9199248857", "asdf");
        customerRepository.saveAndFlush(customer);
    }
}
