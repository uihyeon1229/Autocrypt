package com.autocrypt.autocrypt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AutocryptApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutocryptApplication.class, args);
    }

}
