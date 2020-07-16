package info.keyal.demo.commandlinerunner;

import info.keyal.demo.jms.Sender;
import info.keyal.demo.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * This is test for activeMQ tutorial. This starts during DemoApplication startup.
 */
@Slf4j
@Component
public class ActiveMQCommandLineRunner {
    private final Sender sender;

    public ActiveMQCommandLineRunner(Sender sender) {
        this.sender = sender;
    }

    public void start() {
        log.info("************************** Starting ActiveMQCommandLineRunner *************************  ");
        Customer customer = Customer.builder()
                .firstName("Sunil")
                .lastName("Keyal")
                .email("test@test.com")
                .build();
        sender.sendMessage(customer);
    }
}
