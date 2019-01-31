package com.qa.persistence.domain;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Account {
	
	 private String firstName;
	 private String lastName;
	 
	 @Size(min = 6, max = 6)
	 private int accountNumber;
	 
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 @Id
	 private Long id;

	 
	
	public Account(String firstName, String lastName, int accountNumber, Long id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountNumber = accountNumber;
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
		
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getAccount() {
		return firstName + " " + lastName + " "+ accountNumber;
	}
	
	
}
