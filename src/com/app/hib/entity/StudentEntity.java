package com.app.hib.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="student_table")
public class StudentEntity {

	@Id
	@GeneratedValue
	private int stu_Id;
	
	
	private String stu_name;
	private String gender;
	private String contact;
	private int total_bookIssue;
	
	@Temporal(value=TemporalType.DATE)
	private Date regDate;
	
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="address_id")
	private StuAddressEntity address;
	
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="file_id")
	private StudentFileEntity file;
	
	
	public int getStu_Id() {
		return stu_Id;
	}
	public void setStu_Id(int stu_Id) {
		this.stu_Id = stu_Id;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public StuAddressEntity getAddress() {
		return address;
	}
	public void setAddress(StuAddressEntity address) {
		this.address = address;
	}
	public StudentFileEntity getFile() {
		return file;
	}
	public void setFile(StudentFileEntity file) {
		this.file = file;
	}
	public int getTotal_bookIssue() {
		return total_bookIssue;
	}
	public void setTotal_bookIssue(int total_bookIssue) {
		this.total_bookIssue = total_bookIssue;
	}
	

	
}
