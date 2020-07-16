package info.keyal.demo.commandlinerunner;

import info.keyal.demo.model.CustomerDocument;
import info.keyal.demo.repository.CustomerDocumentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * This is a test class for Mongo DB tutorial
 */
@Component
public class MongoDBCommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(MongoDBCommandLineRunner.class);
    private final CustomerDocumentRepository repository;

    /**
     * As of Spring 4.3, classes with a single constructor can omit the @Autowired annotation.
     * A nice little bit of convenience and boilerplate removal!
     */
    public MongoDBCommandLineRunner(CustomerDocumentRepository repository) {
        this.repository = repository;
    }

    public void start() {
        repository.deleteAll();

        // save a couple of customers
        repository.save(new CustomerDocument("Alice", "Smith"));
        repository.save(new CustomerDocument("Bob", "Smith"));

        // fetch all customers
        LOGGER.info("**** Customers found with findAll():");
        for (CustomerDocument customer : repository.findAll()) {
            LOGGER.info(customer.toString());
        }

        // fetch an individual customer
        LOGGER.info("**** Customer found with findByFirstName('Alice'):");
        LOGGER.info(repository.findByFirstName("Alice").toString());

        LOGGER.info("**** Customers found with findByLastName('Smith'):");
        for (CustomerDocument customer : repository.findByLastName("Smith")) {
            LOGGER.info(customer.toString());
        }
    }
}
