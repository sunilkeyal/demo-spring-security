package info.keyal.demo.commandlinerunner;

import com.github.javafaker.Faker;
import info.keyal.demo.model.CustomerElasticDocument;
import info.keyal.demo.repository.CustomerElasticDocumentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ElasticSearchCommandLineRunner implements DemoCommandLineRunner {

    private final CustomerElasticDocumentRepository repository;
    private static Faker faker = new Faker();

    public ElasticSearchCommandLineRunner(CustomerElasticDocumentRepository repository) {
        this.repository = repository;
    }

    @Override
    public void start() {
        log.info("************************** Starting ElasticSearchCommandLineRunner *************************  ");

        repository.deleteAll();

        // save a couple of customers
        for (int i = 0; i < 20; i++) {
            log.info("Creating Customer");
            repository.save(getFakeCustomer());
        }

        repository.save(new CustomerElasticDocument("Alice", "Smith"));
        repository.save(new CustomerElasticDocument("Alice", "Taylor"));
        repository.save(new CustomerElasticDocument("Bob", "Mark"));

        // fetch all customers
        log.info("**** Customers found with findAll():");
        for (CustomerElasticDocument customer : repository.findAll()) {
            log.info(customer.toString());
        }

        // fetch an individual customer
        log.info("**** Customer found with findByFirstName('Alice'):");
        log.info(repository.findByFirstName("Bob").toString());

        log.info("**** Customers found with findByLastName('Smith'):");
        for (CustomerElasticDocument customer : repository.findByLastName("Smith")) {
            log.info(customer.toString());
        }

        log.info("**** First matched Customers found with findFirstByFirstName('Alice'):");
        log.info("Find" + repository.findFirstByFirstName("Alice"));
    }

    private static CustomerElasticDocument getFakeCustomer() {
        CustomerElasticDocument customer = new CustomerElasticDocument();
        customer.setFirstName(faker.name().firstName());
        customer.setLastName(faker.name().lastName());
        return customer;
    }
}
