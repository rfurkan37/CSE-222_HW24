/**
 * The Headphones class represents a type of device in the inventory.
 * It implements the Device interface and has properties for category, name,
 * quantity, and price.
 */
public class Headphones implements Device {
    private String category;
    private String name;
    private int quantity;
    private double price;

    /**
     * Constructs a new Headphones object with the given name, quantity, and price.
     * The category is set to "Headphones".
     *
     * @param name     the name of the headphones
     * @param quantity the quantity of the headphones in the inventory
     * @param price    the price of the headphones
     */
    public Headphones(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.category = "Headphones";
    }

    /**
     * Returns the category of this device.
     *
     * @return the category of this device
     */
    public String getCategory() {
        return category;
    }

    /**
     * Returns the name of this device.
     *
     * @return the name of this device
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of this device.
     *
     * @param name the new name of this device
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the quantity of this device in the inventory.
     *
     * @return the quantity of this device in the inventory
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of this device in the inventory.
     * If the given quantity is less than or equal to 0, the quantity is set to 0.
     *
     * @param quantity the new quantity
     * @return the quantity of this device in the inventory
     */
    public int setQuantity(int quantity) {
        if (quantity <= 0) {
            this.quantity = 0;
        } else {
            this.quantity = quantity;
        }

        return this.quantity;
    }

    /**
     * Returns the price of this device.
     *
     * @return the price of this device
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of this device.
     * If the given price is less than 0, the price is set to 0.
     *
     * @param price the new price
     * @return the price of this device
     */
    public double setPrice(double price) {
        if (price < 0) {
            this.price = 0.0;
        } else {
            this.price = price;
        }

        return this.price;
    }
}