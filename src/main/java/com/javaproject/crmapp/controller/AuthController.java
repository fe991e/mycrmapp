package com.javaproject.crmapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

	@GetMapping("/login")
	public String showLoginPage() {
		return "/login-page";
	}
	
	@GetMapping("/access-denied")
	public String showAccessDeniedPage() {
		return "/access-denied-page";
	}
}
