package com.app.service;

import com.app.spring.dto.AdminDto;

public interface AdminServiceInterface {
	
	public void adminSaved(AdminDto admin);
	public AdminDto searchByUsername(String username);
	public AdminDto searchByEmailId(String emailId);
	public AdminDto checkLogin(String username,String emailId,String password);
}
