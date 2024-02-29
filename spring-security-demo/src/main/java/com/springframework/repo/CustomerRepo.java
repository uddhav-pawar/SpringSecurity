package com.springframework.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springframework.entity.Customer;

@Repository
public interface CustomerRepo extends CrudRepository<Customer,Integer>{
	
	List<Customer> findByEmail(String email);

}
