package com.example.crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.crud.dtos.ProductDTO;
import com.example.crud.entities.Product;
import com.example.crud.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Transactional(readOnly = true)
	public List<Product> findAll(){
		
		return productRepository.findAll();
	}
	
	@Transactional
	public Product save(ProductDTO dto) {
		
		Product product = new Product(dto);
		
		return productRepository.save(product);
	}
	
	@Transactional
	public Optional<Product> update(Product product) {
		
		Optional<Product> optionalProduct = productRepository.findById(product.getId());
		
		if(optionalProduct.isPresent())
			productRepository.save(product);
		
		return optionalProduct;
	}
	
	@Transactional
	public void delete(Long id) {
		
		productRepository.deleteById(id);
	}
}
