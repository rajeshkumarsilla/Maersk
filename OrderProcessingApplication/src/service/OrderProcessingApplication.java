package service;

import static org.junit.Assert.assertTrue;

public class OrderProcessingApplication
{
    public static void main(String[] args)
    {
    	Product product = getProductFromInput("other","generic");
    	assertTrue(product.operations.size()==2);
    	assertTrue(product.operations.get(0).equalsIgnoreCase("generate a packing slip for shipping"));
    	assertTrue(product.operations.get(1).equalsIgnoreCase("generate a commission payment to the agent"));
    	
    	product = getProductFromInput("video","Learning To Ski");
    	
    	assertTrue(product.operations.size()==2);
    	assertTrue(product.operations.get(0).equalsIgnoreCase("generate a packing slip for shipping"));
    	assertTrue(product.operations.get(1).equalsIgnoreCase("First Aid video added to the packing slip"));
    	
    	product = getProductFromInput("video","generic");
    	
    	assertTrue(product.operations.size()==1);
    	assertTrue(product.operations.get(0).equalsIgnoreCase("generate a packing slip for shipping"));
    	
    	product = getProductFromInput("membership","activate");
    	
    	assertTrue(product.operations.size()==2);
    	assertTrue(product.operations.get(0).equalsIgnoreCase("activate that membership"));
    	assertTrue(product.operations.get(1).equalsIgnoreCase("email sent"));
    	
    	product = getProductFromInput("membership","upgrade");
    	
    	assertTrue(product.operations.size()==2);
    	assertTrue(product.operations.get(0).equalsIgnoreCase("apply the upgrade"));
    	assertTrue(product.operations.get(1).equalsIgnoreCase("email sent"));
    	
    	product = getProductFromInput("book","generic");
    	
    	assertTrue(product.operations.size()==3);
    	assertTrue(product.operations.get(0).equalsIgnoreCase("generate a packing slip for shipping"));
    	assertTrue(product.operations.get(1).equalsIgnoreCase("generate a commission payment to the agent"));
    	assertTrue(product.operations.get(2).equalsIgnoreCase("create a duplicate packing slip for the royalty department"));
    }
    
    public static Product getProductFromInput(String inputType,String inputName)
    {
    	ProductTypes prodType = ProductTypes.valueOf(inputType.toUpperCase());
    	
    	Product product = null;
    	
    	switch(prodType)
    	{
    		case OTHER:
    			product = new PhysicalProduct(inputName);
    			break;
    		case BOOK:
    			product = new Book(inputName);
    			break;
    		case MEMBERSHIP: case UPGRADE:
    			product = new Membership(inputName);
    			break;
    		case VIDEO:
    			product = new Video(inputName);
    			break;
    	}
    	
    	return product;
    }
}
