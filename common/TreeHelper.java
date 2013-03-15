import java.util.*;

public class TreeHelper{

	public static TreeNode<Integer> BuildRandomTree(int n, int bound, boolean biased){
		
		if (n <= 0){
			return null;
		}
		Random r = new Random();
		TreeNode<Integer> root = new TreeNode<Integer>(r.nextInt()%bound);
		n = n-1; //for current node
		int firstHalf = n/2;
		int secondHalf = n - (n/2);
		
		int randomChoice = r.nextInt()%400;
		if(biased){
			randomChoice = (int) (randomChoice * 2);
		}
		if( randomChoice < 100 ){
			secondHalf = 0;
		}else if( randomChoice < 200 ){
			firstHalf = 0 ;
		}else if ( randomChoice < 300 ){
			firstHalf = 0 ;
			secondHalf = 0;
		}
		root.left = BuildRandomTree(firstHalf + secondHalf, bound, biased);
		root.right = BuildRandomTree(n - (firstHalf + secondHalf) , bound, biased);
		return root;
	}
	
	
	public static void main(String args[]){
		TreeNode<Integer> root = BuildRandomTree(10, 20, false);
		BTreePrinter.printNode(root);
	}
	
}