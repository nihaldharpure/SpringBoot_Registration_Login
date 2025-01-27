package com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.entity.User;
import com.repository.UserRepository;
import com.service.UserService;



@Controller
public class UserController {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	UserService userservice;
	
	@GetMapping("/registerform")
	public String openRegister(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}
	@GetMapping("/loginform")
	public String openLogin(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}
	
	@PostMapping("/registerform")
	public String submitForm(@ModelAttribute("user") User user,Model model) {
		boolean result=userservice.registerUser(user);
		
		if(result) {
			model.addAttribute("success", "User Registered..!!");
		}
		else {
			model.addAttribute("error", "Try Again..!!");
		}
		return "login";
	}
	
    @PostMapping("/loginform")
    public String handleLogin(@ModelAttribute("user") User user, Model model) {
        // Logic to authenticate user
        if (user.getUsername().equals("admin") && user.getPassword().equals("password")) {
            model.addAttribute("success", "Login successful!");
            return "login";  // Redirect or display success message
        }
		return null; 
    }

}
