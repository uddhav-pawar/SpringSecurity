package com.springframework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springframework.entity.Customer;
import com.springframework.repo.CustomerRepo;
import com.springframework.services.RegstrationService;

@RestController
public class LoginController {

	@Autowired
	private RegstrationService service;

	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
		boolean isSaved;
		ResponseEntity response = null;
		try {
			isSaved = service.registerUser(customer);
			if (isSaved) {
				response = ResponseEntity.status(HttpStatus.CREATED)
						.body("Given user details are successfully registered");
			}
		} catch (Exception ex) {
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("An exception occured due to " + ex.getMessage());
		}
		return response;
	}

}
