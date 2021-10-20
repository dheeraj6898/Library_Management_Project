package com.app.service;



import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.hib.dao.AdminDaoInterface;
import com.app.hib.entity.AdminEntity;
import com.app.spring.dto.AdminDto;

@Service
@Transactional
public class AdminService implements AdminServiceInterface {

	@Autowired
	AdminDaoInterface adminDao;
	
	@Override
	public void adminSaved(AdminDto adminDto) {
		AdminEntity adminEntity=new AdminEntity();
		BeanUtils.copyProperties(adminDto, adminEntity);
		adminDao.save(adminEntity);
	}

	@Transactional(readOnly=true)
	@Override
	public AdminDto searchByUsername(String username) {
		AdminDto aDto=null;
		AdminEntity aEntity=adminDao.searchByUsername(username);
		if(aEntity!=null){
			aDto=new AdminDto();
			BeanUtils.copyProperties(aEntity, aDto);
		}
		
		return aDto;
		
	}

	@Transactional(readOnly=true)
	@Override
	public AdminDto searchByEmailId(String emailId) {
		AdminDto aDto=null;
		AdminEntity aEntity=adminDao.searchByEmailId(emailId);
		if(aEntity!=null){
			aDto=new AdminDto();
			BeanUtils.copyProperties(aEntity, aDto);
		}
		return aDto;
	}

	@Transactional(readOnly=true)
	@Override
	public AdminDto checkLogin(String username, String emailId, String password) {
		AdminDto aDto=null;
		AdminEntity aEntity=adminDao.checkLogin(username,emailId,password);
		if(aEntity!=null){
			aDto=new AdminDto();
			BeanUtils.copyProperties(aEntity, aDto);
		}
		return aDto;
	}

}
