package Logical;

import java.util.Date;

public class Order {
	private String code;
	private Date date;
	private String state;
	private int quantity;
	private Component component;
	private float unitPrice;
	private Provider provider;
	private String paymentType;

	public Order(String code, Date date, String state, int quantity, Component component, float unitPrice,
			Provider provider, String paymentType) {
		super();
		this.code = code;
		this.date = date;
		this.state = state;
		this.quantity = quantity;
		this.component = component;
		this.unitPrice = unitPrice;
		this.provider = provider;
		this.paymentType = paymentType;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Component getComponent() {
		return component;
	}

	public void setComponent(Component component) {
		this.component = component;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

}
