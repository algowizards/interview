import java.util.*;

public class LastAttempt_Graph{

	//bug: Graph instead of MyGraph; Stack<Integer> instead of Stack<GraphNode> -_- -_- ; null check for graph get all neighbors; reset all nodes to unvisited -_- -_- -_- -_-
	public static boolean DFS(MyGraph<Integer> g, GraphNode<Integer> start, GraphNode<Integer> target){
		
		if(g == null || start == null || target == null){
			return false;
		}
		
		for(GraphNode<Integer> n : g.GetAllNodes()){
			n.state = NodeState.Unprocessed;
		}
		
		java.util.Stack<GraphNode<Integer>> s = new java.util.Stack<GraphNode<Integer>>();
		start.state = NodeState.Processing;
		s.push(start);
		
		while(!s.isEmpty()){
			
			GraphNode<Integer> current = s.pop();
			System.out.println("Debug: Currently checking node: " + current.data);
			
			if(current.data == target.data){
				return true;
			}
			HashSet<GraphNode<Integer>> neighbors = g.GetAllNeighbors(current);
			if(neighbors != null){
				for(GraphNode<Integer> neighbor: neighbors)
				{
					if(neighbor.state == NodeState.Unprocessed){
						neighbor.state = NodeState.Processing;
						s.push(neighbor);
					}
				}
			}else{
				System.out.println("Debug: No neighbors for node: " + current.data);
			}
			
			current.state = NodeState.Processed;
		}
		
		return false;
	}
	
	//bug: Graph instead of MyGraph; -_-
	public static boolean BFS(MyGraph<Integer> g, GraphNode<Integer> start, GraphNode<Integer> target){
	
		if(g == null || start == null || target == null){
			return false;
		}
		
		for(GraphNode<Integer> n : g.GetAllNodes()){
			n.state = NodeState.Unprocessed;
		}
		
		LinkedList<GraphNode<Integer>> list = new LinkedList<GraphNode<Integer>>();
		
		start.state = NodeState.Processing;
		list.add(start);
		
		while(!list.isEmpty()){
		
			GraphNode<Integer> current = list.removeFirst();
			System.out.println("Debug: Currently checking node: " + current.data);
			
			if(current.data == target.data){
				return true;
			}
			HashSet<GraphNode<Integer>> neighbors = g.GetAllNeighbors(current);
			if(neighbors != null){
				for(GraphNode<Integer> neighbor: neighbors)
				{
					if(neighbor.state == NodeState.Unprocessed){
						neighbor.state = NodeState.Processing;
						list.add(neighbor);
					}
				}
			}
			current.state = NodeState.Processed;
		}
		return false;
	}
	
	
	public static String TopSort(MyGraph<Integer> g){
	
		if(g == null){
			return null;
		}
		
		Stack<GraphNode<Integer>> stack = new Stack<GraphNode<Integer>>();
		HashSet<GraphNode<Integer>> visitedSet = new HashSet<GraphNode<Integer>>();
		StringBuffer result = new StringBuffer();
		for(GraphNode<Integer> node:g.GetAllNodes()){
			if(!visitedSet.contains(node)){
				TopSortUtil(g, node, stack, visitedSet);
			}
		}
		
		while(!stack.isEmpty()){
			result.append((stack.pop().data + ", "));
		}
		
		return result.toString();
	}
	
	private static void TopSortUtil(MyGraph<Integer> g, GraphNode<Integer> node, Stack<GraphNode<Integer>> stack, HashSet<GraphNode<Integer>> visitedSet){
		
		visitedSet.add(node);
		
		for(GraphNode<Integer> neighbor: g.GetAllNeighbors(node)){
			if(!visitedSet.contains(neighbor)){
				TopSortUtil(g, neighbor, stack, visitedSet);
			}
		}
		//System.out.println("Pushing to stack: " + node.data);
		stack.push(node);
	}
	
	public static boolean DetectCyclesInGraph(MyGraph<Integer> g){
		if(g == null){
			return false;
		}			
		
		for(GraphNode<Integer> node : g.GetAllNodes()){
			node.state = NodeState.Unprocessed;
		}
		
		for(GraphNode<Integer> node : g.GetAllNodes()){
			if(node.state == NodeState.Unprocessed){
				boolean res = DetectCyclesRec(g, node);
				if(res){
					return true;
				}
			}
		}
		
		return false;
	}
	
