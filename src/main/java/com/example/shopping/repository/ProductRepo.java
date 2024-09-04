package com.example.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import com.example.shopping.models.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {
	
}
