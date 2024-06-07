/**
 * Stock class that represents a stock with a symbol, price, volume, and market cap
 */
public class Stock {
    private String symbol;
    private double price;
    private long volume;
    private long marketCap;

    /**
     * Constructor for the Stock class
     * @param symbol The symbol of the stock
     * @param price The price of the stock
     * @param volume The volume of the stock
     * @param marketCap The market cap of the stock
     */
    public Stock(String symbol, double price, long volume, long marketCap) {
        this.symbol = symbol;
        this.price = price;
        this.volume = volume;
        this.marketCap = marketCap;
    }

    /**
     * Get the symbol of the stock
     * @return The symbol of the stock
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Set the symbol of the stock
     * @param symbol The symbol of the stock
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * Get the price of the stock
     * @return The price of the stock
     */
    public double getPrice() {
        return price;
    }

    /**
     * Set the price of the stock
     * @param price The price of the stock
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Get the volume of the stock
     * @return The volume of the stock
     */
    public long getVolume() {
        return volume;
    }

    /**
     * Set the volume of the stock
     * @param volume The volume of the stock
     */
    public void setVolume(long volume) {
        this.volume = volume;
    }

    /**
     * Get the market cap of the stock
     * @return The market cap of the stock
     */
    public long getMarketCap() {
        return marketCap;
    }

    /**
     * Set the market cap of the stock
     * @param marketCap The market cap of the stock
     */
    public void setMarketCap(long marketCap) {
        this.marketCap = marketCap;
    }

    @Override
    public String toString() {
        return "Stock [symbol=" + symbol + ", price=" + price + ", volume=" + volume + ", marketCap=" + marketCap + "]";
    }
}
