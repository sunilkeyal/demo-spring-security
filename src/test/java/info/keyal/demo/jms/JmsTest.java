package info.keyal.demo.jms;

import info.keyal.demo.model.Customer;
import info.keyal.demo.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static info.keyal.demo.jms.Receiver.JMS;
import static info.keyal.demo.util.CustomerHelper.getFakeCustomer;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
@TestPropertySource(locations = "classpath:application-test.properties")
public class JmsTest {
    @Autowired
    private Sender sender;

    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void testReceive() throws Exception {
        Customer customer = getFakeCustomer();
        sender.sendMessage(customer);
        Thread.sleep(5000);
        assertThat(customerRepository.findAll().get(0).getStatus(), is(JMS));
    }
}
