package com.project.news.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.project.news.entity.Likes;

@RepositoryRestResource(path="likes")
@CrossOrigin("http://localhost:4200/")
public interface LikesRepository extends JpaRepository<Likes, Integer>{
//	
//	@Query("select l.newsid, count(l.newsid)from Likes as l group by l.newsid order by l.newsid ")
//	public List<Likes[]> countLikes();

}
