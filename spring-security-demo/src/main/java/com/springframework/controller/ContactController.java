package com.springframework.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ContactController {
	
	@GetMapping("/contact")
	public String contactUs() {
		return "We will connect with u soon...!";
	}


}
