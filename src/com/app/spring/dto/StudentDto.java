package com.app.spring.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class StudentDto {

	private int stu_Id;
	
	@NotBlank
	@Size(min=1,max=50)
	private String stu_name;
	
	@NotEmpty
	private String gender;
	
	@NotNull
	private String contact;
	private int total_bookIssue;
	private Date regDate;
	
	
	private MultipartFile studentFile;
	
	private StuAddressDto address;
	
	
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
	public StuAddressDto getAddress() {
		return address;
	}
	public void setAddress(StuAddressDto address) {
		this.address = address;
	}

	public MultipartFile getStudentFile() {
		return studentFile;
	}
	public void setStudentFile(MultipartFile studentFile) {
		this.studentFile = studentFile;
	}
	public int getTotal_bookIssue() {
		return total_bookIssue;
	}
	public void setTotal_bookIssue(int total_bookIssue) {
		this.total_bookIssue = total_bookIssue;
	}
	
		
}
