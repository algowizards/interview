import java.util.*;

public class Problem4_3{

	public static TreeNode<Integer> ContructBinarySearchTree(Integer[] sortedArray){
		return ContructBinarySearchTreeRec(sortedArray, 0 , sortedArray.length -1);
	}
	
	public static TreeNode<Integer> ContructBinarySearchTreeRec(Integer[] sortedArray, int p , int r){
		if(p <= r ){
			
			int q = (p+r)/2;
			TreeNode<Integer> root = new TreeNode<Integer>(sortedArray[q]);
			root.left = ContructBinarySearchTreeRec(sortedArray, p, q-1);
			root.right = ContructBinarySearchTreeRec(sortedArray, q+1, r);
			return root;
		}
		return null;
	}
	
	public static void main(String args[]){
		Integer[] test = TestDataGenerator.GetArray(7, false, 20);
		TreeNode<Integer> root = ContructBinarySearchTree(test);
		BTreePrinter.printNode(root);
		
		
		test = TestDataGenerator.GetArray(10, false, 20);
		root = ContructBinarySearchTree(test);
		BTreePrinter.printNode(root);
		
		
		test = TestDataGenerator.GetArray(7, false, 20);
		TestDataGenerator.MakeRandomValuesNegative(test);
		Arrays.sort(test);
		root = ContructBinarySearchTree(test);
		BTreePrinter.printNode(root);

	}
	
	
}