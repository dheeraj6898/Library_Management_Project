package com.app.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.service.BookServiceInterface;
import com.app.service.StudentServiceInterface;
import com.app.spring.dto.BookAuthorDto;
import com.app.spring.dto.BookDetailDto;
import com.app.spring.dto.BookSubjectDto;

@Controller
public class BookController {

	@Autowired
	BookServiceInterface bookService;
	
	
	@RequestMapping(value="/addSubjectForm")
	public ModelAndView addSubjectForm(){
		ModelAndView mav=new ModelAndView("SubjectForm","subject",new BookSubjectDto());
		return mav;
	}
	
	@RequestMapping(value="/addSubject")
	public String addSubect(@Valid @ModelAttribute("subject")BookSubjectDto subject,BindingResult result,Model model){
		if(result.hasErrors()){
			return "SubjectForm";
		}
		if(bookService.searchBySubject(subject.getBook_sub_name())!=null){
			result.rejectValue("book_sub_name", "book_sub_name.duplicate","Subject Already exists");
			return "SubjectForm";
		}
		bookService.saveSubject(subject);
		model.addAttribute("successMessage","Subject Added Successfully!");
		return "Home";
	}
	
	@RequestMapping("/newBookForm")
	public ModelAndView newBookForm(){
		List<BookSubjectDto> list=bookService.getAllSubject();
		ModelAndView mav=new ModelAndView("BookDetailForm");
		mav.addObject("bookDetail",new BookDetailDto());
		mav.addObject("subjectList",bookService.getAllSubject());
		return mav;
	}
	
	@RequestMapping(value="/saveBookDetail",method=RequestMethod.POST)
	public String addBookData(@Valid @ModelAttribute("bookDetail")BookDetailDto bookDetail, BindingResult result,Model model){
		
		if(result.hasErrors()){
			return "BookDetailForm";
		}
		bookService.saveBookDetail(bookDetail);
		model.addAttribute("successMessage","Book Added Successfully!");
		return "Home";
		
	}
	
	@RequestMapping("/searchBookForm")
	public String bookSearchById(Model model){
		
		List<BookDetailDto> books=bookService.getAllBooks();
		model.addAttribute("books",books);
		 return "SearchBookForm";
	}
	
	@RequestMapping(value="/searchBook")
	public ModelAndView searchBook(@RequestParam("bid")String id,@RequestParam("bname")String bname,@RequestParam("page")int page){
		ModelAndView mav;
		if((id==null && bname==null) || (id.trim().isEmpty() && bname.trim().isEmpty())){
			mav=new ModelAndView("SearchBookForm","error","Enter any of the detail");
			return mav;
		}
		int bid;
		if(id==null || id.trim().isEmpty()){
			bid=0;
		}else{
			bid=Integer.parseInt(id);
		}
		double totalResult=bookService.searchBookCount(bid,bname);
		int totalPage=(int) Math.ceil(totalResult/3);

		int startIndex=0;
		if(page==1){
			startIndex=0;
		}else{
			for(int i=1;i<page;i++){
				startIndex=startIndex+3;
			}
		}
		List<BookDetailDto> books=bookService.searchBook(bid,bname,startIndex); // By pagination
		mav=new ModelAndView("SearchBookForm");
		mav.addObject("books",books);
		mav.addObject("totalPage",totalPage);
		mav.addObject("bid",bid);
		mav.addObject("bname",bname);
		if(books.isEmpty()){
			mav.addObject("error","No Search Result Found");
		}
		return mav;
	}
	
	@RequestMapping("/bookDetailById")
	public ModelAndView getBookById(@RequestParam("bid") int bookId){
		BookDetailDto bookDetail=bookService.getBookDetailById(bookId);
		ModelAndView mav=new ModelAndView("BookDetailPage","book",bookDetail);
		return mav;
	}
	
	@RequestMapping(value="deleteBookById")
	public String deleteBookById(@RequestParam("bid")int bid,Model model){
		if(bookService.getBookDetailById(bid).getBook_available()==0){
			model.addAttribute("error","Books are issued by Student");
			List<BookDetailDto> books=bookService.getAllBooks();
			model.addAttribute("books",books);
			return "SearchBookForm";
		}
		bookService.deleteBookbyId(bid);
		return "redirect:/searchBookForm";
	}
	
}
