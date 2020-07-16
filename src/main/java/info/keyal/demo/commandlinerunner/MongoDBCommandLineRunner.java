package info.keyal.demo.commandlinerunner;

import info.keyal.demo.model.CustomerDocument;
import info.keyal.demo.repository.CustomerDocumentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * This is test  for Mongo DB tutorial. This starts during DemoApplication startup.
 */
@Slf4j
@Component
public class MongoDBCommandLineRunner {
    private final CustomerDocumentRepository repository;

    /**
     * As of Spring 4.3, classes with a single constructor can omit the @Autowired annotation.
     * A nice little bit of convenience and boilerplate removal!
     */
    public MongoDBCommandLineRunner(CustomerDocumentRepository repository) {
        this.repository = repository;
    }

    public void start() {
        log.info("************************** Starting MongoDBCommandLineRunner *************************  ");
        repository.deleteAll();

        // save a couple of customers
        repository.save(new CustomerDocument("Alice", "Smith"));
        repository.save(new CustomerDocument("Bob", "Smith"));

        // fetch all customers
        log.info("**** Customers found with findAll():");
        for (CustomerDocument customer : repository.findAll()) {
            log.info(customer.toString());
        }

        // fetch an individual customer
        log.info("**** Customer found with findByFirstName('Alice'):");
        log.info(repository.findByFirstName("Alice").toString());

        log.info("**** Customers found with findByLastName('Smith'):");
        for (CustomerDocument customer : repository.findByLastName("Smith")) {
            log.info(customer.toString());
        }
    }
}
