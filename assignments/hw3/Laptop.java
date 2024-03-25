/**
 * Laptop class that implements the Device interface. This class represents a
 * laptop device in the inventory. It has properties for category, name,
 * quantity, and price.
 * 
 */
public class Laptop implements Device {
    private String category;
    private String name;
    private int quantity;
    private double price;

    /**
     * Constructs a new Laptop object with the given name, quantity, and price. The
     * category is set to "Laptop".
     * @param name name of the laptop
     * @param quantity quantity of the laptop
     * @param price price of the laptop
     */
    public Laptop(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.category = "Laptop";
    }

    /**
     * Getter for category.
     * 
     * @return category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Getter for name.
     * 
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name.
     * 
     * @param name name of the laptop
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for quantity.
     * 
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Setter for quantity.
     * 
     * @param quantity  quantity of the laptop
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
     * Getter for price.
     * 
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Setter for price.
     * 
     * 
     * @param price price of the laptop
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