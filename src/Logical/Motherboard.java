package Logical;

public class Motherboard extends Component {
	private String brand;
	private String model;
	private String connectorType;
	private String ramtype;

	public Motherboard(float price, Integer quantity, String serialNumber, Integer minQuantity, Provider provider,
			String brand, String model, String connectorType, String ramtype) {
		super(price, quantity, serialNumber, minQuantity, provider);
		this.brand = brand;
		this.model = model;
		this.connectorType = connectorType;
		this.ramtype = ramtype;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getConnectorType() {
		return connectorType;
	}

	public void setConnectorType(String connectorType) {
		this.connectorType = connectorType;
	}

	public String getRamtype() {
		return ramtype;
	}

	public void setRamtype(String ramtype) {
		this.ramtype = ramtype;
	}

}
