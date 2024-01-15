package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entites.Users;
import com.example.demo.service.UsersService;

import jakarta.servlet.http.HttpSession;
@Controller
public class UserController 
{
   @Autowired
   UsersService sr;
   @PostMapping("/register")
   public String addUsers(@ModelAttribute Users user)
   {
	   boolean userStatus=sr.emailExists(user.getEmail());
	   if(userStatus==false)
	   {
		   sr.addUser(user);
		   System.out.println("User added");
	   }
	   else
	   {
		   System.out.println("user already exits");
	   }
	   return "home";
   }
   @PostMapping("/validate")
   public String validate(@RequestParam String email,String password, HttpSession session)
   {
	   if(sr.validateUser(email,password)==true)   
	   {
		   String role=sr.getRole(email);
		   session.setAttribute("email", email);
		   if(role.equals("admin"))
		   {
			 return "Adminhome";
		   }
		   else
		   {
			   return "Customerhome";
		   }
		   
	   }
	   else
	   {
		   return "login";
	   }
   }
     @GetMapping("/logout")
   public String logout(HttpSession session)
   {
	   session.invalidate();	
	   return "login";
   }
   
}
