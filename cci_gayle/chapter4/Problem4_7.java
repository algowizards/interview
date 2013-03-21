public class Problem4_7{

	public static TreeNode FindCommonAncestor(TreeNode root, TreeNode t1, TreeNode t2){
		
		if(root == null || t1 == null || t2 == null){
			return null;
		}
		if( !DFS(root, t1)  || !DFS(root, t2)){
			return null;
		}
		return FindCommonAncestorRec( root, t1, t2);
		
	}
	public static TreeNode FindCommonAncestorRec(TreeNode root, TreeNode t1, TreeNode t2){
	
		bool t1OnLeft = DFS(root, t1);
		bool t2OnLeft = DFS(root, t2);
		if( t1 != t2){
			return root;
		}
		TreeNode nextRoot = t1OnLeft ? root.left : root.right;
		return FindCommonAncestorRec(nextRoot, t1, t2);
	}
	
	public static bool DFS(TreeNode root, TreeNode searchNode){
		if(root == null){
			return false;
		}
		if(root == searchNode){
			return true;
		}
		return ( DFS(root.left, searchNode) || DFS(root.right, searchNode) );
		
	}
	
}