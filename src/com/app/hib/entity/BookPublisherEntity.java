package com.app.hib.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="book_publisher")
public class BookPublisherEntity {
	
	@Id
	@GeneratedValue
	private int publisher_id;
	@Column(nullable=false)
	private String publisher_name;
	@Column(nullable=false)
	private String publisher_address;
	@Column(nullable=false)
	private String publisher_year;
	
	@OneToOne(mappedBy="bookPublisher")
	private BookDetailEntity bookDetail;

	
	
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

	public BookDetailEntity getBookDetail() {
		return bookDetail;
	}

	public void setBookDetail(BookDetailEntity bookDetail) {
		this.bookDetail = bookDetail;
	}
	

}
