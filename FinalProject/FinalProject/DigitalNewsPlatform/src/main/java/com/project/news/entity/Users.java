package com.project.news.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name  = "users")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userid")
	private int userid;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "emailid")
	private String emailid;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "isadmin")
	private boolean isadmin;

	public Users() {
		super();
	}

	public Users(int userid, String username, String emailid, String password, boolean isadmin) {
		super();
		this.userid = userid;
		this.username = username;
		this.emailid = emailid;
		this.password = password;
		this.isadmin = isadmin;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isIsadmin() {
		return isadmin;
	}

	public void setIsadmin(boolean isadmin) {
		this.isadmin = isadmin;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", emailid=" + emailid + ", password=" + password
				+ ", isadmin=" + isadmin + "]";
	}	
}