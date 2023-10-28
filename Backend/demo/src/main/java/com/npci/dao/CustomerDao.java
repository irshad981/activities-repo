package com.npci.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.npci.bean.Customer;


public interface CustomerDao extends JpaRepository<Customer , Integer>{
	
	@Query(value = "select p from Customer p where p.email=?1 and p.password=?2")
	public Customer login(String email, String password);

}
