package com.paris;

import com.paris.config.JongoConfig;
import org.jongo.Jongo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import javax.validation.Validation;
import javax.validation.Validator;

@SpringBootApplication
@ComponentScan(basePackages = "com.paris")
@Import({JongoConfig.class})
public class FoodresolverApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodresolverApplication.class, args);
	}

	@Bean
	public Validator getValidator() {
		return Validation.buildDefaultValidatorFactory().getValidator();
	}

}
