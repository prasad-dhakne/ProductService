package com.prasad.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.prasad.exceptions.ProductNotFoundException;
import com.prasad.models.Product;
import com.prasad.repositories.ProductRepository;

@Service
public class SelfProductService implements ProductService{
	
	ProductRepository productRepository;
	
	public SelfProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public Product getProductById(Long id) throws ProductNotFoundException {
		Optional<Product> product = productRepository.findById(id);
		if(product.isEmpty()) {
			throw new ProductNotFoundException(id, "product not found with id " + id);
		}
		return product.get();
	}

	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}

}
