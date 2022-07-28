package com.ecommerce.product.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.product.Entity.Product;
import com.ecommerce.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService prodservice;
	
	@GetMapping("/prodlist")
	public List<Product> findAll(){
		return prodservice.findAll();
		
	}
	@GetMapping("/prodId/{id}")
	public Product findById(@PathVariable int id) {
		return prodservice.findById(id);
	}
	@PostMapping("/save")
	public void saveProduct(@RequestBody Product product) {
		prodservice.saveProduct(product);
	}
	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product product) {
		 prodservice.saveProduct(product);
		 return product;
		
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable int id) {
		Product p = prodservice.findById(id);
		if(p == null)
			throw new  RuntimeException("Product id :" + id+" details not found");
		prodservice.deleteById(id);
		return "Product :"+id +"deleted";
	}
	
	
	

}
