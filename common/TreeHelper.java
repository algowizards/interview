import java.util.*;

public class TreeHelper{
	static int nodeVal = 0;
	public static TreeNode<Integer> BuildRandomTree(int n, int bound, boolean biased ){
		return BuildRandomTree(n, bound, biased, false);
	}
	
	public static TreeNode<Integer> BuildRandomTree(int n, int bound, boolean biased, boolean positiveOnly ){
		return BuildRandomTree(n, bound, biased, false, true);
	}
	public static TreeNode<Integer> BuildRandomTree(int n, int bound, boolean biased, boolean positiveOnly, boolean random){
		nodeVal = 0;
		return BuildRandomTree(n, bound, biased, positiveOnly, random, true);
	}
	
	private static TreeNode<Integer> BuildRandomTree(int n, int bound, boolean biased, boolean positiveOnly, boolean random, boolean internal){
		
		if (n <= 0){
			return null;
		}
		int value;
		
		if(!random){
			value = (nodeVal++) % bound;
		}else{
			Random r = new Random();
			value = ( positiveOnly ? (Math.abs( r.nextInt() % bound ) ): ( r.nextInt() % bound ) );	
		}
		
		TreeNode<Integer> root = new TreeNode<Integer>(value);
		n = n-1; //reduce 'n' by 1 for current node and recursively generate for n-1 nodes
		int firstHalf = n/2;
		int secondHalf = n - (n/2);
		
		if(biased){
			Random r = new Random();
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
		
		root.left = BuildRandomTree(firstHalf, bound, biased, positiveOnly, random, true);
		root.right = BuildRandomTree(secondHalf , bound, biased, positiveOnly, random, true);
		return root;
	}
	
	
	public static void main(String args[]){
		TreeNode<Integer> root = BuildRandomTree(7, 20, false, true);
		BTreePrinter.printNode(root);
		
		root = BuildRandomTree(40, 20, false, false);
		BTreePrinter.printNode(root);
		
		root = BuildRandomTree(10, 10, false, true, false);
		BTreePrinter.printNode(root);


	}
	
}