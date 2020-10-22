package com.wizama.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;

	public List<Product> findAll() {
		System.out.println("findAll()");
		return productRepository.findAll();
	}

	public Product findById(Long id) {
		System.out.println("findById(" + id + ")");
		return productRepository.findById(id).orElse(null);
	}
	public Product findByName(String name) {
		System.out.println("findByName(" + name + ")");
		return productRepository.findByName(name);
	}
}
