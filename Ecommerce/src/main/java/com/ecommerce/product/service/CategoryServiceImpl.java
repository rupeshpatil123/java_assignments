package com.ecommerce.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.product.Entity.Category;
import com.ecommerce.product.Repository.CategoryRepositoryImpl;
@Service
public class CategoryServiceImpl  implements CategoryService{
	@Autowired
	CategoryRepositoryImpl catrepo;
	@Override
	public List<Category> findAll() {
		
		return catrepo.findAll();
	}

}
