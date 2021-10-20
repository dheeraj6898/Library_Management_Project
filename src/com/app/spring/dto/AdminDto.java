package com.app.spring.dto;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class AdminDto {
	
	private int admin_Id;
	@NotEmpty
	@Size(min=1,max=50)
	private String admin_name;
	
	@NotEmpty
	private String username;
	
	@NotEmpty
	@Size(min=6,max=20)
	private String password;
	
	@Email
	private String emailId;
	
	@NotBlank
	private String mobile;
	
	private Date joinDate;

	public int getAdmin_Id() {
		return admin_Id;
	}

	public void setAdmin_Id(int admin_Id) {
		this.admin_Id = admin_Id;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public String toString() {
		return "AdminDto [admin_Id=" + admin_Id + ", admin_name=" + admin_name + ", username=" + username
				+ ", password=" + password + ", emailId=" + emailId + ", mobile=" + mobile + ", joinDate=" + joinDate
				+ "]";
	}
	
	 
	
}
