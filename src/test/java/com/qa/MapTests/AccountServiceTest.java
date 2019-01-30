package com.qa.MapTests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.qa.Util.JSONUtil;
import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountMapRepository;

public class AccountServiceTest {
	
	AccountMapRepository myRepo;
	

	@Before
	public void setup() {
		myRepo = new AccountMapRepository();

	}
	
		
	
	@Test
	public void addAccountTest() {
		myRepo.createAccount(JSONUtil.getJSONForObject(new Account("Soph", "Shlo", 12324, 1l)));
		int size = myRepo.accountMap.size();
		
		assertEquals("testfailed", 1 , size);
		
		
	}
	
	@Test
	public void add2AccountTest() {
		myRepo.createAccount(JSONUtil.getJSONForObject(new Account("Soph", "Shlo", 1,1l)));
		myRepo.createAccount(JSONUtil.getJSONForObject(new Account("Dave", "Jones", 2,2l)));
		int size = myRepo.accountMap.size();
		
		assertEquals("testfailed", 2 , size);
		
	}

	@Test
	public void removeAccountTest() {
		myRepo.createAccount(JSONUtil.getJSONForObject(new Account("Soph", "Shlo", 12324, 1l)));
		myRepo.deleteAccount(1l);
		int size = myRepo.accountMap.size();
		
		assertEquals("testfailed", 0, size);
		
	}
	
	
	@Test
	public void remove2AccountTest() {
		myRepo.createAccount(JSONUtil.getJSONForObject(new Account("Soph", "Shlo", 1,1l)));
		myRepo.createAccount(JSONUtil.getJSONForObject(new Account("Dave", "Jones", 2,2l)));
		myRepo.deleteAccount(1l);
		myRepo.deleteAccount(2l);
		int size = myRepo.accountMap.size();
		
		assertEquals("testfailed", 0 , size);
		
	}
	
	
	@Test
	public void remove2AccountTestAnd1ThatDoesntExist() {
		myRepo.createAccount(JSONUtil.getJSONForObject(new Account("Soph", "Shlo", 1,1l)));
		myRepo.createAccount(JSONUtil.getJSONForObject(new Account("Dave", "Jones", 2,2l)));
		myRepo.createAccount(JSONUtil.getJSONForObject(new Account("Dave", "Jones", 2,4l)));
		myRepo.deleteAccount(1l);
		myRepo.deleteAccount(2l);
		myRepo.deleteAccount(3l);
		
		int size = myRepo.accountMap.size();
		
		assertEquals("testfailed", 1 , size);
		assertEquals("testfailed", "account doesnt exist", myRepo.deleteAccount(3l));
		
	}
	
	
	@Test
	public void accountConversionToJSONTestWithEmptyMap() {
	
	}
	
	@Test
	public void accountConversionToJSONTestEmptyMapWithConversion() {
	
	}

	@Test
	public void accountConversionToJSONTest() {
		
	}

	@Test
	public void getCountForFirstNamesInAccountWhenZeroOccurances() {
		
	}
	
	@Test
	public void getCountForFirstNamesInAccountWhenOne() {
		
	}

	@Test
	public void getCountForFirstNamesInAccountWhenMult() {
		
	}

}
