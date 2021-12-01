package Logical;

import java.util.ArrayList;

public class Shop {
	private ArrayList<Combo> combos;
	private ArrayList<Invoice> invoices;
	private ArrayList<Client> clients;
	private static Shop instance = null;

	private Shop() {
		super();
		this.combos = new ArrayList<Combo>();
		this.invoices = new ArrayList<Invoice>();
		this.clients = new ArrayList<Client>();
	}

	public static Shop getInstance() {
		if (instance == null) {
			instance = new Shop();
		}
		return instance;
	}
	
	public ArrayList<Combo> getCombos() {
		return combos;
	}

	public void setCombos(ArrayList<Combo> combos) {
		this.combos = combos;
	}

	public ArrayList<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(ArrayList<Invoice> invoices) {
		this.invoices = invoices;
	}

	public ArrayList<Client> getClients() {
		return clients;
	}

	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}

}
