import java.util.*;

public class Problem4_9{

	public static void PrintAllPaths(TreeNode node, int expectedSum){
		
		PrintAllPathsRec(node, new ArrayList<TreeNode>(), expectedSum);
	}

	public static void PrintAllPathsRec(TreeNode node, ArrayList<TreeNode> path, int expectedSum){
		if(node == null){
			return;
		}
		path.add(node);
		int curSum = 0;
		for(int i = path.size() - 1; i >= 0 ; i--){
			curSum = curSum + path.get(i);
			if(curSum == expectedSum){
				PrintPath(path, i );
			}
		}
		PrintAllPathsRec(node.left, path);
		PrintAllPathsRec(node.right, path);
		path.remove(node);
		
	}
	public static void PrintPath(ArrayList<TreeNode> path, int index){
		System.out.println ();
		for(int i = index; i < path.size() ; i++){
			System.out.print( String.format("%d ->" , path.get(i).data );
		}
		System.out.println ("NULL");
	}

}