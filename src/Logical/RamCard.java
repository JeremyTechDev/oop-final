package Logical;

public class RamCard extends Component {
	private String brand;
	private RamSize capacity;
	private RamType type;

	public RamCard(float price, Integer quantity, Integer serialNumber, Integer minQuantity, Provider provider,
			String brand, RamSize capacity, RamType type) {
		super(price, quantity, serialNumber, minQuantity, provider);
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

	public RamSize getCapacity() {
		return capacity;
	}

	public void setCapacity(RamSize capacity) {
		this.capacity = capacity;
	}

	public RamType getType() {
		return type;
	}

	public void setType(RamType type) {
		this.type = type;
	}

}
