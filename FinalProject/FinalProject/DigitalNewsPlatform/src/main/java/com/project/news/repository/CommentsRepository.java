package com.project.news.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;


import com.project.news.entity.Comments;

@RepositoryRestResource(path="comments")
@CrossOrigin("http://localhost:4200/")
public interface CommentsRepository extends JpaRepository<Comments, Integer>{
	
	public Comments findBycommentid(@PathVariable("commentid") int commentid);

}
