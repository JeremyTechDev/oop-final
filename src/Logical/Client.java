package Logical;

public class Client {
	private String id;
	private String name;
	private String address;
	private String phone;
	private String rnc;
	private float creditLimit;
	private float invoiceToCollect;

	public Client(String id, String name, String address, String phone, String rnc, float creditLimit,
			float invoiceToCollect) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.rnc = rnc;
		this.creditLimit = creditLimit;
		this.invoiceToCollect = invoiceToCollect;
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

	public String getRnc() {
		return rnc;
	}

	public void setRnc(String rnc) {
		this.rnc = rnc;
	}

	public float getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(float creditLimit) {
		this.creditLimit = creditLimit;
	}

	public float getInvoiceToCollect() {
		return invoiceToCollect;
	}

	public void setInvoiceToCollect(float invoiceToCollect) {
		this.invoiceToCollect = invoiceToCollect;
	}
}
