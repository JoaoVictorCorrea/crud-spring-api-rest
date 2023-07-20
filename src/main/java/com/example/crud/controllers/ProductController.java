package com.example.crud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.dtos.ProductDTO;
import com.example.crud.entities.Product;
import com.example.crud.services.ProductService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts() {
	
		var result = productService.findAll();
		
		return ResponseEntity.ok(result);
	}
	
	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductDTO dto) {
		
		System.out.println(dto.getName());
		System.out.println(dto.getPrice());
		
		var result = productService.save(dto);
		
		return ResponseEntity.ok(result);
	}
	
	@PutMapping
	public ResponseEntity<Product> updateProduct(@RequestBody @Valid Product product) {
		
		var result = productService.update(product);
		
		if(result.isPresent()) 	
			return ResponseEntity.ok(result.get());
		else 
			throw new EntityNotFoundException();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable Long id) {
		
		productService.delete(id);
		
		return ResponseEntity.noContent().build();
	}
}
