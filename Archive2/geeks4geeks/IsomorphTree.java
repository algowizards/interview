import java.util.*;

public class IsomorphTree{
	
	public static boolean CheckIso(TreeNode t1, TreeNode t2){
		
		if(t1 == null && t2 == null){
			return true;
		}
		
		if(t1 != null && t2!= null && t1.data == t2.data){
			
			return (CheckIso(t1.left , t2.left) && CheckIso(t1.right , t2.right)) ||
			CheckIso(t1.left, t2.right) && CheckIso(t1.right , t2.left);
			
		}
		return false;
		
	}

	public static void main(String args[]){
		
		//tree 1
		
		TreeNode<Integer> root1 = new TreeNode<Integer>(1);
		root1.left = new TreeNode<Integer>(2);
		root1.right = new TreeNode<Integer>(3);
		
		root1.left.left = new TreeNode<Integer>(4);
		root1.left.right = new TreeNode<Integer>(5);
		root1.left.right.left = new TreeNode<Integer>(7);
		root1.left.right.right = new TreeNode<Integer>(8);
		
		root1.right.left = new TreeNode<Integer>(6);
		
		//tree 2
		
		TreeNode<Integer> root2 = new TreeNode<Integer>(1);
		root2.left = new TreeNode<Integer>(3);
		root2.right = new TreeNode<Integer>(2);
		
		root2.right.left = new TreeNode<Integer>(4);
		root2.right.right = new TreeNode<Integer>(5);
		root2.right.right.left = new TreeNode<Integer>(8);
		root2.right.right.right = new TreeNode<Integer>(7);
		
		root2.left.right = new TreeNode<Integer>(6);
		
		System.out.println("Tree isomorph? " + CheckIso(root1,root2));
	}
}