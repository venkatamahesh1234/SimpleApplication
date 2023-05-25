package com.web.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "banks")
public class Bank {

	@Id
	private String sno;
	@Field(type = FieldType.Text, name = "acctNo")
	private String accountNo;
	@Field(type = FieldType.Text, name = "acctName")
	private String accountName;
	@Field(type = FieldType.Text, name = "debitAmt")
	private double debitAmount;
	@Field(type = FieldType.Text, name = "withDrawAmt")
	private double withDrawAmount;
	@Field(type = FieldType.Text, name = "location")
	private String location;
	@Field(type = FieldType.Text, name = "bal")
	private double balance;
	@Field(type = FieldType.Text, name = "description")
	private String description;

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public double getDebitAmount() {
		return debitAmount;
	}

	public void setDebitAmount(double debitAmount) {
		this.debitAmount = debitAmount;
	}

	public double getWithDrawAmount() {
		return withDrawAmount;
	}

	public void setWithDrawAmount(double withDrawAmount) {
		this.withDrawAmount = withDrawAmount;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Bank [sno=" + sno + ", accountNo=" + accountNo + ", accountName=" + accountName + ", debitAmount="
				+ debitAmount + ", withDrawAmount=" + withDrawAmount + ", location=" + location + ", balance=" + balance
				+ ", description=" + description + "]";
	}

}
