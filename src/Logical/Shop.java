package Logical;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Shop implements Serializable {
	private static final long serialVersionUID = 1L;

	private ArrayList<Invoice> invoices;
	private ArrayList<Client> clients;
	private ArrayList<Provider> providers;
	private ArrayList<Component> components;
	private ArrayList<User> users;
	private ArrayList<Quote> quotations;
	private static User loggedUser = null;
	private static Shop instance = null;
	private static int ProductQuantity = 0;
	private int lastUserId = 1;

	public final static String shopFilename = "shop.dat";

	private Shop() {
		super();
		this.invoices = new ArrayList<Invoice>();
		this.clients = new ArrayList<Client>();
		this.providers = new ArrayList<Provider>();
		this.components = new ArrayList<Component>();
		this.users = new ArrayList<User>();
		this.quotations = new ArrayList<Quote>();
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

	public boolean addUser(User user) {
		boolean isSaved = this.users.add(user);
		if (isSaved) {
			this.lastUserId++;
		}

		return isSaved;
	}
	
	public void changeCompQuantity(String serial, int changeBy) {
		for (int i = 0; i < this.components.size(); i++) {
			if (this.components.get(i).getSerialNumber().equals(serial)) {
				Component newComp = this.components.get(i);
				newComp.setQuantity(newComp.getQuantity() + changeBy);
				this.components.set(i, newComp);
				break;
			}
		}	
	}

	// option to add product to cart
	public Component loadCart(String serialNumber) {
		Component product = getComponentBySerial(serialNumber);
		Component cartload = null;

		if (product instanceof Motherboard) {
			Motherboard motherboard = new Motherboard(0, 0, null, 0, null, null, null, null, null);
			motherboard.setQuantity(product.getQuantity());
			motherboard.setMinQuantity(product.getMinQuantity());
			motherboard.setSerialNumber(product.getSerialNumber());
			motherboard.setPrice(product.getPrice());
			motherboard.setBrand(((Motherboard) product).getBrand());
			motherboard.setModel(((Motherboard) product).getModel());
			motherboard.setConnectorType(((Motherboard) product).getConnectorType());
			motherboard.setRamtype(((Motherboard) product).getRamtype());

			cartload = motherboard;
		} else {
			if (product instanceof Microprocessor) {
				Microprocessor microprocessor = new Microprocessor(0, 0, null, 0, null, null, null, null, null);
				microprocessor.setQuantity(product.getQuantity());
				microprocessor.setMinQuantity(product.getMinQuantity());
				microprocessor.setSerialNumber(product.getSerialNumber());
				microprocessor.setPrice(product.getPrice());
				microprocessor.setBrand(((Microprocessor) product).getBrand());
				microprocessor.setModel(((Microprocessor) product).getModel());
				microprocessor.setConnectorType(((Microprocessor) product).getConnectorType());
				microprocessor.setSpeed(((Microprocessor) product).getSpeed());

				cartload = microprocessor;
			} else {
				if (product instanceof HardDisk) {
					HardDisk storagedisk = new HardDisk(0, 0, null, 0, null, null, null, null, null);
					storagedisk.setQuantity(product.getQuantity());
					storagedisk.setMinQuantity(product.getMinQuantity());
					storagedisk.setSerialNumber(product.getSerialNumber());
					storagedisk.setPrice(product.getPrice());
					storagedisk.setBrand(((Microprocessor) product).getBrand());
					storagedisk.setModel(((Microprocessor) product).getModel());
					storagedisk.setCapacity(((HardDisk) product).getCapacity());
					storagedisk.setConnectionType(((HardDisk) product).getConnectionType());

					cartload = storagedisk;
				} else {
					if (product instanceof RamCard) {
						RamCard memoryram = new RamCard(0, 0, null, 0, null, null, null, null);
						memoryram.setQuantity(product.getQuantity());
						memoryram.setMinQuantity(product.getMinQuantity());
						memoryram.setSerialNumber(product.getSerialNumber());
						memoryram.setPrice(product.getPrice());
						memoryram.setBrand(((Microprocessor) product).getBrand());
						memoryram.setCapacity(((RamCard) product).getCapacity());
						memoryram.setType(((RamCard) product).getType());

						cartload = memoryram;
					}
				}
			}
		}
		return cartload;

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

	// VerifyProducts
	public boolean VerifyProduct(String code) {
		for (Component i : components) {
			if (i.getSerialNumber().equalsIgnoreCase(code)) {
				return true;
			}
		}
		return false;
	}

	// Find ComponentbySerial Number
	public Component getComponentBySerial(String code) {
		Component comp = null;
		for (Component i : Shop.getInstance().getComponents()) {
			if (i.getSerialNumber().equals(code)) {
				comp = i;
			}
		}
		return comp;
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
	
	//Invoice generator and Components decreaser.
	public void createInvoice(String code, String client,String customerID,String TotalPrice, String PaymentType, ArrayList<Component> components ) {
		Invoice sale = new Invoice(code, client, customerID, TotalPrice, PaymentType, components);
		invoices.add(sale);
		DecreaseStock(sale.getCode());
	}
	
	public InvoiceConfirmed FindInvoice(String code) {
		for(Invoice x: invoices) {
			if(x instanceof Invoice) {
				if((x.getCode().equalsIgnoreCase(code))) {
					return (InvoiceConfirmed) x;
				}
			}
		}
		return null;
	}
	
	public void DecreaseStock(String code) {
		InvoiceConfirmed decreasestock = FindInvoice(code);
		for(Component x: components) {
			for(Component y: decreasestock.getComponents()) {
				if(x.getSerialNumber().equals(x.getSerialNumber())) {
					x.setQuantity(x.getQuantity()-y.getQuantity());	
				}	
			}
		}
	}
	
	//end of invoice code

	public int getLastUserId() {
		return lastUserId;
	}

	public void setLastUserId(int lastUserId) {
		this.lastUserId = lastUserId;
	}

	public User getLoggedUser() {
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

	public ArrayList<Quote> getQuotations() {
		return quotations;
	}

	public void setQuotations(ArrayList<Quote> quotations) {
		this.quotations = quotations;
	}

	public void AddCustomer(Client client) {
		clients.add(client);

	}

	public void AddSuplier(Provider provider) {
		providers.add(provider);
	}

	public void AddInvoice(Invoice inv) {
		invoices.add(inv);
		
	}
	
	public void AddQuote(Quote quote) {
		quotations.add(quote);
		
	}

}
