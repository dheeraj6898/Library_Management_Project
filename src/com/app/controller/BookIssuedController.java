package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.service.BookIssuedServiceInterface;
import com.app.service.BookServiceInterface;
import com.app.service.StudentServiceInterface;
import com.app.spring.dto.BookDetailDto;
import com.app.spring.dto.BookIssuedDto;
import com.app.spring.dto.StudentDto;

@Controller
public class BookIssuedController {

	@Autowired
	BookIssuedServiceInterface bookIssuedService;
	
	@Autowired
	StudentServiceInterface studentService;
	
	@Autowired
	BookServiceInterface bookService;
	
	@RequestMapping("/bookIssueForm")
	public String bookIssueForm(){
		return "BookIssueForm";
	}
	

	@RequestMapping(value="/bookIssuedConfirmation")
	public ModelAndView bookIssuedConfirmation(@RequestParam("stuId")int stuId,@RequestParam("bookId")int bookId ){
		ModelAndView mav;
		StudentDto student=studentService.getStudentById(stuId);
		if(student==null){
			
			mav=new ModelAndView("BookIssueForm","stuId","Student is not registerd");
			return mav;	
		}
		if(student.getTotal_bookIssue()==5){
			mav=new ModelAndView("BookIssueForm","stuId","Student is already issue 5 books");
			return mav;	
		}
		
		BookDetailDto bookDetail=bookService.getBookDetailById(bookId);
		if(bookDetail==null){
			mav=new ModelAndView("BookIssueForm","bookId","Invalid Book Id! This Book is not available in database");
			return mav;	
		}
		if(bookDetail.getBook_available()==0){
			mav=new ModelAndView("BookIssueForm","bookId","Book Already Issued!");
			return mav;	
		}
		mav=new ModelAndView("BookIssuedConfirmation");
		mav.addObject("student",student);
		mav.addObject("bookDetail",bookDetail);
		return mav;
	}
	
	
	@RequestMapping(value="/bookIssued")
	public ModelAndView bookIssued(@RequestParam("stuId")int stuId,@RequestParam("bookId")int bookId ){
		ModelAndView mav;
		StudentDto student=studentService.getStudentById(stuId);
		if(student==null){
			
			mav=new ModelAndView("BookIssueForm","stuId","Student is not registerd");
			return mav;	
		}
		if(student.getTotal_bookIssue()==5){
			mav=new ModelAndView("BookIssueForm","stuId","Student is already issue 5 books");
			return mav;	
		}
		
		BookDetailDto bookDetail=bookService.getBookDetailById(bookId);
		if(bookDetail==null){
			mav=new ModelAndView("BookIssueForm","bookId","Invalid Book Id! This Book is not available in database");
			return mav;	
		}
		if(bookDetail.getBook_available()==0){
			mav=new ModelAndView("BookIssueForm","bookId","Book Already Issued!");
			return mav;	
		}
		BookIssuedDto bookIssued=bookIssuedService.bookIssued(student,bookDetail);
		mav=new ModelAndView("BookIssuedSuccess","bookIssued",bookIssued);
		return mav;		
	}
	
	@RequestMapping("/bookReturnForm")
	public String bookReturnForm(){
		return "BookReturnForm";
	}
	
	@RequestMapping(value="/bookReturn")
	public ModelAndView bookReturn(@RequestParam("stuId")int stuId,@RequestParam("bookId") int bookId){
		 ModelAndView mav;
		StudentDto student=studentService.getStudentById(stuId);
		if(student==null){
			mav=new ModelAndView("BookReturnForm","stuId","Student is not available in database");
			return mav;
		}
		if(student.getTotal_bookIssue()==0){
			mav=new ModelAndView("BookReturnForm","stuId","Student is not issue any book");
			return mav;	
		}
		
		BookDetailDto book=bookService.getBookDetailById(bookId);
		if(book==null){
			mav=new ModelAndView("BookReturnForm","bookId","Book is not available in database");
			return mav;	
		}
		if(book.getBook_available()==1){
			mav=new ModelAndView("BookReturnForm","bookId","Book is not issued");
			return mav;	
		}
		
		BookIssuedDto bookIssued=bookIssuedService.bookReturn(student,book);
		mav=new ModelAndView("BookReturnSuccess","bookReturn",bookIssued);
		return mav;	
	}
	
	@RequestMapping(value="/studentHistoryById")
	public ModelAndView studentHistoryById(@RequestParam("sid") int sid){
		List<BookIssuedDto> bookIssued=bookIssuedService.getAllByStudentId(sid);
		StudentDto student=studentService.getStudentById(sid);
		
		ModelAndView mav=new ModelAndView("StudentHistoryById");
		mav.addObject("bookIssued",bookIssued);
		mav.addObject("student",student);
		return mav;
	}
	
	@RequestMapping(value="/bookHistoryById")
	public ModelAndView bookHistoryById(@RequestParam("bid")int bid){
		ModelAndView mav=new ModelAndView("BookHistoryById");
		List<BookIssuedDto> bookIssued=bookIssuedService.getAllByBookId(bid);
		BookDetailDto book=bookService.getBookDetailById(bid);
		
		mav.addObject("bookIssued",bookIssued);
		mav.addObject("book",book);
		return mav;
	}
	
}
