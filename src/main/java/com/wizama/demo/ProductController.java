package com.wizama.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {
	
	@Autowired
	ProductService productService;

	@GetMapping("/all")
	public ResponseEntity<List<Product>> findAllProducts() {
		return new ResponseEntity<List<Product>>(productService.findAll(), HttpStatus.OK);
	}
	@GetMapping("byId/{id}")
	public ResponseEntity<Product> findProductById(@PathVariable long id) {
		return new ResponseEntity<Product>(productService.findById(id), HttpStatus.OK);
	}
	@GetMapping("byName/{name}")
	public ResponseEntity<Product> findProductByName(@PathVariable String name) {
		return new ResponseEntity<Product>(productService.findByName(name), HttpStatus.OK);
	}
}
