package com.web.service;

import com.web.model.Bank;

public interface BankService {

	public Bank insertBanks(Bank bank);
	
	public Bank updateBanks(Bank bank,String sno);
	
	public void deleteBank(String sno);
	
	public Iterable<Bank> getAllBank();
	
	public Bank getOneBank(String sno);
	
}
