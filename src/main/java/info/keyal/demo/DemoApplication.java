package info.keyal.demo;

import info.keyal.demo.commandlinerunner.MongoDBCommandLineRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoApplication.class);
    private final MongoDBCommandLineRunner mongoDBCommandLineRunner;

    public DemoApplication(MongoDBCommandLineRunner mongoDBCommandLineRunner) {
        this.mongoDBCommandLineRunner = mongoDBCommandLineRunner;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) {

        // MongoDB command line runner tests. This needs mongodb to be running locally.
        // Check README.md to install and run mongodb in docker container.
        try {
            mongoDBCommandLineRunner.start();
        } catch (Exception e) {
            LOGGER.warn("MongoDB is not running");
        }
    }
}
