package com.example.demo.models;

import java.sql.Date;
import java.sql.Time;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long blog_id;
	@Column(name="admin_id")
    private Long admin_id;
	@Column(name="blog_name")
    private String blog_name;
	@Column(name="blog_text")
    private String blog_text;
	@Column(name="publish_date")
    private Date publish_date;
	@Column(name="publish_time")
    private Time publish_time;
	
    public UserBlog(Long admin_id, String blog_name, String blog_text, Date publish_date, Time publish_time) {
		
	}
	
	public UserBlog() {
		
	}
	
    public Long getBlog_id() {
		return blog_id;
	}
	public void setBlog_id(int blog_id) {
		this.blog_id = (long) blog_id;
	}
	public Long getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = (long) admin_id;
	}
	public String getBlog_name() {
		return blog_name;
	}
	public void setBlog_name(String blog_name) {
		this.blog_name = blog_name;
	}
	public String getBlog_text() {
		return blog_text;
	}
	public void setBlog_text(String blog_text) {
		this.blog_text = blog_text;
	}
	public Date getPublish_date() {
		return publish_date;
	}
	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
	}
	public Time getPublish_time() {
		return publish_time;
	}
	public void setPublish_time(Time publish_time) {
		this.publish_time = publish_time;
	}
    
    
}
