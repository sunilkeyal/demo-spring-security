package info.keyal.demo.jms;

import info.keyal.demo.model.Customer;
import info.keyal.demo.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.Session;

/**
 * JMS Receiver
 */
@Component
public class Receiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);
    private static final String QUEUE_NAME = "demo.queue";
    public static final String JMS = "JMS";
    private final CustomerRepository customerRepository;

    @Autowired
    public Receiver(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /**
     * A JMS Receive Customer Listener which is listening to a QUEUE
     * When a customer shows up in the queue, it updates the customer status
     *
     * @param customer Customer payload
     * @param headers  Message headers
     * @param message  message
     * @param session  session
     */
    @JmsListener(destination = QUEUE_NAME)
    public void receiveCustomer(@Payload Customer customer, @Headers MessageHeaders headers, Message message, Session session) {
        LOGGER.info("received customer : {} ", customer);
        LOGGER.info("received message : {} ", message);
        LOGGER.info("received session : {} ", session);
        LOGGER.info("received headers : {} ", headers);

        // Update customer status.
        customer.setStatus(JMS);
        customerRepository.save(customer);
    }
}
