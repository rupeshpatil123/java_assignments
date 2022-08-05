package com.project.news.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
public class Comments {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "commentid")
	private int commentid;
	
	@Column(name = "comments")
	private String comments;
	
	@Column(name = "newsid")
	private int newsid;
	
	@Column(name = "userid")
	private int userid;

	public Comments() {
		super();
	}

	public Comments(int commentid, String comments, int newsid, int userid) {
		super();
		this.commentid = commentid;
		this.comments = comments;
		this.newsid = newsid;
		this.userid = userid;
	}

	public int getCommentid() {
		return commentid;
	}

	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getNewsid() {
		return newsid;
	}

	public void setNewsid(int newsid) {
		this.newsid = newsid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "Comments [commentid=" + commentid + ", comments=" + comments + ", newsid=" + newsid + ", userid="
				+ userid + "]";
	}
}
