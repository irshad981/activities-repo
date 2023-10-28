package com.npci.bean;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "loan_application")
public class LoanApplication {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationId;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer_id;
//    
     @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "loan_id", referencedColumnName = "loan_id")
    private Loan loanid;

    

    
    @Column(name = "Status_id")
    private String Status_id;

	public LoanApplication() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public Customer getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Customer customer_id) {
		this.customer_id = customer_id;
	}

	public Loan getLoanid() {
		return loanid;
	}

	public void setLoanid(Loan loanid) {
		this.loanid = loanid;
	}

	public String getStatus_id() {
		return Status_id;
	}

	public void setStatus_id(String status_id) {
		Status_id = status_id;
	}
	
}
