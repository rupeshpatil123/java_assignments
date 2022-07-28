package com.ecommerce.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.product.Entity.Product;
import com.ecommerce.product.Repository.ProductRepositoryImpl;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepositoryImpl productrepo;

	@Override
	public List<Product> findAll() {

		return productrepo.findAll();
	}

	@Override
	public Product findById(int id) {
		
		return productrepo.findById(id);
	}

	@Override
	public void saveProduct(Product product) {
		productrepo.saveProduct(product);
	}

	@Override
	public void deleteById(int id) {
		productrepo.deleteById(id);
		
	}

}
