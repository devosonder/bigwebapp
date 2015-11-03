package org.onderdal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"org.onderdal"})
@EnableJpaRepositories(basePackages = {"org.onderdal"})
public class BigwebappApplication {

    public static void main(String[] args) {
        SpringApplication.run(BigwebappApplication.class, args);
    }
}
