import java.util.*;

public class Problem4_4{
	public static ArrayList<ArrayList<Node>> ConvertBSTToBFSList (TreeNode root)throws Exception{
		
		ArrayList<ArrayList<Node>> masterList = new ArrayList<ArrayList<Node>>();
		Queue<TreeNode> levelQ = new LinkedList<TreeNode>();
		levelQ.add(root);
		
		while(!levelQ.isEmpty()){
			
			ArrayList<Node> levelList = new ArrayList<Node>();
			Queue<TreeNode> levelQNext = new LinkedList<TreeNode>();
			
			while(!levelQ.isEmpty()){
				TreeNode top = levelQ.remove();
				levelList.add(new Node((Integer)top.data));
				if(top.left != null){
					levelQNext.add(top.left);
				}
				if(top.right != null){
					levelQNext.add(top.right);
				}
			}
			masterList.add(levelList);
			levelQ = levelQNext;
		}
		return masterList;
	}

	public static void main(String args[]) throws Exception {
		Integer[] test = TestDataGenerator.GetArray(7, false, 20);
		TreeNode<Integer> root = Problem4_3.ContructBinarySearchTree(test);
		System.out.println();
		BTreePrinter.printNode(root);
		ArrayList<ArrayList<Node>> masterList = ConvertBSTToBFSList(root);
		TestDataGenerator.PrintMasterList(masterList);
		
		test = TestDataGenerator.GetArray(20, false, 20);
		root = Problem4_3.ContructBinarySearchTree(test);
		System.out.println();
		BTreePrinter.printNode(root);
		masterList = ConvertBSTToBFSList(root);
		TestDataGenerator.PrintMasterList(masterList);
		
		test = TestDataGenerator.GetArray(20, true, 20);
		Arrays.sort(test);
		root = Problem4_3.ContructBinarySearchTree(test); 
		System.out.println();
		BTreePrinter.printNode(root);
		masterList = ConvertBSTToBFSList(root);
		TestDataGenerator.PrintMasterList(masterList);
		
		

		
		
		
		

	}
	
	
}