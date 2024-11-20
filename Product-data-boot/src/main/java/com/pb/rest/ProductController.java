package com.pb.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pb.dto.ProductDto;
import com.pb.entity.Product;
import com.pb.service.ProductService;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping(value="/product")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@PostMapping(value="/list",consumes = "application/json")
	public ResponseEntity<List<Product>> list() {
		return new ResponseEntity<List<Product>>(service.list(),HttpStatus.OK);
	}

	
	@PostMapping(value="/add",consumes = "application/json")
	public ResponseEntity<String> add(@RequestBody @Valid ProductDto p){
		service.save(p);
		return new ResponseEntity<String>("Product added",HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{code}")
	public ResponseEntity<String> remove(@PathVariable int code){
		service.delete(code);
		return new ResponseEntity<String>("Product deleted",HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/price", produces = "application/json")
	public ResponseEntity<List<Product>> byPriceRange(@RequestParam double min,@RequestParam double max){
		return new ResponseEntity<List<Product>>(service.listByPriceRange(min,max), HttpStatus.OK);
	}
	
	@GetMapping(value = "/lowhigh", produces = "application/json")
	public ResponseEntity<List<Product>> byPriceAsc(){
		return new ResponseEntity<List<Product>>(service.listByPriceLowToHigh(), HttpStatus.OK);///check once
	}
	
	@GetMapping(value = "/{cat}", produces = "application/json")
	public ResponseEntity<List<Product>> byCategory(@PathVariable("cat") String category) {
	    return new ResponseEntity<List<Product>>(service.listByCategory(category), HttpStatus.OK);
	}
	

}
