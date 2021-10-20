package com.app.hib.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.hib.entity.BookIssuedEntity;

@Repository
public class BookIssuedDao implements BookIssuedDaoInterface {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public BookIssuedEntity bookIssued(BookIssuedEntity bookIssuedEntity) {
		
		sessionFactory.getCurrentSession().save(bookIssuedEntity);
		return bookIssuedEntity;
	}

	@Override
	public BookIssuedEntity getByStudentIdAndBookId(int stu_Id, int book_id) {
		Session session=sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(BookIssuedEntity.class);
		
		Criterion crt1=Restrictions.eq("student_id",stu_Id);
		Criterion crt2=Restrictions.eq("book_id",book_id);
		Criterion crt3=Restrictions.eq("return_status", 0);
		
		Conjunction conj=Restrictions.conjunction();
		conj.add(crt1);
		conj.add(crt2);
		conj.add(crt3);
		
		criteria.add(conj);
		
		BookIssuedEntity bookIssued=(BookIssuedEntity) criteria.uniqueResult();
		return bookIssued;
	}

	@Override
	public void update(BookIssuedEntity bookIssuedEntity) {
		sessionFactory.getCurrentSession().update(bookIssuedEntity);
	}

	@Override
	public BookIssuedEntity getBookIssuedById(int bookIssued_id) {
	
		BookIssuedEntity bookIssue=(BookIssuedEntity) sessionFactory.getCurrentSession().get(BookIssuedEntity.class, bookIssued_id);
		return bookIssue;
		
	}

	@Override
	public List<BookIssuedEntity> getAllByStudentId(int sid) {
		Session session=sessionFactory.getCurrentSession();
		Criteria crt=session.createCriteria(BookIssuedEntity.class);
		crt.add(Restrictions.eq("student_id",sid));
		
		List<BookIssuedEntity> bookIssued=crt.list();
		return bookIssued;
		
	}

	@Override
	public List<BookIssuedEntity> getAllByBookId(int bid) {
		Session session=sessionFactory.getCurrentSession();
		Criteria crt=session.createCriteria(BookIssuedEntity.class);
		crt.add(Restrictions.eq("book_id",bid));
		
		List<BookIssuedEntity> bookIssued=crt.list();
		return bookIssued;
	}
	

}
