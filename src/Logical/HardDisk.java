package Logical;

public class HardDisk extends Component {
	private String brand;
	private String model;
	private String capacity;
	private String connectionType;

	public HardDisk(float price, Integer quantity, String serialNumber, Integer minQuantity, Provider provider,
			String brand, String model, String capacity,  String connectionType) {
		super(price, quantity,serialNumber, minQuantity, provider);
		this.brand = brand;
		this.model = model;
		this.capacity = capacity;
		this.connectionType = connectionType;
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

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getConnectionType() {
		return connectionType;
	}

	public void setConnectionType(String connectionType) {
		this.connectionType = connectionType;
	}

}
