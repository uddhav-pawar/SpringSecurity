package com.springframework.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {
	
	
	
	@GetMapping("/myLoans")
	public String getLoanDetails() {
		return "My Loan Details are...!";
	}


}
