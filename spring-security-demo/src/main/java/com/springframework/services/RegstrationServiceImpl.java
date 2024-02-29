package com.springframework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springframework.entity.Customer;
import com.springframework.repo.CustomerRepo;

@Service
public class RegstrationServiceImpl implements RegstrationService {

	@Autowired
	private CustomerRepo customerRepository;

	@Autowired
	private PasswordEncoder encoder;

	@Override
	public boolean registerUser(Customer customer) {
		String plainpwd = customer.getPwd();
		String hashPwd = encoder.encode(plainpwd);
		customer.setPwd(hashPwd);
		Customer cust = customerRepository.save(customer);
		if (cust.getId() > 0) {
			return true;
		}
		return false;
	}

}
