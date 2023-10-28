package com.npci.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.npci.bean.Loan;
import com.npci.bean.LoanApplication;

public interface LoanApplicationDao extends JpaRepository<LoanApplication ,Long> {

	@Query("SELECT distinct(status_id) FROM LoanApplication ")
	List<LoanApplication> getLoanstatus();
	
}
