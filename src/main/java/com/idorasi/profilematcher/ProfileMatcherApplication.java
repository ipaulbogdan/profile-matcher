package com.idorasi.profilematcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@ConfigurationPropertiesScan
public class ProfileMatcherApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProfileMatcherApplication.class, args);
    }

}
