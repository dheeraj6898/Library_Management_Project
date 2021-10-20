package com.app.hib.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="book_subject")
public class BookSubjectEntity {
	
	@Id
	@GeneratedValue
	private int book_sub_id;
	@Column(nullable=false,unique=true)
	private String book_sub_name;
	
	@OneToMany(mappedBy="bookSubject",cascade=CascadeType.ALL)
	private List<BookDetailEntity> bookDetail;

	
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

	public List<BookDetailEntity> getBookDetail() {
		return bookDetail;
	}

	public void setBookDetail(List<BookDetailEntity> bookDetail) {
		this.bookDetail = bookDetail;
	}
	
	
	
}
