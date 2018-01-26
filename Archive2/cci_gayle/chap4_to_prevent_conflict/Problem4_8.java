public class PRoblem4_8{

	public static bool IsT2SubTreeOfT1(TreeNode t1, TreeNode t2){
		if(t1 == null && t2 == null){
			return true;
		}
		if(t1 == null || t2 == null){
			return false;
		}
		
		List<TreeNode> q = new List<TreeNode>();
		q.add(t1);
		
		while(!q.IsEmpty()){
			TreeNode top = q.remove();
			if(top.data == t2.data){
				if(CompareTreesRec(top , t2)){
					return true;
				}
			}	
			if(top.left != null){
				q.add(top.left);
			}
			if(top.right != null){
				q.add(top.right);
			}
		}
			
	}
	public static bool CompareTreesRec(TreeNode t1, TreeNode t2){
		if(t1 == null && t2 == null){
			return true;
		}
		if(t1 != null && t2 != null){
			if(t1.data == t2.data){
				return (CompareTreesRec(t1.left, t2.left) && CompareTreesRec(t1.right, t2.right) );
			}
		}
		return false;
	}
}