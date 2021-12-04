package Logical;

import java.io.Serializable;

public class Provider implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private String rnc;
	private String phone;
	private String address;

	public Provider(String name, String rnc, String phone, String address) {
		super();
		this.name = name;
		this.rnc = rnc;
		this.phone = phone;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRnc() {
		return rnc;
	}

	public void setRnc(String rnc) {
		this.rnc = rnc;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
