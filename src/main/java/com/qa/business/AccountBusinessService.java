package com.qa.business;

public interface AccountBusinessService {

	String getAllAccounts();

	String addAccount(String account);

	String deleteAccount(Long id);
	
	String updateAccount(Long id, String account);


}
