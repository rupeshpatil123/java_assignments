package com.ecommerce.product.Repository;

import java.util.List;

import com.ecommerce.product.Entity.Product;

public interface ProductRepository {
	
	public List<Product> findAll();
	public Product findById(int id);
	public void saveProduct(Product product);
	public void deleteById(int id);
}
