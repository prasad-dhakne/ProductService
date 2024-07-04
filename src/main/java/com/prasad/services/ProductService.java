package com.prasad.services;

import com.prasad.exceptions.ProductNotFoundException;
import com.prasad.models.Product;

public interface ProductService {
	
	Product getProductById(Long id) throws ProductNotFoundException;

	Product save(Product product);
}
