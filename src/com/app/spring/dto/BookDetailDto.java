package com.app.spring.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


public class BookDetailDto {
	private int book_id;
	@NotEmpty
	private String book_name;
	@NotNull
	private String book_title;
	@NotEmpty
	private String book_language;
	@NotEmpty
	private String book_description;
	@NotEmpty
	private String book_price;
	
	private Date book_reg_date; 
	
	private int book_available;
	
	
	
	private BookSubjectDto bookSubject;
	
	private List<BookAuthorDto> bookAuthor;
	
	private BookPublisherDto bookPublisher;
	
	
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getBook_title() {
		return book_title;
	}
	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}
	public String getBook_language() {
		return book_language;
	}
	public void setBook_language(String book_language) {
		this.book_language = book_language;
	}
	public String getBook_description() {
		return book_description;
	}
	public void setBook_description(String book_description) {
		this.book_description = book_description;
	}
	public String getBook_price() {
		return book_price;
	}
	public void setBook_price(String book_price) {
		this.book_price = book_price;
	}
	public Date getBook_reg_date() {
		return book_reg_date;
	}
	public void setBook_reg_date(Date book_reg_date) {
		this.book_reg_date = book_reg_date;
	}
	public BookSubjectDto getBookSubject() {
		return bookSubject;
	}
	public void setBookSubject(BookSubjectDto bookSubject) {
		this.bookSubject = bookSubject;
	}
	public List<BookAuthorDto> getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(List<BookAuthorDto> bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public BookPublisherDto getBookPublisher() {
		return bookPublisher;
	}
	public void setBookPublisher(BookPublisherDto bookPublisher) {
		this.bookPublisher = bookPublisher;
	}
	public int getBook_available() {
		return book_available;
	}
	public void setBook_available(int book_available) {
		this.book_available = book_available;
	}
	
	
	
	
	
	
}
