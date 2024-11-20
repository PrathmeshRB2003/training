package com.pb.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pb.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    
	 List<Product> findByPriceBetween(double min, double max);
	    
	    List<Product> findByCategory(String category);
	    
	    List<Product> findAllByOrderByPriceAsc();
}