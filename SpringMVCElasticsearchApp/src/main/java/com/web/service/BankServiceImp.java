package com.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.model.Bank;
import com.web.repository.BankRepo;

@Service
public class BankServiceImp implements BankService {

	@Autowired
	private BankRepo brepo;

	@Override
	public Bank insertBanks(Bank bank) {
		double bal = (bank.getBalance() + bank.getDebitAmount()) - bank.getWithDrawAmount();
		bank.setBalance(bal);
		return brepo.save(bank);
	}

	@Override
	public Bank updateBanks(Bank bank,String sno) {
		Bank b1=brepo.findById(sno).get();
		b1.setSno(sno);
		b1.setDebitAmount(bank.getDebitAmount());
		b1.setWithDrawAmount(bank.getWithDrawAmount());
		double bal1=(bank.getBalance()+b1.getDebitAmount())-b1.getWithDrawAmount();
		b1.setBalance(bal1);
		return brepo.save(b1);
	}

	@Override
	public void deleteBank(String sno) {
		brepo.deleteById(sno);
	}

	@Override
	public Iterable<Bank> getAllBank() {
		return brepo.findAll();
	}

	@Override
	public Bank getOneBank(String sno) {
		return brepo.findById(sno).get();
	}

}
