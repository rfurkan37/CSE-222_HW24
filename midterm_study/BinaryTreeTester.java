import java.io.*;

public class BinaryTreeTester {
    public static void main(String[] args){
        BinaryTree<String> test = new BinaryTree("Root",
                new BinaryTree("Left",
                        null,
                        null),
                new BinaryTree("Right",
                        null,
                        null));


        StringBuilder sb = new StringBuilder();

        test.preOrderOneLineTraverse(test.root,sb);
        System.out.println(sb.toString());//Programming exercise 1
    }
}
