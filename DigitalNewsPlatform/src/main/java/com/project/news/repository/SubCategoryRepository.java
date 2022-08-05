package com.project.news.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.project.news.entity.SubCategory;

@RepositoryRestResource(path="subcategory")
@CrossOrigin("http://localhost:4200/")
public interface SubCategoryRepository extends JpaRepository<SubCategory, Integer>{

}
