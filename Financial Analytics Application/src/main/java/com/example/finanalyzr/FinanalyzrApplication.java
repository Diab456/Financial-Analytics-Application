package com.example.finanalyzr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Mohamed Diab
 */
@SpringBootApplication
public class FinanalyzrApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinanalyzrApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
