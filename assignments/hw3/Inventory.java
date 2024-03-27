import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Represents an inventory of devices in an electronics shop.
 * The inventory is a list of categories, where each category is a list of
 * devices.
 * Each device has a category, name, price, and quantity.
 * The inventory provides methods to add, remove, update, and print devices.
 * It also provides methods to find the cheapest device, sort devices by price,
 * get the total inventory value, and export an inventory report to a text file.
 * 
 * Time complexity analysis:
 * The time complexity of the methods in this class is determined by the number of
 * devices in the inventory.
 * The methods iterate over the devices in the inventory to perform operations.
 */
public class Inventory {
    private LinkedList<ArrayList<Device>> inventory;

    /**
     * Constructs a new Inventory object with an empty inventory.
     */
    public Inventory() {
        inventory = new LinkedList<ArrayList<Device>>();
    }

    /**
     * Adds the device to the inventory.
     * If the device category already exists in the inventory, the device is added
     * to
     * the existing category.
     * If the device category does not exist in the inventory, a new category is
     * created and the device is added to it.
     * 
     * Time complexity: O(1) because category size is fixed and add operation is
     * constant time.
     * 
     * @param device the device to add
     */
    public void addDevice(Device device) {
        if (inventory.isEmpty()) {
            ArrayList<Device> category = new ArrayList<Device>();
            category.add(device);
            inventory.add(category);
        } else {
            for (ArrayList<Device> category : inventory) {
                if (category.get(0).getCategory().equals(device.getCategory())) {
                    category.add(device);
                    return;
                }
            }
            ArrayList<Device> category = new ArrayList<Device>();
            category.add(device);
            inventory.add(category);
        }
    }

    /**
     * Removes the device from the inventory.
     * Time complexity: O(n), where n is the total number of devices in the
     * inventory.
     * 
     * @param device the device to remove
     */
    public void removeDevice(Device device) {
        for (ArrayList<Device> category : inventory) {
            if (category.get(0).getCategory().equals(device.getCategory())) {
                category.remove(device);
            }
        }

    }

    /**
     * Updates the quantity and price of the device in the inventory.
     * Time complexity: O(n), where n is the total number of devices in the
     * inventory
     * 
     * @param device the device to update
     */
    public void updateDevice(Device device) {
        for (ArrayList<Device> category : inventory) {
            if (category.get(0).getCategory().equals(device.getCategory())) {
                for (Device d : category) {
                    if (d.getName().equals(device.getName())) {
                        d.setQuantity(device.getQuantity());
                        d.setPrice(device.getPrice());
                        break;
                    }
                }
            }
        }
        removeZeroQuantityDevices();
    }

    /**
     * Prints the devices in the inventory.
     * Time complexity: O(n), where n is the total number of devices in the
     * inventory
     * 
     */
    public void printInventory() {
        removeZeroQuantityDevices();
        System.out.println("Device List:");
        int i = 1;
        for (ArrayList<Device> category : inventory) {
            for (Device device : category) {
                System.out
                        .println(i + ". Category: " + device.getCategory() + ", Name: " + device.getName() + ", Price: "
                                + String.format("$%.2f", device.getPrice()) + ", Quantity: " + device.getQuantity());
                i++;
            }
        }

    }

    /**
     * Returns the device with the cheapest price in the inventory.
     * Time complexity: O(n), where n is the total number of devices in the
     * inventory
     * 
     * @return the device with the cheapest price in the inventory
     */
    public Device findTheCheapestDevice() {
        Device cheapestDevice = null;
        double minPrice = Double.MAX_VALUE;
        for (ArrayList<Device> category : inventory) {
            for (Device device : category) {
                if (device.getPrice() < minPrice) {
                    minPrice = device.getPrice();
                    cheapestDevice = device;
                }
            }
        }
        return cheapestDevice;
    }

