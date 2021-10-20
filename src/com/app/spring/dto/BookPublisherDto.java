package com.app.spring.dto;

import org.hibernate.validator.constraints.NotEmpty;

public class BookPublisherDto {
	private int publisher_id;
	@NotEmpty
	private String publisher_name;
	@NotEmpty
	private String publisher_address;
	@NotEmpty
	private String publisher_year;
	
	private BookDetailDto bookDetail;
	
	
	public int getPublisher_id() {
		return publisher_id;
	}
	public void setPublisher_id(int publisher_id) {
		this.publisher_id = publisher_id;
	}
	public String getPublisher_name() {
		return publisher_name;
	}
	public void setPublisher_name(String publisher_name) {
		this.publisher_name = publisher_name;
	}
	public String getPublisher_address() {
		return publisher_address;
	}
	public void setPublisher_address(String publisher_address) {
		this.publisher_address = publisher_address;
	}
	public String getPublisher_year() {
		return publisher_year;
	}
	public void setPublisher_year(String publisher_year) {
		this.publisher_year = publisher_year;
	}
	public BookDetailDto getBookDetail() {
		return bookDetail;
	}
	public void setBookDetail(BookDetailDto bookDetail) {
		this.bookDetail = bookDetail;
	}
	
	
	
}
