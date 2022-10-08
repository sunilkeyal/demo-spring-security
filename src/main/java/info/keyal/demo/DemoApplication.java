package info.keyal.demo;

import info.keyal.demo.commandlinerunner.DemoCommandLineRunner;
import info.keyal.demo.jms.Sender;
import info.keyal.demo.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class DemoApplication implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoApplication.class);
    private final Sender sender;

    public DemoApplication(Sender sender) {
        this.sender = sender;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    /**
     * These Command Line Runners are here to test various technologies during spring boot server startup
     * If you don't want to run them, just comment them out inside rum method below.
     *
     * @param args
     */
    @Override
    public void run(String... args) {
        activeMQCommandLineRunner();
    }

    /**
     * This requires activeMQ to be running locally.
     * Check README.md for how to install in docker container.
     * functional interface lambda is being used here
     */
    private void activeMQCommandLineRunner() {
        DemoCommandLineRunner activeMQCommandLintRunner = () -> {
            log.info("************************** activeMQCommandLineRunner *************************  ");
            Customer customer = Customer.builder().firstName("Sunil").lastName("Keyal").email("test@test.com").build();
            sender.sendMessage(customer);
        };
        activeMQCommandLintRunner.start();
    }
}
