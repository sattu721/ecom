package com.ecommerce.productservice.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ecommerce.productservice.entity.Product;
import com.ecommerce.productservice.repository.ProductRepository;

@Service
public class ProductService {

	private final ProductRepository repository;

	public ProductService(ProductRepository repository) {
		this.repository = repository;
	}

	@Cacheable("products")
	public Product getProduct(Long id) {
		return repository.findById(id).orElse(null);
	}

	public Product save(Product product) {
		return repository.save(product);
	}

}
