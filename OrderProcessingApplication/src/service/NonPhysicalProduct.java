package service;

public abstract class NonPhysicalProduct extends Product
{
	@Override
	public void generatePackingSlip() {
		getOperations().add("generate a packing slip for shipping");
	}
}