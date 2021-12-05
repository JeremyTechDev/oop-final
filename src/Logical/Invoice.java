package Logical;

import java.io.Serializable;
import java.util.ArrayList;

public class Invoice implements Serializable {
	private static final long serialVersionUID = 1L;

	private String code;
	private float totalPrice;
	private User seller;
//	private ArrayList<Combo> combos;
	private ArrayList<Component> components;
	private Client client;
	private String paymentType;
	private boolean isPayed;

	public Invoice(String code, float totalPrice, User seller, ArrayList<Component> components,
			Client client, String paymentType, boolean isPayed) {
		super();
		this.code = code;
		this.totalPrice = totalPrice;
		this.seller = seller;
		//this.combos = combos;
		this.components = components;
		this.client = client;
		this.paymentType = paymentType;
		this.isPayed = isPayed;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public User getSeller() {
		return seller;
	}

	public void setSeller(User seller) {
		this.seller = seller;
	}
/*
	public ArrayList<Combo> getCombos() {
		return combos;
	}

	public void setCombos(ArrayList<Combo> combos) {
		this.combos = combos;
	}
*/
	public ArrayList<Component> getComponents() {
		return components;
	}

	public void setComponents(ArrayList<Component> components) {
		this.components = components;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public boolean isPayed() {
		return isPayed;
	}

	public void setPayed(boolean isPayed) {
		this.isPayed = isPayed;
	}
}
