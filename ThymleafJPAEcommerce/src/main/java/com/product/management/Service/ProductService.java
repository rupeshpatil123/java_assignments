package com.product.management.Service;

import java.util.List;


import com.product.management.Entity.Product;

public interface ProductService {
	

	public List<Product> findAll();
	public void save(Product p);
	public Product findById(int id);
	public void deleteById(int id);

}
