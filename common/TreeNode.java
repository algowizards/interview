import java.util.*;

public class TreeNode<T extends Comparable<?>> {
    TreeNode<T> left, right, parent;
    T data;
	
    public TreeNode(T data) {
        this.data = data;
    }
}
