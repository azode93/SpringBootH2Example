package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Product;
import com.demo.repository.ProductRepo;

@RestController
public class ProductController {
	
	@Autowired
	private ProductRepo repo;
	
	@PostMapping(value = "/product", consumes = "application/json")
	public ResponseEntity<String> addProduct(@RequestBody Product product){
		repo.save(product);
		return new ResponseEntity<>(" product saved ", HttpStatus.CREATED);
		
	}
	
	@GetMapping(value = "products", produces = "application/json")
	public ResponseEntity<List<Product>> products(){
		List<Product> product = repo.findAll();
		return new ResponseEntity<>(product, HttpStatus.OK);
		
	}
	

}
