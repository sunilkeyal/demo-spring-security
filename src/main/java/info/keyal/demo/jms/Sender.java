package info.keyal.demo.jms;

import info.keyal.demo.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * JMS Sender
 */
@Component
public class Sender {
    private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);
    private static final String QUEUE_NAME = "demo.queue";
    private final JmsTemplate jmsTemplate;

    @Autowired
    public Sender(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    /**
     * Sends a customer object to JMS QUEUE
     *
     * @param customer Customer to send
     */
    public void sendMessage(Customer customer) {
        LOGGER.info("sending with convertAndSend() to queue < {} > ", customer);
        jmsTemplate.convertAndSend(QUEUE_NAME, customer);
    }
}
