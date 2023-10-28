package com.npci.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Loan")
public class Loan {
	
	@Id
    @GeneratedValue
    @Column(name = "loan_id")
    private int loanId;

    @Column(name = "loan_type")
    private String loanType;

    // Default constructor
    public Loan() {
    }

    // Constructor without loanId (if needed)
    public Loan(String loanType) {
        this.loanType = loanType;
    }

    // Getter and setter methods
    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    @Override
    public String toString() {
        return "Loan [loanId=" + loanId + ", loanType=" + loanType + "]";
    }

}
