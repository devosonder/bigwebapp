package org.onderdal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * The type Bigwebapp application.
 * @author onder.dal
 */
@SpringBootApplication
@ComponentScan(basePackages = {"org.onderdal"})
@EnableJpaRepositories(basePackages = {"org.onderdal"})
public class BigwebappApplication {

    /**
     * The entry point of application.
     * @author onder.dal *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(BigwebappApplication.class, args);
    }
}
