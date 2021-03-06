package com.app.spring.dto;

import org.hibernate.validator.constraints.NotEmpty;

public class BookAuthorDto {
	private int author_id;
	@NotEmpty 
	private String author_name;
	
	public int getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	public String getAuthor_name() {
		return author_name;
	}
	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}
	@Override
	public String toString() {
		return "BookAuthorDto [author_id=" + author_id + ", author_name=" + author_name + "]";
	}
	
	
		
}
