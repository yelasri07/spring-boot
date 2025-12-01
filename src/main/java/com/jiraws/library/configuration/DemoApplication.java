package com.jiraws.library.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.jiraws.library.*.model")
@EnableJpaRepositories(basePackages = "com.jiraws.library.*.persistence")
@SpringBootApplication(scanBasePackages = {
	"com.jiraws.library", "com.example.demo"
})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
