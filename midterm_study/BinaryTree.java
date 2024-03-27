import java.io.*;
import java.util.Scanner;

public class BinaryTree<E> {
    protected static class Node<E> implements Serializable {
        protected E data;

        protected Node<E> left;
        protected Node<E> right;

        public Node(E data) {
            this.data = data;
            left = null;
            right = null;
        }

        public String toString() {
            return data.toString();
        }
    }

    protected Node<E> root;

    // Construct an empty binary tree
    public BinaryTree() {
        root = null;
    }

    // Constructs a binary tree with the given node as a root
    protected BinaryTree(Node<E> root) {
        this.root = root;
    }

    // Constructs a binary tree with the given data
    public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
        root = new Node<E>(data);

        if (leftTree != null) {
            root.left = leftTree.root;
        } else {
            root.left = null;
        }

        if (rightTree != null) {
            root.right = rightTree.root;
        } else {
            root.right = null;
        }

    }

    public BinaryTree<E> getLeftSubtree() {
        if (root != null && root.left != null) {
            return new BinaryTree<E>(root.left);
        } else
            return null;
    }

    public BinaryTree<E> getRightSubtree() {
        if (root != null && root.right != null) {
            return new BinaryTree<E>(root.right);
        } else
            return null;
    }

    /**public E getData() {

    }*/

    /**
     * Determine whether this tree is a leaf
     * @return true if the root has no children
     */
    public boolean isLeaf() {
        return (root.left == null && root.right == null);
    }

    /**
     * Convert a subtree to a string
     * @return the string representation of the subtree
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        preOrderTraverse(root, 1, sb);
        return sb.toString();
    }

    /**
     * Preorder traversal from a given node
     *
     * @param node the local root
     * @param depth the depth
     * @param sb   the string buffer to save the output
     */
    private void preOrderTraverse(Node<E> node, int depth, StringBuilder sb) {
        for(int i = 1; i < depth; i++)
        {
            sb.append(" ");
        }
        if(node == null)
        {
            sb.append("null\n");
        }
        else{
            sb.append(node.toString());
            sb.append("\n");
            preOrderTraverse(node.left, depth + 1, sb);
            preOrderTraverse(node.right, depth + 1, sb);
        }
    }

    public void preOrderOneLineTraverse(Node<E> node, StringBuilder sb){
        if(node == null)
        {
            sb.append("null ");
        }
        else{
            sb.append(node.toString()).append(" ");
            preOrderOneLineTraverse(node.left, sb);
            preOrderOneLineTraverse(node.right, sb);
        }
    }

    /**
     * Inorder traverse
     * @param node
     * @param depth
     * @param sb
     */
    private void inOrderTraverse(Node<E> node, int depth, StringBuilder sb) {
        for(int i = 1; i < depth; i++)
        {
            sb.append(" ");
        }
        if(node == null)
        {
            sb.append("null\n");
        }
        else{
            preOrderTraverse(node.left, depth + 1, sb);
            sb.append(node.toString());
            sb.append("\n");
            preOrderTraverse(node.right, depth + 1, sb);
        }
    }

    private void postOrderTraverse(Node<E> node, int depth, StringBuilder sb) {
        for(int i = 1; i < depth; i++)
        {
            sb.append(" ");
        }
        if(node == null)
        {
            sb.append("null\n");
        }
        else{
            preOrderTraverse(node.left, depth + 1, sb);
            preOrderTraverse(node.right, depth + 1, sb);
            sb.append(node.toString());
            sb.append("\n");
        }
    }


    /**
     * Method to read a binary tree
     * @param scan the scanner to read from
     * @return the binary tree
     */
    public static BinaryTree<String> readBinaryTree(Scanner scan) {
        String data = scan.next();
        if (data.equals("null")){
            return null;
        }
        else{
            BinaryTree<String> leftTree = readBinaryTree(scan);
            BinaryTree<String> rightTree = readBinaryTree(scan);
            return new BinaryTree<String>(data, leftTree, rightTree);
        }
    }

}