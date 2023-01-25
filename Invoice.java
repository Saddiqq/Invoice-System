package invoicingSystem2;

import java.util.*;

public class Invoice {

	private String customerName;
	private String phoneNumber;
	private Date invoiceDate;
	private int invoiceNumber;
	private int numberOfItems;
	private double totalAmount;
	private double paidAmount;
	private double balance;
	ArrayList<Item> items;

	// constructor
	public Invoice(String customerName, String phoneNumber,int invoiceNumber, Date invoiceDate) {
		this.customerName = customerName;
		this.phoneNumber = phoneNumber;
		this.invoiceDate = invoiceDate;
		this.invoiceNumber = invoiceNumber;
		this.items = new ArrayList<>();
	}

	// getters and setters
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public int getNumberOfItems() {
		return numberOfItems;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}

	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
	    this.balance = balance;
	}

	// add item to invoice
	public void addItem(Item item) {
		items.add(item);
		numberOfItems++;
		totalAmount += item.getQtyAmount();
		balance = totalAmount - paidAmount;
	}

	// remove item from invoice
	public void removeItem(Item item) {
		if (items.remove(item)) {
			numberOfItems--;
			totalAmount -= item.getQtyAmount();
			balance = totalAmount - paidAmount;
		}
	}

	// display invoice details
	public void displayInvoice() {
		System.out.println("Invoice Date: " + invoiceDate);
		System.out.println("Customer Name: " + customerName);
		System.out.println("Phone Number: " + phoneNumber);
		System.out.println("Number of Items: " + numberOfItems);
		System.out.println("Total Amount: " + totalAmount);
		System.out.println("Paid Amount: " + paidAmount);
		System.out.println("Balance: " + balance);
		System.out.println("Items:");
		for (Item item : items) {
			System.out.println(item.getItemName() + " - " + item.getUnitPrice() + " x " + item.getQuantity() + " = "
					+ item.getQtyAmount());
		}
	}

	public int getInvoiceNumber() {
	    return invoiceNumber;
	}
	

	
}
