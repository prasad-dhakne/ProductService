package com.prasad.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.prasad.dtos.FakeStoreProductDTO;
import com.prasad.models.Category;
import com.prasad.models.Product;

@Service
public class FakeStoreProductService implements ProductService{
	
	private RestTemplate restTemplate;
	
	public FakeStoreProductService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public Product getProductById(Long id) {
		
		FakeStoreProductDTO fakeStoreProductDTO = restTemplate
				.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDTO.class);
		
		return convertFakeStoreProductDtoToProduct(fakeStoreProductDTO);
	}
	
	private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDTO fakeStoreProductDTO) {
		
		Product product = new Product();
		product.setId(fakeStoreProductDTO.getId());
		product.setTitle(fakeStoreProductDTO.getTitle());
		product.setDescription(fakeStoreProductDTO.getDescription());
		product.setImage(fakeStoreProductDTO.getImage());
		product.setPrice(fakeStoreProductDTO.getPrice());
		
		Category category = new Category();
		category.setTitle(fakeStoreProductDTO.getCategory());
		product.setCategory(category);
		
		return product;
	}

	@Override
	public Product save(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

}
