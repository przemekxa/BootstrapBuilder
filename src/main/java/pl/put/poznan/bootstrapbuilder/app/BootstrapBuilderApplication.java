package pl.put.poznan.bootstrapbuilder.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is the Spring Boot runnable class which deals with running the whole application.
 *
 * @version 1.0.0
 */
@SpringBootApplication(scanBasePackages = {"pl.put.poznan.bootstrapbuilder.rest"})
public class BootstrapBuilderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootstrapBuilderApplication.class, args);
    }
}