    /**
     * Sorts the devices in the inventory by price in ascending order and prints the
     * sorted list.
     * Time complexity: O(n log n), where n is the total number of devices in the
     * inventory
     * 
     */
    public void sortDevicesByPrice() {
        ArrayList<Device> allDevices = new ArrayList<Device>();
        for (ArrayList<Device> category : inventory) {
            allDevices.addAll(category);
        }

        Collections.sort(allDevices, (Device d1, Device d2) -> Double.compare(d1.getPrice(), d2.getPrice()));

        int i = 1;
        System.out.println("Devices sorted by price:");
        for (Device device : allDevices) {
            System.out.println(i + ". Category: " + device.getCategory() + ", Name: " + device.getName() + ", Price: "
                    + String.format("$%.2f", device.getPrice()) + ", Quantity: " + device.getQuantity());
            i++;
        }

    }

    /**
     * Returns the total number of devices in the inventory.
     * Time complexity: O(n), where n is the total number of devices in the
     * inventory
     * 
     * @return the total number of devices in the inventory
     */
    public int size() {
        int size = 0;
        for (ArrayList<Device> category : inventory) {
            size += category.size();
        }
        return size;
    }

    /**
     * Returns the devices in the inventory at the given index.
     * 
     * @param index the index of the device in the inventory
     * @return the devices in the inventory at the given index as an ArrayList
     */
    public ArrayList<Device> get(int index) {
        return inventory.get(index);
    }

    /**
     * Returns the total value of the inventory.
     * Time complexity: O(n), where n is the total number of devices in the
     * inventory
     * 
     * @return the total value of the inventory
     */
    public double totalInventoryValue() {
        double totalValue = 0;
        for (ArrayList<Device> category : inventory) {
            for (Device device : category) {
                totalValue += device.getPrice() * device.getQuantity();
            }
        }
        return totalValue;
    }

    /**
     * Returns the device with the given name.
     * Time complexity: O(n), where n is the total number of devices in the
     * inventory
     * 
     * @param name the name of the device to find
     * @return the device with the given name, or null if not found
     */
    public Device getDeviceByName(String name) {
        for (ArrayList<Device> category : inventory) {
            for (Device device : category) {
                if (device.getName().equals(name)) {
                    return device;
                }
            }
        }
        return null;
    }

    /**
     * Exports the inventory report to a text file named "inventory_report.txt".
     * The report includes the category, name, price, and quantity of each device in
     * the inventory.
     * It also includes the total number of devices and the total inventory value.
     * Devices with zero quantity are removed before generating the report.
     * The report is timestamped with the current date and time.
     * 
     * Time complexity: O(n), where n is the total number of devices in the
     * inventory.
     * Category amount is fixed so it can be ignored.
     * This is because the method iterates over each device in the inventory once.
     * 
     */
    public void exportInventoryReport() {
        removeZeroQuantityDevices();
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy HH.mm");
        String formattedDate = formatter.format(new Date());
        try {
            PrintWriter writer = new PrintWriter(new File("inventory_report.txt"));
            writer.println("Electronics Shop Inventory Report");
            writer.println("Generated on: " + formattedDate);
            writer.println("---------------------------------------");
            writer.println("| No. | Category | Name | Price | Quantity |");
            writer.println("---------------------------------------");
            int i = 1;
            for (ArrayList<Device> category : inventory) {
                for (Device device : category) {
                    writer.println("| " + i + " | " + device.getCategory() + " | " + device.getName() + " | "
                            + String.format("$%,.2f", device.getPrice()) + " | " + device.getQuantity() + " |");
                    i++;
                }
            }
            writer.println("---------------------------------------\n");
            writer.println("Summary:");
            writer.println("- Total Number of Devices: " + size());
            writer.println("- Total Inventory Value: " + String.format("$%,.2f", totalInventoryValue()));
            writer.println("End of Report");
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Inventory report exported to inventory_report.txt");
    }

    /**
     * Removes devices with zero quantity from the inventory.
     * Time complexity: O(n), where n is the total number of devices in the
     * inventory
     * 
     */
    private void removeZeroQuantityDevices() {
        for (ArrayList<Device> category : inventory) {
            category.removeIf(device -> device.getQuantity() == 0);
        }
    }

    /**
     * Returns true if the inventory is empty, false otherwise.
     * Time complexity: O(1)
     * 
     * @return true if the inventory is empty, false otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

}
