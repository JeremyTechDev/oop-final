package Logical;

import java.util.ArrayList;

public class Combo {
	private String code;
	private String name;
	private float discount;
	private ArrayList<Component> components;

	public Combo(String code, String name, float discount, ArrayList<Component> components) {
		super();
		this.code = code;
		this.name = name;
		this.discount = discount;
		this.components = components;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public ArrayList<Component> getComponents() {
		return components;
	}

	public void setComponents(ArrayList<Component> components) {
		this.components = components;
	}

}
