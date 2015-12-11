import java.util.*;

public class TreeHelper{

	public static TreeNode<Integer> BuildRandomTree(int n, int bound, boolean biased ){
		return BuildRandomTree(n, bound, biased, false);
	}
	public static TreeNode<Integer> BuildRandomTree(int n, int bound, boolean biased, boolean positiveOnly){
		
		if (n <= 0){
			return null;
		}
		Random r = new Random();
		TreeNode<Integer> root = new TreeNode<Integer>((positiveOnly ?(Math.abs(r.nextInt()%bound)): (r.nextInt()%bound)));
		n = n-1; //reduce 'n' by 1 for current node and recursively generate for n-1 nodes
		int firstHalf = n/2;
		int secondHalf = n - (n/2);
		
		
		if(biased){
			int randomChoice = Math.abs(r.nextInt()%3); // left skewed, right skewed and unbiased
			switch(randomChoice)
			{
				case 0: // left skewed
				secondHalf = 0;
				break;
				case 1: // right skewed
				firstHalf = 0;
				break;
				default: // no skew 
				break;
			}
		}
		
		root.left = BuildRandomTree(firstHalf, bound, biased, positiveOnly);
		root.right = BuildRandomTree(secondHalf , bound, biased, positiveOnly);
		return root;
	}
	
	
	public static void main(String args[]){
		TreeNode<Integer> root = BuildRandomTree(7, 20, false, true);
		BTreePrinter.printNode(root);
		
		root = BuildRandomTree(7, 20, false, false);
		BTreePrinter.printNode(root);

	}
	
}