package Logical;

import java.util.ArrayList;

public class Motherboard extends Component {
	private String brand;
	private String model;
	private ConnectionType connectorType;
	private RamType ramType;
	private ArrayList<HardDiskType> connections;

	public Motherboard(float price, Integer quantity, Integer serialNumber, Integer minQuantity, Provider provider,
			String brand, String model, ConnectionType connectorType, RamType ramType,
			ArrayList<HardDiskType> connections) {
		super(price, quantity, serialNumber, minQuantity, provider);
		this.brand = brand;
		this.model = model;
		this.connectorType = connectorType;
		this.ramType = ramType;
		this.connections = connections;
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

	public ConnectionType getConnectorType() {
		return connectorType;
	}

	public void setConnectorType(ConnectionType connectorType) {
		this.connectorType = connectorType;
	}

	public RamType getRamType() {
		return ramType;
	}

	public void setRamType(RamType ramType) {
		this.ramType = ramType;
	}

	public ArrayList<HardDiskType> getConnections() {
		return connections;
	}

	public void setConnections(ArrayList<HardDiskType> connections) {
		this.connections = connections;
	}

}
