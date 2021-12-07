package Logical;

import java.io.Serializable;
import java.util.ArrayList;

public class Invoice implements Serializable {
	private static final long serialVersionUID = 1L;

	private String code;
	private String client;
	private String customerID;
	private String totalPrice;
	private String paymentType;
	
	public Invoice(String code, String client,String customerID,String TotalPrice, String PaymentType) {
		super();
		this.code = code;
		this.client = client;
		this.customerID = customerID;
		this.totalPrice = totalPrice;
		this.paymentType = paymentType;
	}

	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getClient() {
		return client;
	}


	public void setClient(String client) {
		this.client = client;
	}


	public String getCustomerID() {
		return customerID;
	}


	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}


	public String getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}


	public String getPaymentType() {
		return paymentType;
	}


	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}


	
		
}
