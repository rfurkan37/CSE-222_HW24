import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The App class provides a command-line interface for the Electronics Inventory
 * Management System.
 * The user can add, remove, update, list, find, sort, restock, calculate, and
 * export devices in the inventory.
 */
public class App {
    private static final Inventory inventory = new Inventory();
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Adds a new device to the inventory.
     * The user is prompted to enter the category, name, price, and quantity of the
     * device.
     * The category is used to determine the type of device to add.
     * The device is then added to the inventory.
     * If the category is not recognized, an error message is displayed.
     * Time complexity: O(1)
     */
    private static void addDevice() {
        System.out.println("Enter category name: ");
        String category = scanner.nextLine();

        System.out.println("Enter device name: ");
        String name = scanner.nextLine();

        double price = -1;
        do {
            System.out.println("Enter price: ");
            try {
                price = scanner.nextDouble();
                if (price <= 0) {
                    System.out.println("Price must be a positive number. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // discard the invalid input
            }
        } while (price <= 0);
        scanner.nextLine(); // consume the newline left-over

        int quantity = -1;
        do {
            System.out.println("Enter quantity: ");
            try {
                quantity = scanner.nextInt();
                if (quantity <= 0) {
                    System.out.println("Quantity must be a positive number. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // discard the invalid input
            }
        } while (quantity <= 0);
        scanner.nextLine(); // consume the newline left-over

        int categoryIndex = categorizeDevice(category);

        switch (categoryIndex) {
            case 0:
                inventory.addDevice(new TV(name, quantity, price));
                break;
            case 1:
                inventory.addDevice(new Smartwatch(name, quantity, price));
                break;
            case 2:
                inventory.addDevice(new Laptop(name, quantity, price));
                break;
            case 3:
                inventory.addDevice(new Smartphone(name, quantity, price));
                break;
            case 4:
                inventory.addDevice(new Headphones(name, quantity, price));
                break;
            default:
                System.out.println("Invalid category name. Please try again.");
                break;
        }

        System.out.println(category + ", " + name + ", " + price + ", " + quantity + ", amount added to inventory.");
    }

    /**
     * Removes a device from the inventory.
     * The user is prompted to enter the name of the device to remove.
     * If the device is found, it is removed from the inventory.
     * If the device is not found, an error message is displayed.
     * Time complexity: O(n), where n is the total number of devices in the
     * inventory.
     */
    private static void removeDevice() {
        Device deviceToRemove = null;

        do {
            System.out.println("Enter the name of the device to remove: ");
            String name = scanner.nextLine();
            deviceToRemove = inventory.getDeviceByName(name);
            if (deviceToRemove == null) {
                System.out.println("Device not found. Please try again.");
            }
        } while (deviceToRemove == null);

        inventory.removeDevice(deviceToRemove);
        System.out.println("Device removed successfully.");
    }

    private static void updateDevice() {
        Device deviceUpdateDetails = null;

        do {
            System.out.println("Enter the name of the device to update: ");
            String name = scanner.nextLine();
            deviceUpdateDetails = inventory.getDeviceByName(name);
            if (deviceUpdateDetails == null) {
                System.out.println("Device not found. Please try again.");
            }
        } while (deviceUpdateDetails == null);

        System.out.println("Enter new price (leave blank to keep current price): ");
        String priceInput = scanner.nextLine();
        if (!priceInput.isEmpty()) {
            try {
                double price = Double.parseDouble(priceInput);
                deviceUpdateDetails.setPrice(price);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input for price. Keeping the current price.");
            }
        }

        System.out.println("Enter new quantity (leave blank to keep current quantity): ");
        String quantityInput = scanner.nextLine();
        if (!quantityInput.isEmpty()) {
            try {
                int quantity = Integer.parseInt(quantityInput);
                deviceUpdateDetails.setQuantity(quantity);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input for quantity. Keeping the current quantity.");
            }
        }

        inventory.updateDevice(deviceUpdateDetails);

        System.out.println(
                deviceUpdateDetails.getName() + "details updated : Price - "
                        + String.format("$%,.2f", deviceUpdateDetails.getPrice()) + ", Quantity - "
                        + deviceUpdateDetails.getQuantity());
    }

    /**
     * Lists all devices in the inventory.
     * Time complexity: O(n), where n is the total number of devices in the
     * inventory.
     */
    private static void listAllDevices() {
        if (inventory.isEmpty()) {
            System.out.println("No devices in the inventory.");
        } else {
            inventory.printInventory();
        }
    }

    /**
     * Finds the device with the cheapest price in the inventory.
     * Time complexity: O(n), where n is the total number of devices in the
     * inventory.
     */
    private static void findTheCheapestDevice() {
        Device cheapestDevice = inventory.findTheCheapestDevice();
        System.out.println("The cheapest device is: " + cheapestDevice.getCategory() + " " + cheapestDevice.getName()
                + " " + cheapestDevice.getQuantity() + " " + cheapestDevice.getPrice() + "$");
    }

    /**
     * Sorts the devices in the inventory by price in ascending order.
     * Time complexity: O(n log n), where n is the total number of devices in the
     * inventory.
     * 
     */
    private static void sortDevicesByPrice() {
        inventory.sortDevicesByPrice();
    }

    /**
     * Restocks a device in the inventory.
     * The user is prompted to enter the name of the device to restock and the
     * quantity to add or remove.
     * If the quantity is positive, it is added to the device's quantity.
     * If the quantity is negative, it is removed from the device's quantity.
     * If the quantity becomes zero, the device is removed from the inventory.
     * If the device is not found, an error message is displayed.
     * Time complexity: O(n), where n is the total number of devices in the
     * inventory.
     * 
     */
    private static void restockDevice() {

        System.out.println("Enter the name of the device to restock: ");
        String name = scanner.nextLine();

        System.out.println("Do you want to add or remove stock? (Add/Remove): ");
        String action = scanner.nextLine();

        Device deviceToRestock = inventory.getDeviceByName(name);

        action.replaceAll("\\s", "");

        switch (action) {
            case "add":
                int restockQuantity;
                do {
                    System.out.println("Enter the quantity to add: ");
                    restockQuantity = scanner.nextInt();
                    scanner.nextLine();
                    if (restockQuantity <= 0) {
                        System.out.println("Invalid quantity. Please enter a positive number.");
                    }
                } while (restockQuantity <= 0);

                deviceToRestock.setQuantity(deviceToRestock.getQuantity() + restockQuantity);
                System.out.println(
                        deviceToRestock.getName() + " restocked. New quantity" + deviceToRestock.getQuantity());

                break;
            case "remove":
                int removeQuantity;
                do {
                    System.out.println("Enter the quantity to remove: ");
                    removeQuantity = scanner.nextInt();
                    scanner.nextLine();
                    if (removeQuantity <= 0) {
                        System.out.println("Invalid quantity. Please enter a positive number.");
                    }
                } while (removeQuantity <= 0);
                deviceToRestock.setQuantity(deviceToRestock.getQuantity() - removeQuantity);
                System.out.println(
                        deviceToRestock.getName() + " stock reduced. New quantity" + deviceToRestock.getQuantity());
                if (deviceToRestock.getQuantity() == 0) {
                    System.out.println("The device is out of stock. Removing from inventory.");
                }
                break;
            default:
                System.out.println("Invalid action");
                break;
        }
    }

    /**
     * Calculates the total value of the inventory.
     * Time complexity: O(n), where n is the total number of devices in the
     * inventory.
     */
    private static void calculateTotalInventoryValue() {
        double totalValue = inventory.totalInventoryValue();
        System.out.printf("Total inventory value: $%,.2f\n", totalValue);
    }

    /**
     * Exports an inventory report to a file.
     * The report includes the category, name, price, and quantity of each device in
     * the inventory.
     * Time complexity: O(n), where n is the total number of devices in the
     * inventory.
     */
    private static void exportInventoryReport() {
        inventory.exportInventoryReport();
    }

    /**
     * Categorizes the device based on the category name.
     * The category name is converted to lowercase and whitespace is removed before
     * comparison.
     * The following categories are recognized:
     * - TV
     * - Smartwatch
     * - Laptop
     * - Smartphone
     * - Headphones
     * If the category is not recognized, -1 is returned.
     * 
     * @param category the category name
     * @return  the id of category
     */
    public static int categorizeDevice(String category) {
        category.replaceAll("\\s", "");
        category.toLowerCase();

        return switch (category) {
            case "tv" -> 0;
            case "smartwatch" -> 1;
            case "laptop" -> 2;
            case "smartphone" -> 3;
            case "headphones" -> 4;
            default -> -1;
        };
    }

    /**
     * The main method provides a command-line interface for the Electronics
     * Inventory Management System.
     * The user can add, remove, update, list, find, sort, restock, calculate, and
     * export devices in the inventory.
     * @param args the command-line arguments
     * @throws Exception if an error occurs
     */
    public static void main(String[] args) throws Exception {

        System.out.println("Welcome to the Electronics Inventory Management System!\n");
        int option;

        while (true) {
            System.out.println("Please select an option:");
            System.out.println("1. Add a new device");
            System.out.println("2. Remove a device");
            System.out.println("3. Update device details");
            System.out.println("4. List all devices");
            System.out.println("5. Find the cheapest device");
            System.out.println("6. Sort devices by price");
            System.out.println("7. Calculate total inventory value");
            System.out.println("8. Restock a device");
            System.out.println("9. Export inventory report");
            System.out.println("0. Exit");

            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (option) {
                case 1:
                    // Add a new device
                    addDevice();
                    break;
                case 2:
                    // Remove a device
                    removeDevice();
                    break;
                case 3:
                    // Update device details
                    updateDevice();
                    break;
                case 4:
                    listAllDevices();
                    break;
                case 5:
                    // Find the cheapest device
                    findTheCheapestDevice();
                    break;
                case 6:
                    // Sort devices by price
                    sortDevicesByPrice();
                    break;
                case 7:
                    // Calculate total inventory value
                    calculateTotalInventoryValue();
                    break;
                case 8:
                    // Restock a device
                    restockDevice();
                    break;
                case 9:
                    // Export inventory report
                    exportInventoryReport();
                    break;
                case 0:
                    // Exit
                    System.out.println("Goodbye!");
                    break;
            }

            if (option == 0) {
                break;
            }

        }

        scanner.close();
    }

}