	private static boolean DetectCyclesRec(MyGraph<Integer> g , GraphNode<Integer> node){
		if(node == null)
		{
			return false;
		}
		
		node.state = NodeState.Processing;
		
		for(GraphNode<Integer> neighbor : g.GetAllNeighbors(node)){
			if(neighbor.state == NodeState.Processing){
				return true;
			}
			else if(neighbor.state == NodeState.Unprocessed){
				boolean res = DetectCyclesRec(g, neighbor);
				if(res){
					return true;
				}
			}
		}
		node.state = NodeState.Processed;
		return false;
	}
	
	//graph problems CCI Gayle 4.1 to 4.12 
	
	//4.1 Path between two nodes
	
	
	public static boolean DoesPathExist(MyGraph<Integer> g, GraphNode<Integer> start, GraphNode<Integer> end){
	
		if(g == null || start == null || end == null)
		{
			return false;
		}
		
		if(start == end)
		{
			return true;
		}
		
		for(GraphNode<Integer> node : g.GetAllNodes()){
			node.state = NodeState.Unprocessed;
		}
		
		LinkedList<GraphNode<Integer>> list = 	new LinkedList<GraphNode<Integer>>();
		start.state = NodeState.Processing;
		list.add(start);
		
		while(!list.isEmpty())
		{
			GraphNode<Integer> currNode = list.removeFirst();
			HashSet<GraphNode<Integer>> neighbors = g.GetAllNeighbors(currNode);
			
			if(neighbors != null){
				for(GraphNode<Integer> neighbor: neighbors){
					if(neighbor.state == NodeState.Unprocessed){
						if(neighbor == end)
						{
							return true;
						}
						
						neighbor.state = NodeState.Processing;
						list.add(neighbor);
					}
				}				
			}
			
			currNode.state = NodeState.Processed;
		}
		return false;
	}
	
	
	public static HashSet<GraphNode<Integer>>  FindPotMayors(MyGraph<Integer> g)
	{
		HashSet<GraphNode<Integer>> result = new HashSet<GraphNode<Integer>>();
		
		if(g == null)
		{
			return result;
		}
		
		HashSet<GraphNode<Integer>> potMayors = new HashSet<GraphNode<Integer>>();
		
		for(GraphNode<Integer> node : g.GetAllNodes()){
			potMayors.add(node);
		}
		
		for(GraphNode<Integer> node : g.GetAllNodes()){
			for( GraphNode<Integer> neighbor : g.GetAllNodes()){
				
				if(node == neighbor){
					continue;
				}
				
				if( g.AreNeighbors(node, neighbor)){
					if(potMayors.contains(neighbor)){
						potMayors.remove(neighbor);
					}
				}
			}
		}
		
		for(GraphNode<Integer> potMayor : potMayors){
			if(g.GetAllNeighbors(potMayor).size() == g.GetAllNodes().size() - 1 )
			{
				result.add(potMayor);
			}
		}
		
		return result;
	}
	

	public static HashSet<GraphNode<Integer>> FindPotMayorsAtt2(MyGraph<Integer> g){
		
		HashSet<GraphNode<Integer>> result = new HashSet<GraphNode<Integer>>();
		
		if(g == null){
			return result;
		}
		
		HashSet<GraphNode<Integer>> potMayors = new HashSet<GraphNode<Integer>>();
		
		for(GraphNode<Integer> node: g.GetAllNodes()){
			potMayors.add(node);
		}
		
		for(GraphNode<Integer> node: g.GetAllNodes()){
			for(GraphNode<Integer> neighbor: g.GetAllNodes()){
				if(node == neighbor){
					continue;
				}
				if(g.AreNeighbors(node, neighbor) && potMayors.contains(neighbor)){
					potMayors.remove(neighbor);
				}
			}
		}
		
		/*
		for(GraphNode<Integer> potMayor: potMayors){
			if(g.GetAllNeighbors(potMayor).size() == g.GetAllNodes().size() - 1){
				result.add(potMayor);
			}
		}	
		return result;
		*/
		
		for(Iterator<GraphNode<Integer>> iter = potMayors.iterator(); iter.hasNext();){
			GraphNode<Integer> potMayor = iter.next();
			if(g.GetAllNeighbors(potMayor).size() != g.GetAllNodes().size() -1){
				iter.remove();
			}
		}
		
		return potMayors;
	}
	
	
	public static TreeNode<Integer>  GenerateMinimalTree(int[] sorted){
	
	if(sorted == null || sorted.length == 0){
		return null;
	}
	
	TreeNode<Integer>  root = GenerateMinTreeRec(sorted, 0, sorted.length - 1);
	return root;
	
	}
	
