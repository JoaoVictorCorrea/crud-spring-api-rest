package com.example.crud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.dtos.ProductDTO;
import com.example.crud.entities.Product;
import com.example.crud.services.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public List<Product> getAllProducts() {
		
		return productService.findAll();
	}
	
	@PostMapping
	public ResponseEntity createProduct(@RequestBody @Valid ProductDTO dto) {
		
		System.out.println(dto.getName());
		System.out.println(dto.getPrice());
		
		productService.save(dto);
		
		return ResponseEntity.ok().build();
	}
}
