package Logical;

import java.io.Serializable;

public abstract class Component implements Serializable {
	private static final long serialVersionUID = 1L;

	protected float price;
	protected Integer quantity;
	protected String serialNumber;
	protected Integer minQuantity;
	protected Provider provider;
	private int RealProductQuantity;

	public Component(float price, Integer quantity, String serialNumber, Integer minQuantity, Provider provider) {
		super();
		this.price = price;
		this.quantity = quantity;
		this.serialNumber = serialNumber;
		this.minQuantity = minQuantity;
		this.provider = provider;
		this.RealProductQuantity = 0;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Integer getMinQuantity() {
		return minQuantity;
	}

	public void setMinQuantity(Integer minQuantity) {
		this.minQuantity = minQuantity;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public int getRealProductQuantity() {
		return RealProductQuantity;
	}

	public void setRealProductQuantity(int realProductQuantity) {
		RealProductQuantity = realProductQuantity;
	}

}
