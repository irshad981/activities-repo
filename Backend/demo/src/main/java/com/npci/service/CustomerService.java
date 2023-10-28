package com.npci.service;

import java.util.List;

import com.npci.bean.Customer;
import com.npci.bean.LoanApplication;
import com.npci.exceptions.AuthenticationException;
import com.npci.exceptions.ValidationException;
import com.npci.util.LoginParams;

public interface CustomerService {
	
	public Customer register(Customer customer) throws ValidationException;

	public List<LoanApplication> login(LoginParams params) throws AuthenticationException;

}
