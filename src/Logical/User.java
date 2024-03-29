package Logical;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private String address;
	private String phone;
	private String username;
	private String password;
	private boolean isAdmin;

	public User(String id, String name, String address, String phone, String username, String password,
			boolean isAdmin) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.username = username;
		this.password = password;
		this.isAdmin = isAdmin;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getIsAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

}
