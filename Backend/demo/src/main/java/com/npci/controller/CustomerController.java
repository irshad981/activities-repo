package com.npci.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.npci.bean.Customer;
import com.npci.dao.CustomerDao;
import com.npci.exceptions.AuthenticationException;
import com.npci.exceptions.ValidationException;
import com.npci.service.CustomerService;
import com.npci.util.LoginParams;


@RestController
@RequestMapping(path = "/api")
public class CustomerController {
	
	Map<String, String> map = new HashMap<>();
	Map<String, String> exceptions = new HashMap<>();
	
	@Autowired
	private CustomerService customerService; 
	
	@PostMapping(path = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> register(@RequestBody Customer customer) {
		try {
			return ResponseEntity.status(201).body(customerService.register(customer));
		} catch (ValidationException e) {
			map.put("error", e.getMessage());
			exceptions.put("register", e.getMessage());
			return ResponseEntity.status(400).body(map);
		}

	}
	
	@PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> login(@RequestBody LoginParams params) {
		try {
			
			return ResponseEntity.status(200).body(customerService.login(params));
		} catch (AuthenticationException e) {
			map.put("error", e.getMessage());
			exceptions.put("login", e.getMessage());
			return ResponseEntity.status(401).body(map);
		}

	}

	

}
