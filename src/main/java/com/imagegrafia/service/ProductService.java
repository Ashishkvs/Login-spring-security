package com.imagegrafia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imagegrafia.exception.InvalidDataException;
import com.imagegrafia.model.Product;
import com.imagegrafia.repository.ProductRepository;

import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> getAllProducts() {
		log.info("getAllProducts ->");
		return (List<Product>) productRepository.findAll();

	}

	public Product addProduct(Product product) {
		log.info("addProduct -> {}", product);
		return productRepository.save(product);
	}

	public Product getbyId(int id) {
		log.info("getbyId -> {}", id);
		return productRepository.findById(id).isPresent() ? productRepository.findById(id).get() : new Product();
		/*
		 * Optional<Product> findById = productRepository.findById(id);
		 * if(findById.isPresent()) { return findById.get(); } return null;
		 */

	}

	public Product updateProduct(int id, Product product) {
		log.info("updateProduct -> id:{}, product:{}", id, product);
		product.setId(id);
		return productRepository.save(product);
	}

	public void deleteProductById(int id) {
		log.info("deleteProductById -> {}", id);
		if (productRepository.existsById(id)) {
			productRepository.deleteById(id);
		} else {
			throw new InvalidDataException("Product id : " + id + " doesn't exist");
		}

	}

}
