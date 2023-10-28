package com.npci.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.npci.bean.Loan;
import com.npci.bean.LoanApplication;



public interface LoanDao extends JpaRepository<Loan , Integer>{
	
	@Query("SELECT  FROM LoanApplication la WHERE la.customer_id.customer_id = ?1")
	List<LoanApplication> getLoans(int customer_id);


}
