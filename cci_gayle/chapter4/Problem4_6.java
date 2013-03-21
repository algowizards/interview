
public class Problem4_6{
	
	public static TreeNode GetNextInOrderSuccessor(TreeNode node){
		if (node == null){
			return null;
		}
		if(node.right != null){
			FindLeftMost(node.right);
		}
		
		while( (node.parent!= null) && (node.parent.right == node) ){
			node = node.parent;
		}
		return node.parent;
		
	} 
	
	private static TreeNode FindLeftMost(TreeNode node){
		if(node == null){ //redundant for this problem though
			return null;
		}
		while( node.left != null ){
			node = node.left;
		}
		return node;
		
	}

}
