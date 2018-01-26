
//min max, cleaner implementation
public class Problem4_5_Clean{
	
	public static bool IsTreeBST(TreeNode root){
		return IsTreeBSTRec(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	public static bool IsTreeBSTRec(TreeNode root, int min, int max){
		
		if(root == null){
			return true;
		}
		
		if(  !(root.value >= min && root.value <= max) ){
			return false;
		}
		return IsTreeBSTRec(root.left, min, root.value) && IsTreeBSTRec(root.right, root.value, max);
		
	}

}