import java.util.*;

public class TreeNode<T extends Comparable<?>> {
    TreeNode<T> left, right;
    T data;

    public TreeNode(T data) {
        this.data = data;
    }
}
