public class AVLTree {
    private class Node {
        Stock stock;
        Node left, right;
        int height;

        Node(Stock stock) {
            this.stock = stock;
            this.height = 1;
        }
    }

    private Node root;

    // Insertion
    public void insert(Stock stock) {
        root = insert(root, stock);
    }

    private Node insert(Node node, Stock stock) {
        // Implementation of AVL Tree insertion logic
        return node;
    }

    // Deletion
    public void delete(String symbol) {
        root = delete(root, symbol);
    }

    private Node delete(Node node, String symbol) {
        // Implementation of AVL Tree deletion logic
        return node;
    }

    // Search
    public Stock search(String symbol) {
        Node result = search(root, symbol);
        return (result != null) ? result.stock : null;
    }

    private Node search(Node node, String symbol) {
        // Implementation of AVL Tree search logic
        return node;
    }

    // Balancing methods (left rotation, right rotation, etc.)
    // Height update and balance factor calculations

    // In-order, pre-order, post-order traversals
    // For example:
    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.println(node.stock);
            inOrderTraversal(node.right);
        }
    }
}
