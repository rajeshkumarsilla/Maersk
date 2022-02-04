package service;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartTest {

	public static void main(String[] args) {
		SKUItem a = new SKUItem("A", 50, 3);
		SKUItem b = new SKUItem("B", 30, 5);
		SKUItem c = new SKUItem("C", 20, 1);
		SKUItem d = new SKUItem("D", 15, 1);
		
		ShoppingCart cart = new ShoppingCart();
		
		cart.addToCart(a);
		cart.addToCart(b);
		cart.addToCart(c);
		cart.addToCart(d);
		
		assertTrue(cart.getFinalCartAmount() == 280);
		
		a = new SKUItem("A", 50, 1);
		b = new SKUItem("B", 30, 1);
		c = new SKUItem("C", 20, 1);
		
		cart = new ShoppingCart();
		
		cart.addToCart(a);
		cart.addToCart(b);
		cart.addToCart(c);
		
		assertTrue(cart.getFinalCartAmount() == 100);
		
		a = new SKUItem("A", 50, 3);
		b = new SKUItem("B", 30, 5);
		c = new SKUItem("C", 20, 1);
		d = new SKUItem("D", 15, 1);
		
		cart = new ShoppingCart();
		
		cart.addToCart(a);
		cart.addToCart(b);
		cart.addToCart(c);
		cart.addToCart(d);
		
		assertTrue(cart.getFinalCartAmount() == 280);
	}
}

class ShoppingCart {
		
	List<SKUItem> list;
	double promoDisc;
	double cartAmount;
	
	public ShoppingCart() {
		this.list = new ArrayList<SKUItem>();
	}
	
	public double getFinalCartAmount() {
		
		//this.cartAmount = this.list.stream().map(t -> (t.getSkuItemQuantity() * t.getSkuItemUnitPrice())).reduce(0.0, Double::sum);
		
		double finalCartAmount = 0;
		int cCount = 0;
		double cUnitPrice = 0;
		int dCount = 0;
		double dUnitPrice = 0;
		
		for (SKUItem skuItem : this.list) {
		    switch (skuItem.getSkuItemId()) {
		        case "A":
		        	finalCartAmount = finalCartAmount 
		        						+ (skuItem.getSkuItemQuantity()/3)*130 
		        						+ (skuItem.getSkuItemQuantity()%3)*skuItem.getSkuItemUnitPrice();
		            break;
		        case "B":
		        	finalCartAmount = finalCartAmount 
										+ (skuItem.getSkuItemQuantity()/2)*45 
										+ (skuItem.getSkuItemQuantity()%2)*skuItem.getSkuItemUnitPrice();
		            break;
		        case "C":
		        	cCount = skuItem.getSkuItemQuantity();
		        	cUnitPrice = skuItem.getSkuItemUnitPrice();
		            break;
		        case "D":
		        	dCount = skuItem.getSkuItemQuantity();
		        	dUnitPrice = skuItem.getSkuItemUnitPrice();
		            break;
		    } 
		}
		
		if(cCount > 0 && dCount > 0 && cCount > dCount)
		{
			finalCartAmount = finalCartAmount + (cCount - dCount)*30 + dCount*dUnitPrice;
		}
		else if(cCount > 0 && dCount > 0 && cCount < dCount)
		{
			finalCartAmount = finalCartAmount + (dCount - cCount)*30 + cCount*cUnitPrice;
		}
		else if(cCount > 0 && dCount > 0 && cCount == dCount)
		{
			finalCartAmount = finalCartAmount + dCount*30;
		}
		else
		{
			finalCartAmount = finalCartAmount + cCount*cUnitPrice + dCount*dUnitPrice;
		}
		
		return finalCartAmount;
	}

	public void showCart() {
		this.list.stream().forEach(System.out::println);
	}

	public void addToCart(SKUItem item) {
		this.list.add(item);
	}
	
}

class SKUItem {
	private String skuItemId;
	private String skuItemName;
	private double skuItemUnitPrice;
	private int skuItemQuantity;
	
	public SKUItem(String skuItemId,double skuItemUnitPrice,int skuItemQuantity) {
		this.skuItemId = skuItemId;
		this.skuItemName = "SKU Item "+skuItemId;
		this.skuItemUnitPrice = skuItemUnitPrice;
		this.skuItemQuantity = skuItemQuantity;
	}

	public String getSkuItemId() {
		return skuItemId;
	}

	public void setSkuItemId(String skuItemId) {
		this.skuItemId = skuItemId;
	}

	public String getSkuItemName() {
		return skuItemName;
	}

	public void setSkuItemName() {
		this.skuItemName = "SKU Item "+this.skuItemId;
	}

	public double getSkuItemUnitPrice() {
		return skuItemUnitPrice;
	}

	public void setSkuItemUnitPrice(double skuItemUnitPrice) {
		this.skuItemUnitPrice = skuItemUnitPrice;
	}

	public int getSkuItemQuantity() {
		return skuItemQuantity;
	}

	public void setSkuItemQuantity(int skuItemQuantity) {
		this.skuItemQuantity = skuItemQuantity;
	}

	@Override
	public String toString() {
		return "SKUItem [skuItemId=" + skuItemId + ", skuItemName=" + skuItemName + ", skuItemUnitPrice="
				+ skuItemUnitPrice + ", skuItemQuantity=" + skuItemQuantity + "]";
	}
	
	
}
