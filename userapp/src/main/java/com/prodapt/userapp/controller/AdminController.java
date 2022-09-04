package com.prodapt.userapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.prodapt.userapp.entity.User;
import com.prodapt.userapp.entity.UserDetails;
import com.prodapt.userapp.service.UserDetailsService;
import com.prodapt.userapp.service.UserService;

@Controller
public class AdminController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@GetMapping("/homepage")
	public String showAdminPage(@ModelAttribute("user") User user) {
		return "homepage";
	}
	
	@RequestMapping("/update")
	public String showUpdateForm(@ModelAttribute("user") User user , @ModelAttribute("userdetails") UserDetails userdetails) {
		return "update";
	}
	
	@PutMapping("/updateuser")
	public ModelAndView updateUser(@ModelAttribute ("user") User user , @ModelAttribute ("userdetails") UserDetails userdetails) {
		
		ModelAndView mv = new ModelAndView();
		user.setUserDetails(userdetails);
		User userData = userService.updateUser(user);
		mv.setViewName("update");
		mv.addObject("updatedData", userData);
		
		return mv;
	}
	
	@GetMapping("/delete")
	public String delete(@ModelAttribute ("user") User user ) {
		return "delete";
		}
	
	@DeleteMapping("/deleteuser")
	public ModelAndView deleteUser(@ModelAttribute("user") User user) {
		
		userService.deleteUserById(user.getUserId());
		ModelAndView mv = new ModelAndView();
		mv.setViewName("delete");
		mv.addObject("msg", " User Successfully Deleted" );
		
		return mv;
		
	}
	
	@GetMapping("/admin")
	public String showAdmin(@ModelAttribute ("user") User user) {
		return "admin";
	}
	
	
	@GetMapping("/allusers")
	public ModelAndView getAllUsers(@ModelAttribute ("userdetails") UserDetails userdetails) {
		
		ModelAndView mv = new ModelAndView();
		List<UserDetails> usersList = userDetailsService.getUsersList();
		mv.setViewName("userslist");
		mv.addObject("usersList",usersList);
		
		
		return mv;
	}
	
}
