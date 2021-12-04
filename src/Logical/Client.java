package Logical;

import java.io.Serializable;

public class Client implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String address;
	private String phone;
	private String creditLimit;

	public Client(String id, String name, String address, String phone, String creditLimit) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.creditLimit = creditLimit;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(String creditLimit) {
		this.creditLimit = creditLimit;
	}
}
