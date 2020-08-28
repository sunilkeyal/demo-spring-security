package info.keyal.demo.commandlinerunner;

import info.keyal.demo.model.CustomerElasticDocument;
import info.keyal.demo.repository.CustomerElasticDocumentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ElasticSearchCommandLineRunner implements DemoCommandLineRunner {

    private final CustomerElasticDocumentRepository repository;

    public ElasticSearchCommandLineRunner(CustomerElasticDocumentRepository repository) {
        this.repository = repository;
    }

    @Override
    public void start() {
        log.info("************************** Starting ElasticSearchCommandLineRunner *************************  ");

        repository.deleteAll();

        // save a couple of customers
        repository.save(new CustomerElasticDocument("Alice", "Smith"));
        repository.save(new CustomerElasticDocument("Bob", "Smith"));

        // fetch all customers
        log.info("**** Customers found with findAll():");
        for (CustomerElasticDocument customer : repository.findAll()) {
            log.info(customer.toString());
        }

        // fetch an individual customer
        log.info("**** Customer found with findByFirstName('Alice'):");
        log.info(repository.findByFirstName("Alice").toString());

        log.info("**** Customers found with findByLastName('Smith'):");
        for (CustomerElasticDocument customer : repository.findByLastName("Smith")) {
            log.info(customer.toString());
        }
    }
}
