import java.util.*;


public class Problem4_1{

	public static Integer FindTreeDepthAndValidateIfBalanced(TreeNode<Integer> root){
		if(root == null){
			return 0;
		}
		
		int maxLeftDepth = FindTreeDepthAndValidateIfBalanced(root.left);
		if(maxLeftDepth == -1){
			return -1;
		}
		
		int maxRightDepth = FindTreeDepthAndValidateIfBalanced(root.right);
		if(maxRightDepth == -1){
			return -1;
		}
		
		if(Math.abs(maxLeftDepth - maxRightDepth) > 1){ //unbalanced
			return -1;
		}
		
		return Math.max(maxLeftDepth , maxRightDepth) + 1;
		
	}
	
	public static boolean IsTreeBalanced(TreeNode<Integer> root){
		if(FindTreeDepthAndValidateIfBalanced(root) == -1){
			return false;
		}
		return true;
	}
	
	public static void main(String args[]){
		
		TreeNode<Integer> root = TreeHelper.BuildRandomTree(10, 20, false);
		BTreePrinter.printNode(root);
		System.out.println("Is tree Balanced? : " + IsTreeBalanced(root));
		
		root = TreeHelper.BuildRandomTree(10, 20, true);
		BTreePrinter.printNode(root);
		System.out.println("Is tree Balanced? : " + IsTreeBalanced(root));
	}
}