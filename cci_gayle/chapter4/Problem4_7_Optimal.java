import java.util.*;

public class Problem4_7_Optimal{

	public static ResultAnc FindCommonAncestorRec(TreeNode root, TreeNode t1, TreeNode t2){
		
		if(root == null){
			return new ResultAnc(null , false);
		}	
		
		if (root == t1 && root == t2){
			return new ResultAnc (root, true);
		}
		ResultAnc lc =  FindCommonAncestorRec(root.left, t1, t2);
		if(lc.IsAncestorFound){
			return lc;
		}
		
		ResultAnc rc =  FindCommonAncestorRec(root.right, t1, t2);
		if(rc.IsAncestorFound){
			return rc;
		}
		
		if(lc.node != null && rc.node != null){
			return new ResultAnc(root, true);
		}
		else if (root == t1 || root == t2){
			bool isAnc = (lc.node != null || rc.node != null);
			return ResultAnc( root, isAnc);
		}
		else{
			return new ResultAnc( (lc.node != null) ? lc.node: rc.node, false);
		}
	}
	
	public static TreeNode FindCommonAncestor(TreeNode root, TreeNode t1, TreeNode t2){
		ResultAnc result = FindCommonAncestorRec(root, t1, t2);
		if(result.IsAncestorFound){
			return result.node;
		}
		return null;
	}
}	
	