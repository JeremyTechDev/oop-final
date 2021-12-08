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
	private ArrayList<Component> components;
	
	public Invoice(String code, String client,String customerID,String TotalPrice, String PaymentType, ArrayList<Component> components) {
		super();
		this.code = code;
		this.client = client;
		this.customerID = customerID;
		this.totalPrice = TotalPrice;
		this.paymentType = PaymentType;
		this.components = components;
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

	public ArrayList<Component> getComponents() {
		return components;
	}

	public void setComponents(ArrayList<Component> components) {
		this.components = components;
	}


	
		
}
