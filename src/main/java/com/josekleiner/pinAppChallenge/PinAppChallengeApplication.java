package com.josekleiner.pinAppChallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EnableAutoConfiguration
@PropertySource(value={"application.properties"})
public class PinAppChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PinAppChallengeApplication.class, args);
	}

}
