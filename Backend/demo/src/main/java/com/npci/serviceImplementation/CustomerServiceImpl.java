package com.npci.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.npci.bean.Customer;
import com.npci.bean.Loan;
import com.npci.bean.LoanApplication;
import com.npci.dao.CustomerDao;
import com.npci.dao.LoanApplicationDao;
import com.npci.dao.LoanDao;
import com.npci.exceptions.AuthenticationException;
import com.npci.exceptions.ValidationException;
import com.npci.service.CustomerService;
import com.npci.util.LoginParams;
import com.npci.util.Validations;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	private Validations validations;
	
	@Autowired
	LoanDao loanDao;
	
	@Autowired
	LoanApplicationDao  loanApplicationDao;

	@Override
	public Customer register(Customer customer) throws ValidationException {
		
		if (validations.checkForEmail(customer.getEmail())) {
			if (validations.checkForFirstName(customer.getFirstname())) {
				if (validations.checkForLastName(customer.getLastname())) {
				if (validations.checkForPhoneNumber(customer.getPhone())) {
					if (validations.checkForPassword(customer.getPassword())) {
						if (validations.checkForPan(customer.getPan())) {
							return customerDao.save(customer);
							
						}
					}
				}
			}
		}		
	}

		throw new ValidationException("validation error occured");
	}

	@Override
	public List<LoanApplication> login(LoginParams params) throws AuthenticationException {
		Customer c = customerDao.login(params.getEmail(), params.getPassword());
		if (c != null) {
			List<LoanApplication> ps = loanApplicationDao.getLoans(c.getCustomer_id());
			System.out.println(ps);
			return ps;
		}
		throw new AuthenticationException("Invalid username and password");
		
	}
	
	
	
	
}
