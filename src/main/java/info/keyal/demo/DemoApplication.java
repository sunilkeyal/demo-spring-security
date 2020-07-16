package info.keyal.demo;

import info.keyal.demo.commandlinerunner.ActiveMQCommandLineRunner;
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
    private final ActiveMQCommandLineRunner activeMQCommandLineRunner;

    public DemoApplication(MongoDBCommandLineRunner mongoDBCommandLineRunner,
                           ActiveMQCommandLineRunner activeMQCommandLineRunner) {
        this.mongoDBCommandLineRunner = mongoDBCommandLineRunner;
        this.activeMQCommandLineRunner = activeMQCommandLineRunner;
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
        mongoDBCommandLineRunner();
        activeMQCommandLineRunner();
    }

    /**
     *  This needs mongodb to be running locally.
     *  Check README.md for how to install in docker container.
     */
    private void mongoDBCommandLineRunner(){
        mongoDBCommandLineRunner.start();
    }

    /**
     * This requires activeMQ to be running locally.
     * Check README.md for how to install in docker container.
     */
    private void activeMQCommandLineRunner() {
        activeMQCommandLineRunner.start();
    }
}
