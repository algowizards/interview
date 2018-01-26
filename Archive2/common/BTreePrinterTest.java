import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BTreePrinterTest {

    private static TreeNode<Integer> test1() {
        TreeNode<Integer> root = new TreeNode<Integer>(2);
        TreeNode<Integer> n11 = new TreeNode<Integer>(7);
        TreeNode<Integer> n12 = new TreeNode<Integer>(5);
        TreeNode<Integer> n21 = new TreeNode<Integer>(2);
        TreeNode<Integer> n22 = new TreeNode<Integer>(6);
        TreeNode<Integer> n23 = new TreeNode<Integer>(3);
        TreeNode<Integer> n24 = new TreeNode<Integer>(6);
        TreeNode<Integer> n31 = new TreeNode<Integer>(5);
        TreeNode<Integer> n32 = new TreeNode<Integer>(8);
        TreeNode<Integer> n33 = new TreeNode<Integer>(4);
        TreeNode<Integer> n34 = new TreeNode<Integer>(5);
        TreeNode<Integer> n35 = new TreeNode<Integer>(8);
        TreeNode<Integer> n36 = new TreeNode<Integer>(4);
        TreeNode<Integer> n37 = new TreeNode<Integer>(5);
        TreeNode<Integer> n38 = new TreeNode<Integer>(8);

        root.left = n11;
        root.right = n12;

        n11.left = n21;
        n11.right = n22;
        n12.left = n23;
        n12.right = n24;

        n21.left = n31;
        n21.right = n32;
        n22.left = n33;
        n22.right = n34;
        n23.left = n35;
        n23.right = n36;
        n24.left = n37;
        n24.right = n38;

        return root;
    }

    private static TreeNode<Integer> test2() {
        TreeNode<Integer> root = new TreeNode<Integer>(2);
        TreeNode<Integer> n11 = new TreeNode<Integer>(7);
        TreeNode<Integer> n12 = new TreeNode<Integer>(5);
        TreeNode<Integer> n21 = new TreeNode<Integer>(2);
        TreeNode<Integer> n22 = new TreeNode<Integer>(6);
        TreeNode<Integer> n23 = new TreeNode<Integer>(9);
        TreeNode<Integer> n31 = new TreeNode<Integer>(5);
        TreeNode<Integer> n32 = new TreeNode<Integer>(8);
        TreeNode<Integer> n33 = new TreeNode<Integer>(4);

        root.left = n11;
        root.right = n12;

        n11.left = n21;
        n11.right = n22;

        n12.right = n23;
        n22.left = n31;
        n22.right = n32;

        n23.left = n33;

        return root;
    }

    public static void main(String[] args) {

        BTreePrinter.printNode(test1());
        BTreePrinter.printNode(test2());

    }
}