	private static TreeNode<Integer>  GenerateMinTreeRec(int[] sorted, int p, int q)
	{
		if( q < p)
		{
			return null;
		}
			
		int m = (p + q)/2;
		
		TreeNode<Integer>  node = new TreeNode<Integer>(sorted[m]);
		node.left = GenerateMinTreeRec(sorted, p, m - 1);
		node.right = GenerateMinTreeRec(sorted, m+1, q);
		return node;
	}
	
	
	
	public static TreeNode<Integer>  GenerateMinTreeAtt2(int[] sorted){
		
		if(sorted == null || sorted.length == 0)
		{
			return null;
		}
		
		TreeNode<Integer>  root = GenMinTreeAtt2(sorted, 0, sorted.length - 1);
		return root;
	}
	
	private static TreeNode<Integer>  GenMinTreeAtt2(int[] sorted, int p, int q){
	
		if( q < p){
			return null;
		}
		
		int m = ( p + q)/2;
		
		TreeNode<Integer>  node = new TreeNode<Integer>(  sorted[m]);
		node.left = GenMinTreeAtt2 (sorted, p, m -1);
		node.right = GenMinTreeAtt2 (sorted, m+1, q);
		
		return node;
	}
	
	public static ArrayList<ArrayList<TreeNode<Integer>>> TreeToListOfLists(TreeNode<Integer> root){
		if(root == null)
		{
			return null;
		}
		
		ArrayList<ArrayList<TreeNode<Integer>>> finalLists = new ArrayList<ArrayList<TreeNode<Integer>>>();
		
		ArrayList<TreeNode<Integer>> currList = new ArrayList<TreeNode<Integer>>();
		currList.add(root);
		
		while(!currList.isEmpty()){
		
			finalLists.add(currList);
			
			ArrayList<TreeNode<Integer>> newList = new ArrayList<TreeNode<Integer>>();		
			
			for(TreeNode<Integer>  currElt: currList){
				if(currElt.left != null){
					newList.add(currElt.left);
				}
				
				if(currElt.right != null)
				{
					newList.add(currElt.right);
				}
			}
			
			currList = newList;	
		}
		
		return finalLists;
	}
	
	public boolean IsBalanced(TreeNode<Integer> root){
		if(root == null)
		{
			return false;
		}
		
		BalancedResult br = IsBalancedRec(root);
		return !br.isUnbalanceDetected;
	}
	
	private BalancedResult IsBalancedRec(TreeNode<Integer>  root)
	{
		if(root == null)
		{
			return new BalancedResult(false, 0);
		}
		
		BalancedResult leftRes = IsBalancedRec(root.left);
		if(leftRes.isUnbalanceDetected){
			return leftRes; 
		}
		
		BalancedResult rightRes = IsBalancedRec(root.right);
		if(rightRes.isUnbalanceDetected){
			return rightRes;
		}
		
		boolean isUnbalanced = Math.abs(leftRes.height - rightRes.height) > 1 ;
		int height = Math.max(leftRes.height, rightRes.height) + 1;
		
		return new BalancedResult(isUnbalanced, height);
	}
	
	
	/*public static boolean  CheckBST(TreeNode<Integer>  root)
	{
		if(root == null)
		{
			return true;
		}
		
		MinMaxResult mmr = CheckBSTRec(root);
		return root.IsValidBST;
		
	}
	
	private static MinMaxResult CheckBSTRec(TreeNode<Integer>  root)
	{
		if( root == null){
			return new MinMaxResult(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
		}
		
		MinMaxResult leftRes = CheckBSTRec(root.left);
		
		if(!leftRes.IsValidBST){
			return leftRes;
		}

		MinMaxResult rightRes = CheckBSTRec(root.right);
		
		if(!rightRes.IsValidBST){
			return rightRes;
		}

		boolean isValidBST = root.data > leftRes.MaxVal && root.data < rightRes.MinVal;
		
		return new MinMaxResult(Math.max(root.data, leftRes.MaxVal), Math.min(root.data,  rightRes.MinVal), isValidBST);
		
	}*/
	
	
	public static boolean CheckBSTAtt2(TreeNode<Integer> root){
		return CheckBSTRecAtt2(root, null, null);	
	}
	
	private static boolean CheckBSTRecAtt2(TreeNode<Integer> root, Integer min, Integer max){
		if(root == null)
		{
			return true;
		}
		
		if(min != null  && root.data <= min){
			return false;
		}
		
		if( max != null && root.data > max){
			return false;
		}
		
		if(!CheckBSTRecAtt2(root.left, min, root.data) || !CheckBSTRecAtt2(root.right, root.data, max)){
			return false;
		}
			
		return true;
	}
	
