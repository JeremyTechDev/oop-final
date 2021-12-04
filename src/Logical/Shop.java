package Logical;

import java.io.Serializable;
import java.util.ArrayList;

public class Shop implements Serializable {
	private static final long serialVersionUID = 1L;

	private ArrayList<Invoice> invoices;
	private ArrayList<Client> clients;
	private ArrayList<Provider> providers;
	private ArrayList<Component> components;
	private ArrayList<User> users;
	private static User loggedUser = null;
	private static Shop instance = null;
	private static int ProductQuantity = 0;
	private int CustomerSalesCodeGen;

	public final static String shopFilename = "shop.dat";

	private Shop() {
		super();
		this.invoices = new ArrayList<Invoice>();
		this.clients = new ArrayList<Client>();
		this.providers = new ArrayList<Provider>();
		this.components = new ArrayList<Component>();
		this.users = new ArrayList<User>();
		CustomerSalesCodeGen = 10000;
	}

	public static void setInstance(Shop shopInstance) {
		instance = shopInstance;
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

	public boolean handleLogin(String username, String password) {
		for (User user : this.users) {
			if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equalsIgnoreCase(password)) {
				loggedUser = user;
				return true;
			}
		}

		return false;
	}

	public void addUser(User adminUser) {
		this.users.add(adminUser);
	}

	// Find customer function
	public Client FindCustomerByID(String id) {
		Client client = null;
		boolean found = false;
		int IndexFinder = 0;

		while (!found && IndexFinder < clients.size()) {
			if (clients.get(IndexFinder).getId().equalsIgnoreCase(id)) {

				client = clients.get(IndexFinder);
				found = true;
			}
			IndexFinder++;
		}
		return client;
	}

	// Find ComponentbySerial Number
	public Component getComponentBySerial(String string) {
		for (Component comp : this.components) {
			if (comp.getSerialNumber().equals(string)) {
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

	public static User getLoggedUser() {
		return loggedUser;
	}

	public static void setLoggedUser(User loggedUser) {
		Shop.loggedUser = loggedUser;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
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

	public void AddCustomer(Client client) {
		clients.add(client);
		CustomerSalesCodeGen++;

	}

	public void AddSuplier(Provider provider) {
		providers.add(provider);
	}

}
