package com.app.spring.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class BookSubjectDto {
	private int book_sub_id;
	@NotNull
	@NotEmpty
	private String book_sub_name;
	
	private List<BookDetailDto> bookDetail;
	
	
	public int getBook_sub_id() {
		return book_sub_id;
	}
	public void setBook_sub_id(int book_sub_id) {
		this.book_sub_id = book_sub_id;
	}
	public String getBook_sub_name() {
		return book_sub_name;
	}
	public void setBook_sub_name(String book_sub_name) {
		this.book_sub_name = book_sub_name;
	}
	public List<BookDetailDto> getBookDetail() {
		return bookDetail;
	}
	public void setBookDetail(List<BookDetailDto> bookDetail) {
		this.bookDetail = bookDetail;
	}
	
	
}
