package com.ecommerce.product.Repository;

import java.util.List;

import com.ecommerce.product.Entity.Category;

public interface CategoryRepository {
	public List<Category> findAll();

}
