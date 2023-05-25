package com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.Bank;
import com.web.service.BankService;

@RestController
@RequestMapping("/bankDtls")
public class BankController {

	@Autowired
	private BankService bservice;

	@PostMapping("/insertDoc")
	public Bank insertDoc(@RequestBody Bank bank) {
		return bservice.insertBanks(bank);
	}

	@GetMapping("/getAllDoc")
	Iterable<Bank> getAllDoc() {
		return bservice.getAllBank();
	}

	@GetMapping("/getOneDoc/{sno}")
	public Bank getOneDoc(@PathVariable String sno) {
		return bservice.getOneBank(sno);
	}

	@PutMapping("/updateDoc/{sno}")
	public Bank updateDoc(@RequestBody Bank bank, @PathVariable String sno) {
		return bservice.updateBanks(bank, sno);
	}

	@DeleteMapping("/deleteDoc/{sno}")
	public void deleteDoc(@PathVariable String sno) {
		bservice.deleteBank(sno);
	}
}
