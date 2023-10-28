package com.npci.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.npci.bean.Loan;
import com.npci.bean.LoanApplication;
import com.npci.dao.LoanDao;
import com.npci.service.LoanApplicationService;
import com.npci.service.LoanService;

@RestController
@RequestMapping(path = "/api")
public class LoanController {
	
	@Autowired
	LoanService loanServie; 
	
//	@Autowired
//	LoanApplicationService loanApplicationServices; 
	
	@Autowired
	LoanApplicationService loanApplicationService;
	
	@GetMapping("/allloans")
    public ResponseEntity<List<Loan>> getAllLoans() {
        List<Loan> loans = loanServie.allLoans();
        return new ResponseEntity<>(loans, HttpStatus.OK);
    }
	
	   @PostMapping("/loanApplication")
	    public ResponseEntity<LoanApplication> applyForLoan(@RequestBody LoanApplication loanApplication) {
	        LoanApplication newLoanApplication = loanApplicationService.applyForLoan(loanApplication);
	        return new ResponseEntity<>(newLoanApplication, HttpStatus.CREATED);
	    }
	   
//	   @GetMapping("/getstatus")
//	    public ResponseEntity<List<LoanApplication>> getAllStatus() {
//	        List<LoanApplication> loans = loanServie.getLoanstatus();
//	        		
//	        		
//	        return new ResponseEntity<>(loans, HttpStatus.OK);
//	    }
	

}
