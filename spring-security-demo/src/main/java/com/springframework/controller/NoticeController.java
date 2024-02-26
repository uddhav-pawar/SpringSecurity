package com.springframework.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticeController {
	
	@GetMapping("/notices")
	public String getnotices() {
		return "Notice Details are...!";
	}


}
