package com.app.hib.dao;

import java.util.List;

import com.app.hib.entity.StudentEntity;
import com.app.hib.entity.StudentFileEntity;

public interface StudentDaoInterface {
	public void save(StudentEntity studentEntity);
	public StudentEntity getStudentById(int stuId);
	public void update(StudentEntity student);
	public List<StudentEntity> searchStudent(int sid, String sname, String scity, int startIndex);
	public StudentFileEntity getFileByStudentId(int sid);
	public void deleteById(int sid);
	public List<StudentEntity> getAllStudent();
	public double searchStudentCount(int sid, String sname, String scity);
}
