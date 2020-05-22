package com.imagegrafia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.imagegrafia.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

}
