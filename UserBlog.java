package com.example.demo.models;







import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name="UserBlog")
public class UserBlog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long blogId;
//	@Column(name="admin_id")
//    private Long admin_id;
	@Column(name="Title")
    private String title;
	
	@JdbcTypeCode(SqlTypes.LONG32VARCHAR)
	@Column(name="Text")
    private String text;
	
	
    public UserBlog(String title, String text) {
		super();
		this.title=title;
		this.text=text;
	}
	
	public UserBlog() {
		
	}
	
   
public Long getBlogId() {
		return blogId;
	}

	public void setBlogId(Long blogId) {
		this.blogId = blogId;
	}

	//	public Long getAdmin_id() {
//		return admin_id;
//	}
//	public void setAdmin_id(int admin_id) {
//		this.admin_id = (long) admin_id;
//	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
}
