import java.util.*;

public class ConvertBSTToDLL{
	public static DLLNode<Integer> Convert(TreeNode<Integer> root){
		if(root == null){
			return null;
		}
		DLLNode<Integer> mid = new DLLNode<Integer>(root.data);
		
		if(root.left == null && root.right == null){
			return mid;
		}
		
		DLLNode<Integer> leftSubList = Convert(root.left);
		DLLNode<Integer> rightSubList = Convert(root.right);
		
		while(leftSubList != null && leftSubList.right != null){
			leftSubList = leftSubList.right;
		}
		
		while(rightSubList != null && rightSubList.left != null){
			rightSubList = rightSubList.left;
		}
		//link them to current node
		mid.left = leftSubList;
		if(leftSubList != null){
			leftSubList.right = mid;
		}
		mid.right = rightSubList;
		if(rightSubList!= null){
			rightSubList.left = mid;
		}
		return mid;
	}
	
	public static DLLNode<Integer> ConvertAndMoveToStart(TreeNode<Integer> root){
		DLLNode<Integer> mid = Convert(root);
		while (mid.left != null){
			mid = mid.left;
		}
		return mid;
	}
	
	public static void main(String args[]){
		TreeNode<Integer> root = TreeHelper.BuildRandomTree(10, 20, false);
		BTreePrinter.printNode(root);
		DLLNode<Integer> conv = ConvertAndMoveToStart(root);
		DLLHelper.printList(conv);
		
	}
	
}