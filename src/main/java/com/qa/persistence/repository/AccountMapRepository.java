package com.qa.persistence.repository;

import java.util.HashMap;

import java.util.Map;

import com.qa.Util.JSONUtil;
import com.qa.persistence.domain.Account;

public class AccountMapRepository implements AccountRepository {

	public Map<Long, Account> accountMap = new HashMap<>();

	private JSONUtil util = new JSONUtil();

	public String getAllAccounts() {
		String tempString = "";
		for (Account i : accountMap.values()) {
			String accountToString = i.toString();
			accountToString += " ";
			tempString += accountToString;
		}
		return tempString;

		
	}

	public String createAccount(String account) {
		Account anAcc = util.getObjectForJson(account, Account.class);
		accountMap.put(anAcc.getId(), anAcc);

		return "{\"message\": \"account has been sucessfully added\"}";

	}

	public String deleteAccount(Long id) {
		if (accountMap.containsKey(id)) {
			accountMap.remove(id);
			return "{\"message\": \"account sucessfully deleted\"}";
		} else {
			return ("account doesnt exist");
		}

	}

	public String updateAccount(Long id, String account) {
		Account anAcc = util.getObjectForJson(account, Account.class);
		accountMap.put(id, anAcc);
		return "updated account";
	}

	public int getnumberofaccountswithfirstname(String firstName) {
		String tempString = " ";
		int count = 0;
		for (Account i : accountMap.values()) {
			if (i.getFirstName().equals(firstName)) {
				count++;
				String accountToString = i.toString();
				accountToString += " ";
				tempString += accountToString;
			}
		}
		

		System.out.println(tempString);
		return count;

	}
	
}
