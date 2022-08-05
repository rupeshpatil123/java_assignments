package com.project.news.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subcategory")
public class SubCategory {

	@Id
	@Column(name = "subcategoryid")
	private int subcategoryid;
	
	@Column(name = "subcategoryname")
	private String subcategoryname;
	
	@Column(name = "categoryid")
	private int categoryid;

	public SubCategory() {
		super();
	}

	public SubCategory(int subcategoryid, String subcategoryname, int categoryid) {
		super();
		this.subcategoryid = subcategoryid;
		this.subcategoryname = subcategoryname;
		this.categoryid = categoryid;
	}

	public int getSubcategoryid() {
		return subcategoryid;
	}

	public void setSubcategoryid(int subcategoryid) {
		this.subcategoryid = subcategoryid;
	}

	public String getSubcategoryname() {
		return subcategoryname;
	}

	public void setSubcategoryname(String subcategoryname) {
		this.subcategoryname = subcategoryname;
	}

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	@Override
	public String toString() {
		return "SubCategory [subcategoryid=" + subcategoryid + ", subcategoryname=" + subcategoryname + ", categoryid="
				+ categoryid + "]";
	}
}
