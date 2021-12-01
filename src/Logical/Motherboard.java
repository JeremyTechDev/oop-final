package Logical;

public class Motherboard extends Component {
	private String brand;
	private String model;
	private String connectorType;
	private String String;

	public Motherboard(float price, Integer quantity, Integer serialNumber, Integer minQuantity, Provider provider,
			String brand, String model, String connectorType, String String) {
		super(price, quantity, serialNumber, minQuantity, provider);
		this.brand = brand;
		this.model = model;
		this.connectorType = connectorType;
		this.String = String;
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

	public String getString() {
		return String;
	}

	public void setString(String String) {
		this.String = String;
	}

}
