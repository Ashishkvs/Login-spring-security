package com.imagegrafia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imagegrafia.model.Product;
import com.imagegrafia.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "*", maxAge = 3600 , allowedHeaders="*")
@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	
	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts() {
		
		
		return ResponseEntity.ok(productService.getAllProducts());
	}

	@PostMapping
	public ResponseEntity<Product> saveProducts(@RequestBody Product product) {
		return new ResponseEntity<Product>(productService.addProduct(product),HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProducts(@PathVariable("id") int id, @RequestBody Product product) {
		
		return new ResponseEntity<Product>(productService.updateProduct(id, product),HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public Product getProductById(@PathVariable("id") int id) {
		return productService.getbyId(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProductById(@PathVariable("id") int id) {
		productService.deleteProductById(id);
		return ResponseEntity.ok("Deleted Succefully");
	}
}
