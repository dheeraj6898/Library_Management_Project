package com.app.hib.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.hib.entity.BookDetailEntity;
import com.app.hib.entity.BookSubjectEntity;

@Repository
public class BookDao implements BookDaoInterface {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void saveSubject(BookSubjectEntity subject) {
		sessionFactory.getCurrentSession().save(subject);
	}

	@Override
	public BookSubjectEntity searchBySubject(String subjectName) {
		
		Session session= sessionFactory.getCurrentSession();
		Query query=session.createQuery("from BookSubjectEntity where book_sub_name = ?");
		query.setString(0,subjectName);
		BookSubjectEntity entity=(BookSubjectEntity)query.uniqueResult();
		return entity;
	}

	@Override
	public List<BookSubjectEntity> getAllSubject() {
		
		List<BookSubjectEntity> list= sessionFactory.getCurrentSession().createCriteria(BookSubjectEntity.class).list();
		return list;
	}

	@Override
	public void saveBookDetail(BookDetailEntity bookDetailEntity) {
		sessionFactory.getCurrentSession().save(bookDetailEntity);
	}

	@Override
	public BookDetailEntity getBookDetailById(int bookId) {
		
		return (BookDetailEntity) sessionFactory.getCurrentSession().get(BookDetailEntity.class, bookId);
	}

	@Override
	public void update(BookDetailEntity book) {
		sessionFactory.getCurrentSession().update(book);
	}

	@Override
	public List<BookDetailEntity> searchBook(int bid, String bname,int startIndex) {
		Session session=sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(BookDetailEntity.class);
		if(bid>0){
			criteria.add(Restrictions.eq("book_id",bid));
		}
		if(bname!=null && !bname.trim().isEmpty()){
			criteria.add(Restrictions.like("book_name",bname,MatchMode.START));
		}
		
		criteria.setFirstResult(startIndex);
		criteria.setMaxResults(3);
		List<BookDetailEntity> books=criteria.list();
		return books;
		 
	}

	@Override
	public List<BookDetailEntity> getAllBooks() {
		
		return sessionFactory.getCurrentSession().createCriteria(BookDetailEntity.class).list();
	}

	@Override
	public void deleteBookbyId(int bid) {
		BookDetailEntity book=(BookDetailEntity) sessionFactory.getCurrentSession().get(BookDetailEntity.class, bid);
		sessionFactory.getCurrentSession().delete(book);
		
	}

	@Override
	public int searchBookCount(int bid, String bname) {
		Session session=sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(BookDetailEntity.class);
		if(bid>0){
			criteria.add(Restrictions.eq("book_id",bid));
		}
		if(bname!=null && !bname.trim().isEmpty()){
			criteria.add(Restrictions.like("book_name",bname,MatchMode.START));
		}
		List<BookDetailEntity> books=criteria.list();
		int totalData=books.size();
		return totalData;
	
	}
	
}
