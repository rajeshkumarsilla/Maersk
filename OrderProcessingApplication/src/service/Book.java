package service;

public class Book extends PhysicalProduct
{
    public Book(String bookName)
    {
    	super(bookName);
    	generateDuplicatePackingSlip();
    }
	public void generateDuplicatePackingSlip() {
		getOperations().add("create a duplicate packing slip for the royalty department");
	}
}
