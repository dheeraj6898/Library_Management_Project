package com.app.hib.dao;

import com.app.hib.entity.AdminEntity;

public interface AdminDaoInterface {
	public void save(AdminEntity admin);
	public AdminEntity searchByUsername(String username);
	public AdminEntity searchByEmailId(String emailId);
	public AdminEntity checkLogin(String username, String emailId, String password);
}
