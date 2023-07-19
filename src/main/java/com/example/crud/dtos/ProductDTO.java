package com.example.crud.dtos;

import jakarta.validation.constraints.NotNull;

public class ProductDTO {
	
	@NotNull
	private String name;
	
	@NotNull
	private double price;
	
	public ProductDTO() {
	}
	
	public ProductDTO(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
}
