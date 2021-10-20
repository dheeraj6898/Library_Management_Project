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

import com.app.hib.entity.StudentEntity;
import com.app.hib.entity.StudentFileEntity;

@Repository
public class StudentDao implements StudentDaoInterface{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void save(StudentEntity studentEntity) {
		sessionFactory.getCurrentSession().save(studentEntity);
		
	}

	@Override
	public StudentEntity getStudentById(int stuId) {
		
		StudentEntity sEntity=(StudentEntity) sessionFactory.getCurrentSession().get(StudentEntity.class,stuId);
		return sEntity;
	}

	@Override
	public void update(StudentEntity student) {
		sessionFactory.getCurrentSession().update(student);
	}

	@Override
	public List<StudentEntity> searchStudent(int sid, String sname,String scity,int startIndex) {
		
		Session session=sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(StudentEntity.class);
		
		if(sid>0){
			criteria.add(Restrictions.eq("stu_Id", sid));
		}
		if(sname!=null && !sname.trim().isEmpty()){
			criteria.add(Restrictions.like("stu_name", sname,MatchMode.START));
		}
		if(scity!=null && !scity.trim().isEmpty()){
			criteria.add(Restrictions.like("address.city", scity,MatchMode.START));
		}
		criteria.setFirstResult(startIndex);
		criteria.setMaxResults(3);
		List<StudentEntity> studentList=criteria.list();
		return studentList;
		
		
	}

	@Override
	public StudentFileEntity getFileByStudentId(int sid) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from StudentFileEntity where student.stu_Id=?");
		query.setInteger(0, sid);
		StudentFileEntity fileEntity=(StudentFileEntity) query.uniqueResult();
		return fileEntity;
	}

	@Override
	public void deleteById(int sid) {
		StudentEntity student=(StudentEntity) sessionFactory.getCurrentSession().get(StudentEntity.class, sid);
		sessionFactory.getCurrentSession().delete(student);
	}

	@Override
	public List<StudentEntity> getAllStudent() {
		
		return sessionFactory.getCurrentSession().createCriteria(StudentEntity.class).list();
	}

	

	@Override
	public double searchStudentCount(int sid, String sname, String scity) {

		Session session=sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(StudentEntity.class);
		
		if(sid>0){
			criteria.add(Restrictions.eq("stu_Id", sid));
		}
		if(sname!=null && !sname.trim().isEmpty()){
			criteria.add(Restrictions.like("stu_name", sname,MatchMode.START));
		}
		if(scity!=null && !scity.trim().isEmpty()){
			criteria.add(Restrictions.like("address.city", scity,MatchMode.START));
		}
		List<StudentEntity> studentList=criteria.list();
		
		return studentList.size();
	}
	
}
