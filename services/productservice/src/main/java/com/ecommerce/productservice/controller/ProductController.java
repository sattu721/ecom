package com.ecommerce.productservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.productservice.entity.Product;
import com.ecommerce.productservice.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	private final ProductService service;

	public ProductController(ProductService service) {
		this.service = service;
	}

	@PostMapping
	public Product create(@RequestBody Product product) {
		return service.save(product);
		
	}

	@GetMapping("/{id}")
	public Product get(@PathVariable Long id) {
		return service.getProduct(id);
	}

}
