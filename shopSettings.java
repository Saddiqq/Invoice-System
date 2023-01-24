//package invoicingSystem2;
//
//import java.util.InputMismatchException;
//import java.util.Scanner;
//
//public class shopSettings {
//	private static void shopSettings(Scanner input) {
//	    while (true) {
//	        // Shop Settings Menu
//	        Menu shopSettingsMenu = new Menu();
//	        shopSettingsMenu.addMenuItem("Load Data");
//	        shopSettingsMenu.addMenuItem("Set Shop Name");
//	        shopSettingsMenu.addMenuItem("Set Invoice Header");
//	        shopSettingsMenu.addMenuItem("Go Back");
//	        shopSettingsMenu.showMenu();
//
//	        try {
//	            int choice = input.nextInt();
//
//	            switch (choice) {
//	                case 1:
//	                    // Load Data (Items and invoices)
//	                    // code to load data from file
//	                    break;
//	                case 2:
//	                    // Set Shop Name (data should be saved)
//	                    System.out.println("Enter shop name:");
//	                    String shopName = input.next();
//	                    // code to save data to file
//	                    break;
//	                case 3:
//	                    // Set Invoice Header (Tel / Fax / Email / Website) (Data should be saved)
//	                    System.out.println("Enter tel:");
//	                    String tel = input.next();
//	                    System.out.println("Enter fax:");
//	                    String fax = input.next();
//	                    System.out.println("Enter email:");
//	                    String email = input.next();
//	                    System.out.println("Enter website:");
//	                    String website = input.next();
//	                    // code to save data to file
//	                    break;
//	                case 4:
//	                    // Go Back
//	                    return;
//	                default:
//	                    System.out.println("Invalid choice. Please try again.");
//	            }
//	        } catch (InputMismatchException e) {
//	            System.out.println("Invalid input. Please enter a number.");
//	            input.next();
//	        }
//	    }
//	}
//}
