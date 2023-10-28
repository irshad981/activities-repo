package com.npci.serviceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npci.bean.LoanApplication;
import com.npci.dao.LoanApplicationDao;
import com.npci.service.LoanApplicationService;

@Service
public class LoanApplicationImpl implements LoanApplicationService {

	@Autowired
	LoanApplicationDao loanApplicationDao;
	
	@Override
	public LoanApplication applyForLoan(LoanApplication loanApplication) {
		loanApplication.setStatus_id("pending");
		
		return loanApplicationDao.save(loanApplication);
	}
	
	

}
