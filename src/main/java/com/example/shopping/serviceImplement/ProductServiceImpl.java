package com.example.shopping.serviceImplement;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.shopping.models.Product;
import com.example.shopping.repository.ProductRepo;
import com.example.shopping.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepo productRepo;
	
	public ProductServiceImpl(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}
	
	@Override
	public Product saveProduct(Product product) {
		return productRepo.save(product);
	}


	@Override
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	@Override
	public Product getProductById(Long id) {
		return productRepo.findById(id).orElseThrow(
			() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"No Product present with id: "+id));
	}

	@Override
	public Product updateProduct(Long id, Product product) {
		Product existedProduct = productRepo.findById(id).orElse(null);
		if(existedProduct != null) {
			existedProduct.setName(product.getName());
			existedProduct.setPrice(product.getPrice());
			return productRepo.save(existedProduct);
		}
		return null;
	}

	@Override
	public void deleteProduct(Long id) {
		productRepo.deleteById(id);
	}

}
