package com.project.news.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "news")
public class News {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name ="newsid" )
	private int newsid;
	
	@Column(name ="author" )
	private String author;
	
	@Column(name ="title" )
	private String title;
	
	@Column(name ="newsurl" )
	private String newsurl;
	
	@Column(name ="imageurl" )
	private String imageurl;
	
	@Column(name ="content" )
	private String content;
	
	@Column(name ="description" )
	private String description;
	
	@Column(name ="categoryid" )
	private int categoryid;

	public News() {
		super();
	}

	public News(int newsid, String author, String title, String newsurl, String imageurl, String content,
			String description, int categoryid) {
		super();
		this.newsid = newsid;
		this.author = author;
		this.title = title;
		this.newsurl = newsurl;
		this.imageurl = imageurl;
		this.content = content;
		this.description = description;
		this.categoryid = categoryid;
	}

	public int getNewsid() {
		return newsid;
	}

	public void setNewsid(int newsid) {
		this.newsid = newsid;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNewsurl() {
		return newsurl;
	}

	public void setNewsurl(String newsurl) {
		this.newsurl = newsurl;
	}

	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	@Override
	public String toString() {
		return "News [newsid=" + newsid + ", author=" + author + ", title=" + title + ", newsurl=" + newsurl
				+ ", imageurl=" + imageurl + ", content=" + content + ", description=" + description + ", categoryid="
				+ categoryid + "]";
	}
	
	
	
	
	
	
	
	

}
