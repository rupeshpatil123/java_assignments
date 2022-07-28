package com.ecommerce.product.Repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.product.Entity.Category;
import com.ecommerce.product.Entity.Product;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

	@Autowired
	EntityManager entityManager;
	@Override
	public List<Category> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Category> query = currentSession.createQuery("select a from Category a", Category.class);
		List<Category> catlist = query.getResultList();

		return catlist;
	}
	 

}
