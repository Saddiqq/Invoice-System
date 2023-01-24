package invoicingSystem2;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class InvoicingSystem {
	private static ArrayList<Invoice> invoices = new ArrayList<>();
	private static ArrayList<Item> items = new ArrayList<>();
	private static String shopName;
	private static String tel;
	private static String fax;
	private static String email;
	private static String website;
	private static int[] menuCounters = new int[9];

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

	
		
		
		while (true) {
			// Main Menu
			Menu mainMenu = new Menu();
			mainMenu.addMenuItem("Shop Settings");
			mainMenu.addMenuItem("Manage Shop Items");
			mainMenu.addMenuItem("Create New Invoice");
			mainMenu.addMenuItem("Report: Statistics");
			mainMenu.addMenuItem("Report: All Invoices");
			mainMenu.addMenuItem("Search (1) Invoice");
			mainMenu.addMenuItem("Program Statistics");
			mainMenu.addMenuItem("Exit");
			mainMenu.showMenu();

			try {
				int choice = input.nextInt();
				menuCounters[choice]++;

				switch (choice) {
				case 1:
					// Shop Settings
					shopSettings(input);

					break;
				case 2:
					// Manage Shop Items
					manageItems(input);
					break;
				case 3:
					// Create New Invoice
					createInvoice(input);
					break;
				case 4:
					// Report: Statistics
					reportStatistics();
					break;
				case 5:
					// Report: All Invoices
					reportInvoices();
					break;
				case 6:
					// Search (1) Invoice
					searchInvoice(input);
					break;
				case 7:
					// Program Statistics
					programStatistics();
					break;
				case 8:
					// Exit
					System.out.println("Are you sure you want to exit? (y/n)");
					String confirm = input.next();
					if (confirm.equalsIgnoreCase("y")) {
						System.exit(0);
					}
					break;
				default:
					System.out.println("Invalid choice. Please try again.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a number.");
				input.next();
			}
		}
	}



	private static void shopSettings(Scanner input) {
		while (true) {
			// Shop Settings Menu
			Menu shopSettingsMenu = new Menu();
			shopSettingsMenu.addMenuItem("Load Data");
			shopSettingsMenu.addMenuItem("Set Shop Name");
			shopSettingsMenu.addMenuItem("Set Invoice Header (Tel / Fax / Email / Website)");
			shopSettingsMenu.addMenuItem("Go Back");
			shopSettingsMenu.showMenu();

			try {
				int choice = input.nextInt();

				switch (choice) {
				case 1:
					// Load Data (Items and invoices)
					// code to load data from file
					System.out.println("Shop Name: " + shopName);
					System.out.println("Tel: " + tel);
					System.out.println("Fax: " + fax);
					System.out.println("Email: " + email);
					System.out.println("Website: " + website);
					break;
				case 2:
					// Set Shop Name 
					System.out.println("Enter shop name:");
					shopName = input.next();
					// code to save data to file
					saveDataToFile();
					break;
				case 3:
					// Set Invoice Header (Tel / Fax / Email / Website) (Data should be saved)
					System.out.println("Enter tel:");
					tel = input.next();
					System.out.println("Enter fax:");
					fax = input.next();
					System.out.println("Enter email:");
					email = input.next();
					System.out.println("Enter website:");
					website = input.next();
					// code to save data to file
					saveDataToFile();
					break;
				case 4:
					// Go Back
					return;
				default:
					System.out.println("Invalid choice. Please try again.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a number.");
				input.next();
			}
		}
	}
    private static void saveDataToFile(){
    // code to save shopName, tel, fax, email, website to file
    }


	private static void manageItems(Scanner input) {
		while (true) {
			// Manage Shop Items Menu
			Menu manageItemsMenu = new Menu();
			manageItemsMenu.addMenuItem("Add Items (Item should be saved/serialized)");
			manageItemsMenu.addMenuItem("Delete Items");
			manageItemsMenu.addMenuItem("Change Item Price");
			manageItemsMenu.addMenuItem("Report All Items");
			manageItemsMenu.addMenuItem("Go Back");
			manageItemsMenu.showMenu();

			try {
				int choice = input.nextInt();

				switch (choice) {
				case 1:
					// Add Items (Item should be saved/serialized)
					System.out.println("Enter item ID:");
					String itemID = input.next();
					System.out.println("Enter item name:");
					String itemName = input.next();
					System.out.println("Enter unit price:");
					double unitPrice = input.nextDouble();
					System.out.println("Enter quantity:");
					int quantity = input.nextInt();
					Item item = new Item(itemID, itemName, unitPrice, quantity);
					items.add(item);
					// code to save data to file
					break;
				case 2:
					// Delete Items
					System.out.println("Enter item ID to delete:");
					itemID = input.next();
					Iterator<Item> iterator = items.iterator();
					while (iterator.hasNext()) {
						Item i = iterator.next();
						if (i.getItemID().equals(itemID)) {
							iterator.remove();
							// code to delete data from file
						}
					}
					break;
				case 3:
					// Change Item Price
					System.out.println("Enter item ID:");
					itemID = input.next();
					System.out.println("Enter new price:");
					double newPrice = input.nextDouble();
					for (Item i : items) {
						if (i.getItemID().equals(itemID)) {
							i.setUnitPrice(newPrice);
							// code to update data in file
						}
					}
					break;
				case 4:
					// Report All Items
					for (Item i : items) {
						System.out.println("Name: "+ i.getItemName() + " - " +"ID: "+i.getItemID() + " - "  + "Price: "+i.getUnitPrice());
					}
					break;
				case 5:
					// Go Back
					return;
				default:
					System.out.println("Invalid choice. Please try again.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a number.");
				input.next();
			}
		}
	}



	private static void createInvoice(Scanner input) {
		System.out.println("Enter customer name:");
		String customerName = input.next();
		System.out.println("Enter phone number:");
		String phoneNumber = input.next();
		Invoice invoice = new Invoice(customerName, phoneNumber, new Date());
		while (true) {
			// Add Items to Invoice Menu
			Menu addItemsMenu = new Menu();
			addItemsMenu.addMenuItem("Add Item");
			addItemsMenu.addMenuItem("Remove Item");
			addItemsMenu.addMenuItem("Finish and Save Invoice)");
			addItemsMenu.showMenu();
			try {
				int choice = input.nextInt();

				switch (choice) {
				case 1:
					// Add Item
					System.out.println("Enter item ID:");
					String itemID = input.next();
					Item item = null;
					for (Item i : items) {
						if (i.getItemID().equals(itemID)) {
							item = i;
							break;
						}
					}
					if (item != null) {
						invoice.addItem(item);
					} else {
						System.out.println("Item not found.");
					}
					break;
				case 2:
					// Remove Item
					System.out.println("Enter item ID:");
					itemID = input.next();
					item = null;
					for (Item i : invoice.items) {
						if (i.getItemID().equals(itemID)) {
							item = i;
							break;
						}
					}
					if (item != null) {
						invoice.removeItem(item);
					} else {
						System.out.println("Item not found.");
					}
					break;
				case 3:
					// Finish and Save Invoice
					invoices.add(invoice);
					// code to save invoice to file
					return;
				default:
					System.out.println("Invalid choice. Please try again.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a number.");
				input.next();
			}
		}

	}

	private static void reportStatistics() {
		int numberOfItems = 0;
		int numberOfInvoices = invoices.size();
		double totalSales = 0;
		for (Invoice invoice : invoices) {
			numberOfItems += invoice.items.size();
			totalSales += invoice.getTotalAmount();
		}
		System.out.println("Number of items: " + numberOfItems);
		System.out.println("Number of invoices: " + numberOfInvoices);
		System.out.println("Total sales: " + totalSales);
	}

	private static void reportInvoices() {
		for (Invoice invoice : invoices) {
			System.out.println("Invoice Number: " + invoice.getInvoiceNumber());
			System.out.println("Invoice Date: " + invoice.getInvoiceDate());
			System.out.println("Customer Name: " + invoice.getCustomerName());
			System.out.println("Number of items: " + invoice.items.size());
			System.out.println("Total amount: " + invoice.getTotalAmount());
			System.out.println("Balance: " + invoice.getBalance());
		}
	}

	private static void searchInvoice(Scanner input) {
		System.out.println("Enter invoice number:");
		int invoiceNumber = input.nextInt();
		Invoice invoice = null;
		for (Invoice i : invoices) {
			if (i.getInvoiceNumber() == invoiceNumber) {
				invoice = i;
				break;
			}
		}
		if (invoice != null) {
			System.out.println("Invoice Number: " + invoice.getInvoiceNumber());
			System.out.println("Invoice Date: " + invoice.getInvoiceDate());
			System.out.println("Customer Name: " + invoice.getCustomerName());
			System.out.println("Number of items: " + invoice.items.size());
			System.out.println("Total amount: " + invoice.getTotalAmount());
			System.out.println("Balance: " + invoice.getBalance());
			for (Item item : invoice.items) {
				System.out.println(item.getItemID() + " - " + item.getItemName() + " - " + item.getUnitPrice() + " - "
						+ item.getQuantity() + " - " + item.getQtyAmount());
			}
		} else {
			System.out.println("Invoice not found.");
		}
	}

private static void programStatistics() {
for (int i = 1; i <= menuCounters.length; i++) {
    System.out.println("Main Menu Item " + i + " selected " + menuCounters[i - 1] + " times.");
}
}
}