package com.example.shopping.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.shopping.models.Product;

public interface ProductService {
	Product saveProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
}
