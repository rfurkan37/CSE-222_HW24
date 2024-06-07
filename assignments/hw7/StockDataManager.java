public class StockDataManager {
    private AVLTree avlTree;

    /**
     * Constructor for the StockDataManager class
     * Initializes the AVL tree
     */
    public StockDataManager() {
        avlTree = new AVLTree();
    }

    /**
     * Adds a new stock or updates an existing stock's attributes.
     * @param symbol    the stock symbol
     * @param price     the stock price
     * @param volume    the trading volume of the stock
     * @param marketCap the market capitalization of the company
     */
    public void addOrUpdateStock(String symbol, double price, long volume, long marketCap) {
        Stock existingStock = avlTree.search(symbol);
        if (existingStock != null) {
            existingStock.setPrice(price);
            existingStock.setVolume(volume);
            existingStock.setMarketCap(marketCap);
        } else {
            Stock newStock = new Stock(symbol, price, volume, marketCap);
            avlTree.insert(newStock);
        }
    }

    /**
     * Removes a stock from the AVL tree.
     * @param symbol the stock symbol to be removed
     */
    public void removeStock(String symbol) {
        Stock stock = avlTree.search(symbol);
        if (stock != null) {
            avlTree.delete(symbol);
        } else {
            System.out.println("Stock not found: " + symbol);
        }
    }

    /**
     * Searches for a stock in the AVL tree.
     * @param symbol the stock symbol to search for
     * @return the Stock object if found, null otherwise
     */
    public Stock searchStock(String symbol) {
        return avlTree.search(symbol);
    }

    /**
     * Updates the details of an existing stock.
     * @param symbol       the stock symbol
     * @param newPrice     the new price of the stock
     * @param newVolume    the new trading volume of the stock
     * @param newMarketCap the new market capitalization of the company
     */
    public void updateStock(String symbol, double newPrice, long newVolume, long newMarketCap) {
        Stock stock = avlTree.search(symbol);
        if (stock != null) {
            stock.setPrice(newPrice);
            stock.setVolume(newVolume);
            stock.setMarketCap(newMarketCap);
        } else {
            System.out.println("Stock not found: " + symbol);
        }
    }
}
