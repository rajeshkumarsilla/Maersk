package service;

public class PhysicalProduct extends Product
{
    public PhysicalProduct(String productName)
    {
    	generatePackingSlip();
    	addCommission();
	}
	public void addCommission()
    {
    	getOperations().add("generate a commission payment to the agent");
    }
	public void generatePackingSlip() {
		getOperations().add("generate a packing slip for shipping");
	}
}