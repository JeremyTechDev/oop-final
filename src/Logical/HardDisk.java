package Logical;

public class HardDisk extends Component {
	private String brand;
	private String model;
	private HardDiskSize capacity;
	private HardDiskType connectionType;

	public HardDisk(float price, Integer quantity, Integer serialNumber, Integer minQuantity, Provider provider,
			String brand, String model, HardDiskSize capacity,  HardDiskType connectionType) {
		super(price, quantity, serialNumber, minQuantity, provider);
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

	public HardDiskSize getCapacity() {
		return capacity;
	}

	public void setCapacity(HardDiskSize capacity) {
		this.capacity = capacity;
	}

	public HardDiskType getConnectionType() {
		return connectionType;
	}

	public void setConnectionType(HardDiskType connectionType) {
		this.connectionType = connectionType;
	}

}
