import java.util.ArrayList;
import java.util.List;

/**
 * AVL Tree implementation for Stocks
 */
public class AVLTree {
    /**
     * Node class for AVL Tree
     * Contains a Stock object and references to left and right children
     * Also contains the height of the node
     */
    private static class Node {
        Stock stock;
        Node left, right;
        int height;

        Node(Stock stock) {
            this.stock = stock;
            this.height = 1;
        }

        public boolean equals(String symbol) {
            return stock.getSymbol().equals(symbol);
        }

        public int compareTo(String symbol) {
            return stock.getSymbol().compareTo(symbol);
        }
    }

    private Node root;

    /**
     * Constructor for AVL Tree
     * @param stock The volume of the stock
     */
    public void insert(Stock stock) {
        root = insert(root, stock);
    }

    /**
     * Get heights of AVL Tree after inserting a list of stocks
     * @param stocks List of stocks to insert
     * @return List of heights after each insertion
     */
    public List<Integer> getHeightsAfterInsertions(List<Stock> stocks) {
        List<Integer> heights = new ArrayList<>();
        for (Stock stock : stocks) {
            insert(stock);
            heights.add(height(root));
        }
        return heights;
    }

    /**
     * Get heights of AVL Tree after deleting a list of stocks
     * @param node Root node of AVL Tree
     * @param stock List of stocks to delete
     * @return List of heights after each deletion
     */
    private Node insert(Node node, Stock stock) {
        // Normal BST insertion
        if (node == null) {
            return new Node(stock);
        }

        if (stock.getSymbol().compareTo(node.stock.getSymbol()) < 0) {
            node.left = insert(node.left, stock);
        } else if (stock.getSymbol().compareTo(node.stock.getSymbol()) > 0) {
            node.right = insert(node.right, stock);
        } else {
            return node;
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));
        return balance(node);
    }

    /**
     * Delete a stock from the AVL Tree
     * @param symbol The symbol of the stock to delete
     */
    public void delete(String symbol) {
        root = delete(root, symbol);
    }

    /**
     * Get heights of AVL Tree after deleting a list of stocks
     * @param node Root node of AVL Tree
     * @param symbol List of stock symbols to delete
     * @return List of heights after each deletion
     */
    private Node delete(Node node, String symbol) {
        if (node == null) {
            return null;
        }

        if (symbol.compareTo(node.stock.getSymbol()) < 0) {
            node.left = delete(node.left, symbol);
        } else if (symbol.compareTo(node.stock.getSymbol()) > 0) {
            node.right = delete(node.right, symbol);
        } else {
            if (node.left == null || node.right == null) {
                node = (node.left != null) ? node.left : node.right;
            } else {
                Node temp = minValueNode(node.right);
                node.stock = temp.stock;
                node.right = delete(node.right, temp.stock.getSymbol());
            }
        }

        if (node == null) {
            return null;
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));
        return balance(node);
    }

    /**
     * Get the node with the minimum value in the AVL Tree
     * @param node Root node of AVL Tree
     * @return Node with the minimum value
     */
    private Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    // Search
    public Stock search(String symbol) {
        Node result = search(root, symbol);
        return (result != null) ? result.stock : null;
    }

    /**
     * Search for a stock in the AVL Tree
     * @param node Root node of AVL Tree
     * @param symbol Stock symbol to search for
     * @return Node containing the stock if found, null otherwise
     */
    private Node search(Node node, String symbol) {
        if (node == null || node.equals(symbol)) {
            return node;
        }

        if (node.compareTo(symbol) < 0) {
            return search(node.right, symbol);
        }

        return search(node.left, symbol);
    }

    /**
     * Balance the AVL Tree
     * @param node Root node of AVL Tree
     * @return Balanced AVL Tree
     */
    private Node balance(Node node) {
        int balanceFactor = getBalanceFactor(node);

        // Left heavy
        if (balanceFactor > 1) {
            if (getBalanceFactor(node.left) < 0) {
                node.left = leftRotate(node.left);
            }
            return rightRotate(node);
        }

        // Right heavy
        if (balanceFactor < -1) {
            if (getBalanceFactor(node.right) > 0) {
                node.right = rightRotate(node.right);
            }
            return leftRotate(node);
        }

        return node;
    }

    /**
     * Left rotate the AVL Tree
     * @param y Root node of AVL Tree
     * @return Rotated AVL Tree
     */
    private Node leftRotate(Node y) {
        Node x = y.right;
        Node T2 = x.left;

        x.left = y;
        y.right = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    /**
     * Right rotate the AVL Tree
     * @param y Root node of AVL Tree
     * @return Rotated AVL Tree
     */
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    /**
     * Get the balance factor of a node
     * @param node Node to get balance factor of
     * @return Balance factor of the node
     */
    private int getBalanceFactor(Node node) {
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }

    /**
     * Get the height of a node
     * @param node Node to get height of
     * @return Height of the node
     */
    private int height(Node node) {
        return (node == null) ? 0 : node.height;
    }

    /**
     * In-order traversal of the AVL Tree
     */
    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    /**
     * Pre-order traversal of the AVL Tree
     */
    public void preOrderTraversal() {
        preOrderTraversal(root);
    }

    /**
     * Post-order traversal of the AVL Tree
     */
    public void postOrderTraversal() {
        postOrderTraversal(root);
    }

    /**
     * In-order traversal of the AVL Tree
     * @param node Root node of AVL Tree
     */
    private void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.println(node.stock);
            inOrderTraversal(node.right);
        }
    }

    /**
     * Pre-order traversal of the AVL Tree
     * @param node Root node of AVL Tree
     */
    private void preOrderTraversal(Node node) {
        if (node != null) {
            System.out.println(node.stock);
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    /**
     * Post-order traversal of the AVL Tree
     * @param node Root node of AVL Tree
     */
    private void postOrderTraversal(Node node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.println(node.stock);
        }
    }
}
