package com.example.crud.services;

import java.util.List;

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
	
	public void save(ProductDTO dto) {
		
		Product product = new Product(dto);
		
		productRepository.save(product);
	}
}
