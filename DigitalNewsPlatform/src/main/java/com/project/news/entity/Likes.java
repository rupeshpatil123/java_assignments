package com.project.news.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "likes")
public class Likes {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "likeid")
	private int likeid;
	
	
	
	@Column(name = "newsid")
	private int newsid;
	
	@Column(name = "userid")
	private int userid;

	public Likes() {
		super();
	}

	public Likes(int likeid,  int newsid, int userid) {
		super();
		this.likeid = likeid;
		
		this.newsid = newsid;
		this.userid = userid;
	}

	public int getLikeid() {
		return likeid;
	}

	public void setLikeid(int likeid) {
		this.likeid = likeid;
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
		return "Likes [likeid=" + likeid  + ", newsid=" + newsid + ", userid=" + userid
				+ "]";
	}	
}
