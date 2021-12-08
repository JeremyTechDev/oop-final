package Logical;

import java.util.ArrayList;

public class InvoiceConfirmed extends Invoice {
	
	private boolean paid;
	

	public InvoiceConfirmed(String code, String client, String customerID, String TotalPrice, String PaymentType, ArrayList<Component> components) {
		super(code, client, customerID, TotalPrice, PaymentType, components);
		
		this.paid = false;
	}

	
	
	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

}
