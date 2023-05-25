package com.web.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "customers")
public class Customer {

	@Id
	@Field(type = FieldType.Keyword, name = "custid")
	private String customerId;
	@Field(type = FieldType.Text, name = "custName")
	private String customerName;
	@Field(type = FieldType.Text, name = "prodName")
	private String productName;
	@Field(type = FieldType.Long, name = "mobileNo")
	private long mobileNumber;
	@Field(type = FieldType.Double, name = "price")
	private double price;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", productName=" + productName
				+ ", mobileNumber=" + mobileNumber + ", price=" + price + "]";
	}

}
