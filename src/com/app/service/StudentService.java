package com.app.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.app.hib.dao.StudentDaoInterface;
import com.app.hib.entity.StuAddressEntity;
import com.app.hib.entity.StudentEntity;
import com.app.hib.entity.StudentFileEntity;
import com.app.spring.dto.StuAddressDto;
import com.app.spring.dto.StuFileDataDto;
import com.app.spring.dto.StudentDto;

@Service
@Transactional
public class StudentService implements StudentServiceInterface {

	private static String UPLOAD_PATH="E:/C and C++/Eclipse Workspace/Projects/Library_Management_Project/Student files";
	
	@Autowired
	StudentDaoInterface studentDao;
	
	@Override
	public void saveStudent(StudentDto studentDto) throws IOException {
		
		StuAddressDto addressDto=studentDto.getAddress();
			
		StudentEntity studentEntity=new StudentEntity();
		StuAddressEntity addressEntity=new StuAddressEntity();
		
		if(studentDto!=null && addressDto!=null){
			BeanUtils.copyProperties(studentDto,studentEntity);
			BeanUtils.copyProperties(addressDto,addressEntity);
			studentEntity.setAddress(addressEntity);
			studentEntity.setTotal_bookIssue(0);
			studentDao.save(studentEntity);
		}
		
		Integer id=studentEntity.getStu_Id();
		
		StudentFileEntity fileEntity=new StudentFileEntity();
		fileEntity.setContentType(studentDto.getStudentFile().getContentType());
		
		String originalFileName=studentDto.getStudentFile().getOriginalFilename();
		String fileName=originalFileName.substring(0,originalFileName.lastIndexOf("."));
		String extention=originalFileName.substring(originalFileName.lastIndexOf("."));
		
		String setNewFileName=fileName+id+extention;
		fileEntity.setFileName(setNewFileName);
		saveFileInStorage(setNewFileName,studentDto.getStudentFile());
		studentEntity.setFile(fileEntity);
	}
	
	private void saveFileInStorage(String fileName,MultipartFile file) throws IOException{
		
		byte[] fileData=file.getBytes();
		File dir=new File(UPLOAD_PATH);
		if(!dir.exists()){
			dir.mkdirs();
		}
		File f=new File(dir, fileName);
		FileOutputStream fos=new FileOutputStream(f);
		fos.write(fileData);
		fos.close();
				
	}

	@Override
	public StudentDto getStudentById(int stuId) {
		StudentDto stDto=null;
		StudentEntity stEntity=studentDao.getStudentById(stuId);
		if(stEntity!=null){
			stDto=new StudentDto();
			StuAddressDto addDto=new StuAddressDto();
			
			StuAddressEntity addEntity=stEntity.getAddress();
			
			BeanUtils.copyProperties(addEntity, addDto);
			BeanUtils.copyProperties(stEntity, stDto);
			stDto.setAddress(addDto);
		}
		return stDto;
	}

	@Override
	public void updateTotalBookIssuedById(int stu_Id,String task) {
		StudentEntity student=studentDao.getStudentById(stu_Id);
		if(task.equals("issued")){
			student.setTotal_bookIssue(student.getTotal_bookIssue()+1);
		}else if(task.equals("return")){
			student.setTotal_bookIssue(student.getTotal_bookIssue()-1);
		}
		studentDao.update(student);
	}

	@Override
	public List<StudentDto> searchStudent(int sid, String sname, String scity,int startIndex) {
		 List<StudentDto> studentDtoList=null;
		 // get data form dao
		 
		 List<StudentEntity> studentEntityList=studentDao.searchStudent(sid,sname,scity,startIndex);
		 if(studentEntityList!=null && !studentEntityList.isEmpty()){
			 studentDtoList=new ArrayList<StudentDto>();
			 for(StudentEntity sEntity : studentEntityList){
				 
				 StuAddressEntity stuAddEntity=sEntity.getAddress();
				
				 StudentDto sDto=new StudentDto();
				 StuAddressDto stuAddDto=new StuAddressDto();
				 
				 BeanUtils.copyProperties(sEntity, sDto);
				 BeanUtils.copyProperties(stuAddEntity, stuAddDto);
				 
				 sDto.setAddress(stuAddDto); // set address into student dto 
				 
				 
				 studentDtoList.add(sDto); // Add in ArrayList of StudentDto type
				 
			 }
			 
		 }
		return studentDtoList;
		
	}

	@Override
	public StuFileDataDto getFile(Integer sid) {
		StudentFileEntity fileEntity=studentDao.getFileByStudentId(sid);
		if(fileEntity!=null){
			StuFileDataDto fileDto=new StuFileDataDto();
			fileDto.setContentType(fileEntity.getContentType());
			fileDto.setFileName(fileEntity.getFileName());
			byte[] data=getFileData(fileEntity.getFileName());  // get file data by file name from file location
			fileDto.setFileDate(data);  //file data in  byte array type
			return fileDto;
		}
		return null;
	}

	private byte[] getFileData(String fileName) {
		File dir=new File(UPLOAD_PATH);
		File file=new File(dir,fileName);
		byte[] data=null;
		try {
			data=FileCopyUtils.copyToByteArray(file);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public void deleteById(int sid) {
		studentDao.deleteById(sid);
	}

	@Override
	public List<StudentDto> getAllStudent() {
		List<StudentDto> studentDtoList=null;
		 // get data form dao
		 List<StudentEntity> studentEntityList=studentDao.getAllStudent();
		 if(!studentEntityList.isEmpty() && !studentEntityList.isEmpty()){
			 studentDtoList=new ArrayList<StudentDto>();
			 for(StudentEntity sEntity : studentEntityList){
				 
				 StuAddressEntity stuAddEntity=sEntity.getAddress();
				
				 StudentDto sDto=new StudentDto();
				 StuAddressDto stuAddDto=new StuAddressDto();
				 
				 BeanUtils.copyProperties(sEntity, sDto);
				 BeanUtils.copyProperties(stuAddEntity, stuAddDto);
				 
				 sDto.setAddress(stuAddDto); // set address into student dto 
				 
				 
				 studentDtoList.add(sDto); // Add in ArrayList of StudentDto type
				 
			 }
			 
		 }
		return studentDtoList;
		
	}

	@Override
	public double searchStudentCount(int sid, String sname, String scity) {
		double totalSearchData=studentDao.searchStudentCount(sid,sname,scity);
		return totalSearchData;
	}

	

}
