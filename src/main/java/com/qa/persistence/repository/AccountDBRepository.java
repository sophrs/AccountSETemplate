package com.qa.persistence.repository;

import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import static javax.transaction.Transactional.TxType.REQUIRED;

import static javax.transaction.Transactional.TxType.SUPPORTS;

import com.qa.Util.JSONUtil;
import com.qa.persistence.domain.Account;

@Transactional(SUPPORTS)
public class AccountDBRepository implements AccountRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	@Override
	public String getAllAccounts() {
		Query query = manager.createQuery("Select a FROM Account a");
		Collection<Account> accounts = (Collection<Account>) query.getResultList();
		return util.getJSONForObject(accounts);

	}

	@Override
	@Transactional(REQUIRED)
	public String createAccount(String account) {
		Account anAcc = util.getObjectForJson(account, Account.class);
		manager.persist(anAcc);
		return "{\"message\": \"account sucessfully created\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteAccount(Long id) {
		Account accbyid = manager.find(Account.class, id);
		if (accbyid != null) {
			manager.remove(accbyid);
		}
		return "{\"message\": \"account sucessfully deleted\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String updateAccount(Long id, String account) {
		Account anAcc = util.getObjectForJson(account, Account.class);
		Account accbyid = manager.find(Account.class, id);
		// if(accbyid != null) {
		// manager.remove(accbyid);
		// manager.persist(anAcc);
		// }
		accbyid = manager.merge(anAcc);

		return "{\"message\": \"account sucessfully updated\"}";

	}
}
