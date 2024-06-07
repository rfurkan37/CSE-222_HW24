public class BinaryTreeTester {
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void main(String[] args) {
        BinaryTree<String> test = new BinaryTree("*",
                new BinaryTree("+",
                        new BinaryTree("x",
                                null,
                                null),
                        new BinaryTree("y",
                                null,
                                null)),
                new BinaryTree("/",
                        new BinaryTree("a",
                                null,
                                null),
                        new BinaryTree("b",
                                null,
                                null)));

        StringBuilder sb = new StringBuilder();

        test.inOrderOneLineTraverse(test.root, sb);
        System.out.println(sb.toString());// Programming exercise 1
    }
}
