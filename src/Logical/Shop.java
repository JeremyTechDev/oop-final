package Logical;

import java.util.ArrayList;

public class Shop {
	private ArrayList<Invoice> invoices;
	private ArrayList<Client> clients;
	private ArrayList<Provider> providers;
	private ArrayList<Component> components;
	private static Shop instance = null;

	private Shop() {
		super();
		this.invoices = new ArrayList<Invoice>();
		this.clients = new ArrayList<Client>();
		this.providers = new ArrayList<Provider>();
		this.components = new ArrayList<Component>();
	}

	public static Shop getInstance() {
		if (instance == null) {
			instance = new Shop();
		}
		return instance;
	}

	public Provider getProviderByRNC(String rnc) {
		for (Provider provider : this.providers) {
			if (provider.getRnc().equalsIgnoreCase(rnc)) {
				return provider;
			}
		}
		return null;
	}

	public Component getComponentBySerial(Integer serial) {
		for (Component comp : this.components) {
			if (comp.getSerialNumber().equals(serial)) {
				return comp;
			}
		}
		return null;
	}

	public boolean registerComponent(Component component) {
		boolean isSaved = false;

		// If no other component with the same id
		if (getComponentBySerial(component.getSerialNumber()) == null) {
			isSaved = this.components.add(component);
		}

		return isSaved;
	}

	public boolean registerProvider(Provider provider) {
		boolean isSaved = false;

		// If no other provider with the same RNC (id)
		if (getProviderByRNC(provider.getRnc()) == null) {
			isSaved = this.providers.add(provider);
		}

		return isSaved;
	}

	public ArrayList<Component> getComponents() {
		return components;
	}

	public void setComponents(ArrayList<Component> components) {
		this.components = components;
	}

	public ArrayList<Provider> getProviders() {
		return providers;
	}

	public void setProviders(ArrayList<Provider> providers) {
		this.providers = providers;
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
