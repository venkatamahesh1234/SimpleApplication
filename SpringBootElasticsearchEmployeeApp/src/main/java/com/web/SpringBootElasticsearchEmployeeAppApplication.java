package com.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class SpringBootElasticsearchEmployeeAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootElasticsearchEmployeeAppApplication.class, args);
	}

}
