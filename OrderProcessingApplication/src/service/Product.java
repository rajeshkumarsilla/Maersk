package service;

import java.util.ArrayList;
import java.util.List;

public abstract class Product
{
    public List<String> operations = new ArrayList<String>();
	public List<String> getOperations() {
		return operations;
	}
	public void setOperations(List<String> operations) {
		this.operations = operations;
	}
	public abstract void generatePackingSlip();
}