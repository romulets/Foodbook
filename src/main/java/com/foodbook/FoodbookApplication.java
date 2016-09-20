package com.foodbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages="com.foodbook.repository")
@SpringBootApplication
public class FoodbookApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodbookApplication.class, args);
	}
}
