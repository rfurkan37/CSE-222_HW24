/**
 * The TV class represents a television device.
 * It implements the Device interface.
 */
public class TV implements Device {
    private String category;
    private String name;
    private int quantity;
    private double price;

    /**
     * Constructs a new TV with the given name, quantity, and price.
     * 
     * @param name     the name of the TV
     * @param quantity the quantity of the TV
     * @param price    the price of the TV
     */
    public TV(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.category = "TV";
    }

    /**
     * Returns the category of the TV.
     * 
     * @return the category of the TV
     */
    public String getCategory() {
        return category;
    }

    /**
     * Returns the name of the TV.
     * 
     * @return the name of the TV
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the TV.
     * 
     * @param name the new name of the TV
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the quantity of the TV.
     * 
     * @return the quantity of the TV
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the TV. If the given quantity is less than or equal to
     * 0, the quantity is set to 0.
     * 
     * @param quantity the new quantity of the TV
     * @return the updated quantity of the TV
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
     * Returns the price of the TV.
     * 
     * @return the price of the TV
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the TV. If the given price is less than 0, the price is set
     * to 0.0.
     * 
     * @param price the new price of the TV
     * @return the updated price of the TV
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