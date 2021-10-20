package com.app.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.app.service.StudentServiceInterface;
import com.app.spring.dto.BookDetailDto;
import com.app.spring.dto.StuFileDataDto;
import com.app.spring.dto.StudentDto;

@Controller
public class StudentController {
	
	@Autowired
	StudentServiceInterface studentService;
	
	@RequestMapping(value="/newStudentForm")
	public ModelAndView newStudentForm(){
		
		StudentDto student=new StudentDto();
		ModelAndView mav=new ModelAndView("StudentForm","student",student);
		return mav;
				
	}
	
	@RequestMapping(value="/studentRegistration",method=RequestMethod.POST)
	public String studentRegistration(@Valid @ModelAttribute("student") StudentDto studentDto,BindingResult result,Model model){
		if(result.hasErrors()){
			return "StudentForm";
		}
		
		MultipartFile file=studentDto.getStudentFile();
		if(file.isEmpty()){
			result.rejectValue("studentFile","student.required","Photo required");
			return "StudentForm";
		}
		
		String fname=file.getOriginalFilename();
		if(!(fname.endsWith(".jpg") || fname.endsWith(".png") )){
			result.rejectValue("studentFile","student.invalid","Invalid Photo! (only jpg,png accepted)");
			return "StudentForm";
		}
		
		studentDto.setRegDate(new Date());
		System.out.println(studentDto);
		try{
			studentService.saveStudent(studentDto);
		}catch(Exception e){
			e.printStackTrace();
			model.addAttribute("error",e.getMessage());
		}
		
		model.addAttribute("successMessage","Student Registerd Successfully");
		return "Home";
		
	}
	
	@RequestMapping("/searchStudentForm")
	public String searchStudentForm(Model model){
		List<StudentDto> studentList=studentService.getAllStudent();
		model.addAttribute("studentList",studentList);
		return "StudentSearchForm";
	}
	
	@RequestMapping(value="/searchStudent")
	public ModelAndView searchStudent(@RequestParam("sid")String id,@RequestParam("sname")String sname,@RequestParam("scity")String scity,@RequestParam("page")int page){
		//System.out.println(id+"-"+sname+"-"+scity);
		ModelAndView mav=null;
		if((id==null && sname==null && scity==null) ||(id.trim().isEmpty() && sname.trim().isEmpty() && scity.trim().isEmpty())){
			mav=new ModelAndView("StudentSearchForm","error","Enter any of the detail");
			return mav;
		}
		
		int sid;
		if(id==null || id.trim().isEmpty()){
			sid=0;
		}else{
			sid=Integer.parseInt(id);
		}
		
		double totalResult=studentService.searchStudentCount(sid,sname,scity);
		int totalPage=(int) Math.ceil(totalResult/3);

		int startIndex=0;
		if(page==1){
			startIndex=0;
		}else{
			for(int i=1;i<page;i++){
				startIndex=startIndex+3;
			}
		}
		
		List<StudentDto> studentList=studentService.searchStudent(sid,sname,scity,startIndex);
		
		mav=new ModelAndView("StudentSearchForm");
		mav.addObject("studentList",studentList);
		mav.addObject("totalPage",totalPage);
		mav.addObject("sid",sid);
		mav.addObject("sname",sname);
		mav.addObject("scity",scity);
		// yaha pahle null bala logic lagana then isEmpty nahi toh exception degaa
		if(studentList==null || studentList.isEmpty()){ // agr data nahi hua toh studentList me null aayega service me logic ke karan 
			mav.addObject("error","No Search Result Found");
		}
		return mav;
		
	}
	
	@RequestMapping(value="/download")
	public HttpEntity<byte[]> getFile(@RequestParam("sid")Integer sid){
		StuFileDataDto fileData=studentService.getFile(sid);
		byte []documentBody=fileData.getFileDate();
		
		HttpHeaders header=new HttpHeaders();
		header.setContentType(fileData.getMediaType());
		header.set("Content-Disposition", "attachment; filename="+fileData.getFileName());
		header.setContentLength(documentBody.length);
		return new HttpEntity<byte[]>(documentBody, header);
	}
	
	@RequestMapping(value="/studentDetailById")
	public String studentDetailById(@RequestParam("sid")int sid,Model model){
		StudentDto student=studentService.getStudentById(sid);
		model.addAttribute("student",student);
		return "StudentDetailPage";
				
	}
	
	@RequestMapping(value="/deleteStudentById")
	public String deleteStudentById(@RequestParam("sid")int sid,Model model){
		if(studentService.getStudentById(sid).getTotal_bookIssue()==0){
			studentService.deleteById(sid);
			return "redirect:/searchStudentForm";
		}else{
			model.addAttribute("error","Books are issued by Student");
			model.addAttribute("studentList",studentService.getAllStudent()); // return list of StudentDto
			
			return "StudentSearchForm";
		}
		
	}
}
