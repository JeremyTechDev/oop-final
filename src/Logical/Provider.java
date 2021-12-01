package Logical;

public class Provider {
	private String name;
	private String rnc;
	private String phone;
	private String address;
	private float invoiceToPay;

	public Provider(String name, String rnc, String phone, String address, float invoiceToPay) {
		super();
		this.name = name;
		this.rnc = rnc;
		this.phone = phone;
		this.address = address;
		this.invoiceToPay = invoiceToPay;
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

	public float getInvoiceToPay() {
		return invoiceToPay;
	}

	public void setInvoiceToPay(float invoiceToPay) {
		this.invoiceToPay = invoiceToPay;
	}

}
