public class KthLargest{
	//flatten it. use order stats.
	//time: O(n) //space: O(n)
	public static Integer KthLargestInATree(TreeNode<Integer> root)
		
		ArrayList<Integer> inputData = GetAllElements(root);
		if(k > inputData.size()){
			return null; // gotta be between 1 and size
		}
		return OrderStats(inputData, 0, inputData.size()-1, k);		
	}
	
	public Integer OrderStats(ArrayList<Integer> , int p, int r, int k){
		
		if(p < q){
			q =  Partition
		}
		
		
	}
	
	private static void GetAllElements(TreeNode<Integer> root){
		if(root == null)
		{
			return null;
		}
		ArrayList<Integer> inputData = new ArrayList<Integer>();
		//can do BFS or DFS. I'm going the BFS way
		LinkedList<Treenode> q = new LinkedList<TreeNode>();
		
		q.Add(root.data);
		
		while( q.peek() != null){
			
			TreeNode<Integer> elt = q.poll();
			inputData.add(elt.data);
			if( elt.left != null){
				q.offer(elt.left);
			}
			if(elt.right != null){
				q.offer(elt.right);
			}
			
		}
		return inputData;
		
	}

}