package com.pb.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProductDto {
	
	@Min(value=99,message="product code must be 99 or above")
	private int code;
	
	@Size(min=5,message="product name must be at least 5 chars")
	private String name;
	
	@DecimalMin(value="99.00",message="product must be greater than or equal to 99.00")
	@DecimalMax(value="999.99",message="product must be less than 999.99")
	private double price;
	
	@NotNull(message = "product category must not be null")
	private String category;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public ProductDto(@Min(value = 99, message = "product code must be 99 or above") int code,
			@Size(min = 5, message = "product name must be at least 5 chars") String name,
			@DecimalMin(value = "99.00", message = "product must be greater than or equal to 99.00") @DecimalMin(value = "999.99", message = "product must be less than 999.99") double price,
			@NotNull(message = "product category mut not be null") String category) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		this.category = category;
	}
	public ProductDto() {
		super();
		
	}
}
