package Logical;

public class Microprocessor extends Component {
	private String brand;
	private String model;
	private MicroprocessorConnectionType connectorType;
	private MicroprocessorFrecuency speed;

	public Microprocessor(float price, Integer quantity, Integer serialNumber, Integer minQuantity, Provider provider,
			String brand, String model, MicroprocessorConnectionType connectorType, MicroprocessorFrecuency speed) {
		super(price, quantity, serialNumber, minQuantity, provider);
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

	public MicroprocessorConnectionType getConnectorType() {
		return connectorType;
	}

	public void setConnectorType(MicroprocessorConnectionType connectorType) {
		this.connectorType = connectorType;
	}

	public MicroprocessorFrecuency getSpeed() {
		return speed;
	}

	public void setSpeed(MicroprocessorFrecuency speed) {
		this.speed = speed;
	}

}
