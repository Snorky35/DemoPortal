package com.wizama.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoPortalApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(ProductRepository productRepository) {
		return args -> {
			productRepository.save(new Product(null, "SquareOne", 499));
			productRepository.save(new Product(null, "Chromacy", 29));
			productRepository.save(new Product(null, "Crystal Bay", 49));
			productRepository.save(new Product(null, "Dice Track", 69));
			productRepository.findAll().forEach(product->{
				System.out.println(product.getName());
			});
		};
	}

}
