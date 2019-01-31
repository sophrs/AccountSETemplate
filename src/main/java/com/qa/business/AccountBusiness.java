package com.qa.business;

import javax.inject.Inject;

import com.qa.Util.JSONUtil;
import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountRepository;

public class AccountBusiness implements AccountBusinessService {

	@Inject
	private AccountRepository repo;

	@Override
	public String getAllAccounts() {
		return repo.getAllAccounts();
	}

	@Override
	public String addAccount(String account) {

		Account anAcc = JSONUtil.getObjectForJson(account, Account.class);
		if (anAcc.getAccountNumber() == 9) {
			return "{\"message\": \"cannot create account with an accountnumber of 9\"}";
		} else {
			return repo.createAccount(account);
		}
	}

	@Override
	public String deleteAccount(Long id) {
		return repo.deleteAccount(id);
	}

	@Override
	public String updateAccount(Long id, String account) {
		return repo.updateAccount(id, account);
	}

}
