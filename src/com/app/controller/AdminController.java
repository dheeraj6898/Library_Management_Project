package com.app.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;
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

import com.app.hib.entity.AdminEntity;
import com.app.service.AdminServiceInterface;
import com.app.spring.dto.AdminDto;

@Controller
public class AdminController {
	
	@Autowired
	AdminServiceInterface adminService;
	
	@RequestMapping("/adminSignUp")
	public ModelAndView adminSignUp(){
		AdminDto admin=new AdminDto();
		ModelAndView mav=new ModelAndView("AdminSignUp","admin",admin);
		return mav;
	}
	
	@RequestMapping(value="/adminSaved",method=RequestMethod.POST)
	public String adminSaved(@Valid @ModelAttribute("admin") AdminDto admin,BindingResult result){
		
		if(result.hasErrors()){
			return "AdminSignUp";
		}
		admin.setJoinDate(new Date());
		
		if(adminService.searchByUsername(admin.getUsername())!=null){
			result.rejectValue("username","duplicate.username","Username already exists");
			return "AdminSignUp";
		}
		
		if(adminService.searchByEmailId(admin.getEmailId())!=null){
			result.rejectValue("emailId","duplicate.emailId","Email Id already exists");
			return "AdminSignUp";
		}
		
		adminService.adminSaved(admin);
		
		return "AdminLogin";
	}
	
	@RequestMapping("/adminLogin")
	public String adminLogin(){
		return "AdminLogin"; 
	}
	
	@RequestMapping(value="/checkLogin",method=RequestMethod.POST)
	public String checkLogin(@RequestParam("username") String username,@RequestParam("username") String emailId,@RequestParam("password") String password, HttpSession session,Model model){
		
		AdminDto librarian=adminService.checkLogin(username,emailId,password);
		if(librarian!=null){
			session.setAttribute("librarian",librarian);
			return "Home";
		}
		
		model.addAttribute("invalid","Invalid Entry");
		
		return "AdminLogin";
	}
	
	@RequestMapping(value="/goHome")
	public String goHome(HttpSession session){
		return "Home";
	}
	
	@RequestMapping("/logOut")
	public String logOut(HttpSession session){
		session.invalidate();
		return "redirect:/adminLogin";
	}
}
