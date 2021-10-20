package com.app.spring.dto;

import java.util.Date;

public class BookIssuedDto {

	private int bookIssued_id;
	
	private Date issued_date;
	private Date last_return_date;
	private Date return_date;
	private int return_status;
	private double penalty;
	
	private int book_id;
	private String book_name;
	private String book_title;
	private String book_subject;
	
	private int student_id;
	private String student_name;
	private String student_contact;
	
	
	
	public int getBookIssued_id() {
		return bookIssued_id;
	}
	public void setBookIssued_id(int bookIssued_id) {
		this.bookIssued_id = bookIssued_id;
	}
	public Date getIssued_date() {
		return issued_date;
	}
	public void setIssued_date(Date issued_date) {
		this.issued_date = issued_date;
	}
	public Date getLast_return_date() {
		return last_return_date;
	}
	public void setLast_return_date(Date last_return_date) {
		this.last_return_date = last_return_date;
	}
	public Date getReturn_date() {
		return return_date;
	}
	public void setReturn_date(Date return_date) {
		this.return_date = return_date;
	}
	public int getReturn_status() {
		return return_status;
	}
	public void setReturn_status(int return_status) {
		this.return_status = return_status;
	}
	public double getPenalty() {
		return penalty;
	}
	public void setPenalty(double penalty) {
		this.penalty = penalty;
	}
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
	public String getBook_subject() {
		return book_subject;
	}
	public void setBook_subject(String book_subject) {
		this.book_subject = book_subject;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getStudent_contact() {
		return student_contact;
	}
	public void setStudent_contact(String student_contact) {
		this.student_contact = student_contact;
	}
	
}
