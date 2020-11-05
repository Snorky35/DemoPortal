package com.wizama.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
