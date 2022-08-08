package com.project.news.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.project.news.entity.News;

@RepositoryRestResource(path="news")
@CrossOrigin("http://localhost:4200/")
public interface NewsRepository extends JpaRepository<News, Integer>{
	
	public List<News> findBycategoryid(int categoryid);
	
	

}
