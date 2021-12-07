package Logical;

public class Microprocessor extends Component {
	private String brand;
	private String model;
	private String connectorType;
	private String speed;

	public Microprocessor(float price, Integer quantity, String serialNumber, Integer minQuantity, Provider provider,
			String brand, String model, String connectorType, String speed) {
		super(price, quantity, minQuantity, provider);
		this.brand = brand;
		this.model = model;
		this.connectorType = connectorType;
		this.speed = speed;
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

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

}
