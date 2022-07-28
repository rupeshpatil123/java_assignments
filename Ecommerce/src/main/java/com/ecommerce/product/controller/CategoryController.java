package com.ecommerce.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.product.Entity.Category;
import com.ecommerce.product.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	 
	@Autowired
	CategoryService catservice;
	@GetMapping("/catlist")
	public List<Category>findAll(){
		
		return catservice.findAll();
		
	}
	
	
	

}
