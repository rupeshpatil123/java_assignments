package com.ecommerce.product.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.product.Entity.Product;

@Repository
@Transactional
public class ProductRepositoryImpl implements ProductRepository {

	@Autowired
	EntityManager entityManager;

	@Override
	public List<Product> findAll() {

		Session currentSession = entityManager.unwrap(Session.class);
		Query<Product> query = currentSession.createQuery("select a from Product a", Product.class);
		List<Product> prodList = query.getResultList();

		return prodList;

	}

	@Override
	public Product findById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		return currentSession.get(Product.class, id);
	}

	@Override
	public void saveProduct(Product product) {
		Session currentSession = entityManager.unwrap(Session.class);
		 currentSession.saveOrUpdate(product);
	}
	
	@Transactional
	public void deleteById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Product> query = currentSession.createQuery("delete from Product where id = :prodid");
		query.setParameter("prodid", id);
		query.executeUpdate();
		
	}
	

	
	

}