	public static boolean CheckBSTAtt3(TreeNode<Integer> root){
		return CheckBSTRecAtt3(root, null, null);
	}
	
	private static boolean CheckBSTRecAtt3 (TreeNode<Integer> root, Integer min, Integer max){
		
		if(root == null){
			return true;
		}
		
		if( (min!= null && root.data <= min) || ( max != null && root.data > max) ){
			return false;
		}
		
		if( !CheckBSTRecAtt3(root.left, min, root.data) || !CheckBSTRecAtt3(root.right, root.data, max)){
			return false;
		}
		
		return true;
	}
	
	public static TreeNode<Integer> InOrderSuccessor(TreeNode<Integer> node){
		if(node == null){
			return null;
		}
		
		if(node.right != null){
			TreeNode<Integer> ios = node.right;
			while(ios.left != null){
				ios = ios.left;
			}
			return ios;
		}
		
		TreeNode<Integer> parentNode = node.parent;
		
		while( parentNode != null && node == parentNode.right) // or equivalently, node!= parentNode.left
		{
			node = parentNode;
			parentNode = parentNode.parent;
		}
		
		return parentNode;
	}
	
	public static int DupCountBST(TreeNode<Integer> node)
	{
		if(node == null){
			return 0;
		}
		
		DupCounterResult dcr = DupCountBSTRec(node, null);
		if(dcr != null){
			return dcr.dupCount;
		}
		return 0;
	}
	
	private static DupCounterResult DupCountBSTRec(TreeNode<Integer> node, DupCounterResult prevRes){
		
		DupCounterResult cur = null;
		DupCounterResult toMergeRes = null;
		
		if(node.left != null){
			toMergeRes = DupCountBSTRec(node.left, prevRes);
		}else{
			toMergeRes = prevRes;
		}
		
		//update the dup count based on current node
		if(toMergeRes != null){
		
			if(toMergeRes.value  == node.data){
				cur = new DupCounterResult(node.data, toMergeRes.dupCount + 1);
			}
			else{
				cur = new DupCounterResult(node.data, toMergeRes.dupCount);
			}
			
		}else{
				cur = new DupCounterResult(node.data, 0);
		}
		
		// if we have a right child, pass current data to right node (in order successor). else return to parent.
		if(node.right != null){
			return DupCountBSTRec(node.right, cur);
		}
		
		return cur;
	}
	
	
	public static void main(String args[]) throws Exception{
		MyGraph<Integer> mg = GraphHelper.GenerateRandomGraph(10, .8, false);
		mg.PrintGraph();
		GraphNode<Integer> start =  mg.GetStartNode();
		GraphNode<Integer> target = mg.GetRandomNode(); 
		
		System.out.println("A path between the nodes "+ start.data + " and " + target.data + " exist (DFS)? " +  DoesPathExist(mg, start, target));
		
		/*
		mg = GraphHelper.CreateTopSortGraph();
		mg.PrintGraph();

		System.out.println("A path between the nodes "+ start.data + " and " + target.data + " exist (BFS)? " +  BFS(mg, start, target));
		System.out.println("Topological sort of graph is : " + TopSort(mg));
		System.out.println("A Loop exists in the graph MG? " + DetectCyclesInGraph(mg));
		
		MyGraph<Integer> mg2 = GraphHelper.CreateLoopDetectionGraph1();
		mg2.PrintGraph();
		System.out.println("A Loop exists in the graph? " + DetectCyclesInGraph(mg2));
		*/
		
		MyGraph<Integer> mg2 = GraphHelper.CreateTopSortGraph();
		mg2.PrintGraph();
		System.out.println("Topological sort of graph is : " + TopSort(mg2));
		
		
		mg = GraphHelper.CreatePotentialMayorGraph();
		mg.PrintGraph();
		System.out.println("Potential Mayors:  " + GraphHelper.ToString(FindPotMayorsAtt2(mg)));
		
		//int[] sortedData = new int[] {0, 1, 1, 2, 3, 5, 6, 6, 7};
		int[] sortedData = new int[] {0, 1, 1};
		TreeNode<Integer> root = GenerateMinimalTree(sortedData);
		BTreePrinter.printNode(root);
		
		System.out.println("Duplicate count in BST:  " + DupCountBST(root));
		
	}
	
	
	
	
}