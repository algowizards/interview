import java.util.*;


public class Problem4_5{
	public static boolean IsTreeBST(TreeNode<Integer> root){
		try{
			
			ValidateTreeIsBST(root);
		}catch(InvalidDataException ide){
			return false;
		}
		return true;
	}
	
	public static MinMax ValidateTreeIsBST(TreeNode<Integer> root)throws InvalidDataException{
		
		if(root == null){
			return null;
		}
		MinMax result = new MinMax();
		
		MinMax left = ValidateTreeIsBST(root.left);
		if( left != null ){
			
			if( (left.min != null && left.min > root.data ) || (left.max != null && left.max > root.data) ){
				throw new InvalidDataException (String.format("Failed at node : {%d} ", root.data));
			}
			result.min = left.min;
		}else{
			result.min = root.data;
		}
		MinMax right = ValidateTreeIsBST(root.right);
		if( right != null ){
			if( (right.min != null && right.min < root.data) || (right.min != null && right.max < root.data) ){
					throw new InvalidDataException (String.format("Failed at node : {%d} ", root.data));
			}
			result.max = right.max;
		}else{
			result.max = root.data;
		}
		System.out.println("root = " + root.data);
		System.out.println (" min = " + result.min + "max = " + result.max);
		return result;
	}
	

	
	public static void main(String args[]){
		
		TreeNode<Integer> root = TreeHelper.BuildRandomTree(10, 20, false);
		BTreePrinter.printNode(root);
		System.out.println("Is tree BST? : " + IsTreeBST(root));
		
		Integer[] test = TestDataGenerator.GetArray(100, false, 200);
		root = Problem4_3.ContructBinarySearchTree(test);
		System.out.println();
		BTreePrinter.printNode(root);
		System.out.println("Is tree BST? : " + IsTreeBST(root));
	}
}