package invoicingSystem2;

public class Item {

	private String itemID;
	private String itemName;
	private double unitPrice;
	private int quantity;
	private double qtyAmount;
	public Item(String itemID, String itemName, double unitPrice, int quantity) {
	    this.itemID = itemID;
	    this.itemName = itemName;
	    this.unitPrice = unitPrice;
	    this.quantity = quantity;
	    this.qtyAmount = unitPrice * quantity;
	}

	// getters and setters
	public String getItemID() {
	    return itemID;
	}
	public void setItemID(String itemID) {
	    this.itemID = itemID;
	}
	public String getItemName() {
	    return itemName;
	}
	public void setItemName(String itemName) {
	    this.itemName = itemName;
	}
	public double getUnitPrice() {
	    return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
	    this.unitPrice = unitPrice;
	}
	public int getQuantity() {
	    return quantity;
	}
	public void setQuantity(int quantity) {
	    this.quantity = quantity;
	}
	public double getQtyAmount() {
	    return qtyAmount;
	}	
	
}
