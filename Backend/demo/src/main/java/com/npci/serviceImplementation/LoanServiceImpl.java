package com.npci.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npci.bean.Loan;
import com.npci.bean.LoanApplication;
import com.npci.dao.LoanApplicationDao;
import com.npci.dao.LoanDao;
import com.npci.service.LoanService;

@Service
public class LoanServiceImpl implements LoanService {

	@Autowired
	LoanDao loanDao;
	
	@Autowired
	LoanApplicationDao loanApplicationDao;
	
	@Override
	public List<Loan> allLoans() {
		
		return loanDao.findAll();
	}

//	@Override
//	public List<LoanApplication> getLoanstatus() {
//		
//		return loanApplicationDao.getLoanstatus();
//	}

}
