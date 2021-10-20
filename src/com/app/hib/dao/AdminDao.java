package com.app.hib.dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.hib.entity.AdminEntity;

@Repository
public class AdminDao implements AdminDaoInterface{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void save(AdminEntity admin) {
		sessionFactory.getCurrentSession().save(admin);
	}

	@Override
	public AdminEntity searchByUsername(String username) {
		Session session=sessionFactory.getCurrentSession();
		
		AdminEntity admin=(AdminEntity)session.bySimpleNaturalId(AdminEntity.class).load(username);
		return admin;
	}

	@Override
	public AdminEntity searchByEmailId(String emailId) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from AdminEntity where emailId=?");
		query.setString(0, emailId);
		AdminEntity admin=(AdminEntity)query.uniqueResult();
		return admin;
	}

	@Override
	public AdminEntity checkLogin(String username, String emailId, String password) {
		Session session = sessionFactory.getCurrentSession();
		Criteria crt=session.createCriteria(AdminEntity.class);
		
		crt.add(Restrictions.eq("password",password));
		
		Criterion criterion1=Restrictions.eq("username",username);
		Criterion criterion2=Restrictions.eq("emailId",emailId);
		
		crt.add(Restrictions.or(criterion1,criterion2));
		
		AdminEntity admin=(AdminEntity) crt.uniqueResult();
		return admin;
	}

}
