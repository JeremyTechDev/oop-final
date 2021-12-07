package Logical;

public class RamCard extends Component {
	private String brand;
	private String capacity;
	private String type;

	public RamCard(float price, Integer quantity, String serialNumber, Integer minQuantity, Provider provider,
			String brand, String capacity, String type) {
		super(price, quantity, minQuantity, provider);
		this.brand = brand;
		this.capacity = capacity;
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
