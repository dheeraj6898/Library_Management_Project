package com.app.hib.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="book_detail")
public class BookDetailEntity {
	@Id
	@GeneratedValue
	private int book_id;
	@Column(nullable=false)
	private String book_name;
	@Column(nullable=false,length=200)
	private String book_title;
	@Column(nullable=false)
	private String book_language;
	@Column(nullable=false,length=500)
	private String book_description;
	@Column(nullable=false)
	private String book_price;
	
	@Temporal(TemporalType.DATE)
	private Date book_reg_date; 
	
	@Column
	private int book_available;
	
	@ManyToOne
	@JoinColumn(name="subject_join_id")
	private BookSubjectEntity bookSubject;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="book_join_id")
	private List<BookAuthorEntity> bookAuthor;
	
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="publisher_join_id")
	private BookPublisherEntity bookPublisher;

	
	
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

	public BookSubjectEntity getBookSubject() {
		return bookSubject;
	}

	public void setBookSubject(BookSubjectEntity bookSubject) {
		this.bookSubject = bookSubject;
	}

	public List<BookAuthorEntity> getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(List<BookAuthorEntity> bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public BookPublisherEntity getBookPublisher() {
		return bookPublisher;
	}

	public void setBookPublisher(BookPublisherEntity bookPublisher) {
		this.bookPublisher = bookPublisher;
	}

	public int getBook_available() {
		return book_available;
	}

	public void setBook_available(int book_available) {
		this.book_available = book_available;
	}

		
	
}
