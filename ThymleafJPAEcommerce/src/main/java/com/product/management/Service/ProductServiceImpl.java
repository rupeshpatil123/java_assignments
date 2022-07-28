package com.product.management.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.management.Entity.Product;
import com.product.management.Repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository prodRepo;

	public List<Product> findAll() {

		return prodRepo.findAll();
	}

	public void save(Product p) {
		prodRepo.save(p);

	}

	public Product findById(int id) {

		Optional<Product> p = prodRepo.findById(id);
		Product prod = null;
		if (p.isPresent())
			prod = p.get();
		return prod;
	}

	public void deleteById(int id) {
		prodRepo.deleteById(id);

	}

}
