package com.app.service;

import java.io.IOException;
import java.util.List;

import com.app.spring.dto.StuFileDataDto;
import com.app.spring.dto.StudentDto;

public interface StudentServiceInterface {
	
	public void saveStudent(StudentDto student) throws IOException;
	public StudentDto getStudentById(int stuId);
	public void updateTotalBookIssuedById(int stu_Id,String task);
	public List<StudentDto> searchStudent(int sid, String sname, String scity, int startIndex);
	public StuFileDataDto getFile(Integer sid);
	public void deleteById(int sid);
	public List<StudentDto> getAllStudent();
	public double searchStudentCount(int sid, String sname, String scity);
}
