package com.prasad.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prasad.exceptions.ProductNotFoundException;
import com.prasad.models.Product;
import com.prasad.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	private final ProductService productService;
	
	public ProductController(@Qualifier("selfProductService") ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws ProductNotFoundException{
		Product product = productService.getProductById(id);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}
	
	@PostMapping("/addproduct")
	public ResponseEntity<Product> addProduct(@RequestBody Product product){
		Product savedProduct = productService.save(product);
		return new ResponseEntity<>(savedProduct, HttpStatus.OK);
	}
}
