/**
 * The Device interface represents a device in the inventory.
 * It provides methods to get and set the category, name, price, and quantity of
 * the device.
 */
public interface Device {

    /**
     * Returns the category of this device.
     *
     * @return the category of this device
     */
    String getCategory();

    /**
     * Returns the name of this device.
     *
     * @return the name of this device
     */
    String getName();

    /**
     * Returns the price of this device.
     *
     * @return the price of this device
     */
    double getPrice();

    /**
     * Returns the quantity of this device in the inventory.
     *
     * @return the quantity of this device in the inventory
     */
    int getQuantity();

    /**
     * Sets the price of this device.
     *
     * @param price the new price
     * @return the old price of this device
     */
    double setPrice(double price);

    /**
     * Sets the quantity of this device in the inventory.
     *
     * @param quantity the new quantity
     * @return the old quantity of this device in the inventory
     */
    int setQuantity(int quantity);
}