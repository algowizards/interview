import java.util.*;

public class Chap4TreesAndGraphs{
	
	public static void InOrderTraversal(TreeNode root){
	
		if(root == null){
			return;
		}
		InOrderTraversal(root.left);
		ProcessNode(root);
		InOrderTraversal(root.right);
	}
	
	public static void PreOrderTraversal(TreeNode root){
	
		if(root == null){
			return;
		}
		ProcessNode(root);
		PreOrderTraversal(root.left);
		PreOrderTraversal(root.right);
	}
	
	public static void PostOrderTraversal(TreeNode root){
	
		if(root == null){
			return;
		}
		PostOrderTraversal(root.left);
		PostOrderTraversal(root.right);
		ProcessNode(root);
	}

	//fixed bug: final return statement if nothing was found -_-
	public static TreeNode BFS(TreeNode root, Integer key){
		
		if(root == null){
			return root;
		}
		
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			
			TreeNode current = queue.removeFirst();
			System.out.println("Tracing the traversal . verifying node with data:  " + current.data);
			if(current.data == key){
				return current;
			}
			
			if(current.left !=null){
				queue.add(current.left);
			}
			if(current.right!=null){
				queue.add(current.right);
			}
		}
		
		return null;
	}
	
	//fixed bug: final return statement if nothing was found -_-
	// wasn't returning the DFS of sub nodes. -_- -_- -_-
	public static TreeNode DFS(TreeNode root, Integer key){
		if(root == null){
			return root;
		}
		
		System.out.println("Tracing the traversal . verifying node with data:  " + root.data);
		if(	root.data == key){
			return root;
		}	
		
		TreeNode result;
		result = DFS(root.left, key);
		if(result!=null){
			return result;
		}
		
		result = DFS(root.right, key);
		if(result != null ){
			return result;
		}
		
		return null;
	}
	
	//fixed bug: FUCK!!! final return statement if nothing was found -_- grrr!
	public static TreeNode DFSStack(TreeNode root, Integer key){
		if(root == null){
			return root;
		}
		
		java.util.Stack<TreeNode> stack = new java.util.Stack<TreeNode>();
		stack.push(root);
		
		while(!stack.isEmpty()){
			
			TreeNode current = stack.pop();
			System.out.println("Popping from stack. verifying node with data:  " + current.data);
			if(current.data == key){
				return current;
			}
			
			if(current.right !=null){
				stack.push(current.right);
			}

			if(current.left !=null){
				stack.push(current.left);
			}
			 
		}
		
		return null;
	}
	
	//bug: isProcessed flag was set ONLY after being removed from Queue (removeFirst). however, this was adding duplicates in cases like 
	// 0 -> 1,2,3 and 1 -> 2,3 . When 0 was marked as processed, all its unprocessed neighbors were added (1,2,3). when the next element (1) was removed,
	// all its neighbors (2,3) were added again as they were still unprocessed resulting in duplicate processing of the nodes.
	// same with DFS logic. fix: always mark node as "processed" or "visited" once you touch the node (not when u process it). 
	// actual processing can happen when u dequeue/pop.
	public static GraphNode GraphBFS(MyGraph graph, GraphNode start, Integer key){
		
		if(start == null){
			return start;
		}
		
		LinkedList<GraphNode> processList = new LinkedList<GraphNode>();
		start.isProcessed = true;
		processList.add(start);
		
		while(!processList.isEmpty()){
			
			GraphNode current = processList.removeFirst();
			
			System.out.println("Removing "+ current.data +" from queue and Processing node: " + current);
			if(current.data == key){
				return current;
			}
			
			for(GraphNode neighbor: graph.GetAllNeighbors(current)){
				if(!neighbor.isProcessed){
					neighbor.isProcessed = true;
					System.out.println("Neighbor " + neighbor.data + "is not processed. Adding... " + neighbor);
					processList.add(neighbor);
				}
			}
		}
		
		return null;
	}
	
	
	public static GraphNode GraphDFS(MyGraph graph, GraphNode start, Integer key){

		if(start == null){
			return start;
		}
		
		java.util.Stack<GraphNode> stack = new java.util.Stack<GraphNode>();
		start.isProcessed = true;
		stack.push(start);
		
		while(!stack.isEmpty()){
			
			GraphNode current = stack.pop();
			
			System.out.println("Popping from stack and Processing node: " + current.data);
			if(current.data == key){
				return current;
			}
				
			for(GraphNode neighbor:	graph.GetAllNeighbors(current)){
				if(!neighbor.isProcessed){
					neighbor.isProcessed = true;
					stack.push(neighbor);
				}
			}
		}
		return null;
	}

	private static void ProcessNode(TreeNode node){
		System.out.print(node.data + "..>");
	}

	/*
	public static boolean GraphBidirectionalSearch(MyGraph graph, GraphNode start, GraphNode end){
		
		if(graph == null || start == null || end == null){
			return null;
		}	
		
		HashSet<GraphNode> stList = new HashSet<GraphNode>();
		HashSet<GraphNode> endList = new HashSet<GraphNode>();
		
		start.isProcessed = true;
		end.isProcessed = true;
		
		stList.add(start);
		endList.add(end);
			
		while(!stList.isEmpty() || !endList.isEmpty())	{
			
			if(getIntersection(stList, endList) > 0){
				
			}
			
		}
		
	}
	
	public static int getIntersection(Set<GraphNode> set1, Set<GraphNode> set2) {
    boolean set1IsLarger = set1.size() > set2.size();
    Set<GraphNode> cloneSet = new HashSet<GraphNode>(set1IsLarger ? set2 : set1);
    cloneSet.retainAll(set1IsLarger ? set1 : set2);
    return cloneSet.size();
	}
	*/
	
	// HeapSort assumes that elements are populated from 1 through N. (not 0 to N-1) so Ensure that zeroth index has no data
	//bug: if(lcIndex <= heapLastIndex && rcIndex <= heapLastIndex) - missed the "=" resulting in an one-off error. -_-
	//renamed heapSize to heapLastIndex so that it is much clearer that the last element is ALSO a valid index for data.
	//bug: while(heapLastIndex > 1) { - had an eqaul or greater which is technically not required. (a mild bug) but doesn;t hurt the existing logic
	public static void HeapSort(Integer[] A){
		
		int heapLastIndex = A.length - 1;
		BuildHeap(A, heapLastIndex);
		System.out.println("Debug: After Build Heap..");
		TestDataGenerator.PrintArray(A);
		
		while(heapLastIndex > 1) {
			Swap(A , 1, heapLastIndex);
			heapLastIndex = heapLastIndex - 1;
			MaxHeapify(A, 1, heapLastIndex);		
		}
	}
	
	public static void BuildHeap(Integer[] A, int heapLastIndex){
		
		for( int i = heapLastIndex/2; i >= 1 ; i--){
				MaxHeapify(A, i, heapLastIndex);
		}
	}
	
	public static void MaxHeapify(Integer[] A, int index, int heapLastIndex){
		
		int lcIndex = index * 2;
		int rcIndex = index * 2 + 1;
		if(lcIndex <= heapLastIndex && rcIndex <= heapLastIndex){
			if(A[lcIndex] > A[index] && A[lcIndex] > A[rcIndex]){
				Swap(A, index, lcIndex);
				MaxHeapify(A, lcIndex, heapLastIndex);
			}
			else if (A[rcIndex] > A[index] && A[rcIndex] > A[index]){
				Swap(A, index, rcIndex);
				MaxHeapify(A, rcIndex, heapLastIndex);
			}
		}
		else if(lcIndex <= heapLastIndex){
			
			if(A[lcIndex] > A[index] ){
				Swap(A, index, lcIndex);
				MaxHeapify(A, lcIndex, heapLastIndex);
			}
		}
		else if(rcIndex <= heapLastIndex){
			
			if(A[rcIndex] > A[index] ){
				Swap(A, index, rcIndex);
				MaxHeapify(A, rcIndex, heapLastIndex);
			}
		}
	}
	
	private static void Swap(Integer[] A, int indexa, int indexb){		
		int temp = A[indexa];
		A[indexa] = A[indexb];
		A[indexb] = temp;
	}
	
	public static TreeNode<Integer> Q2BinarySearchTree(Integer[] A)
	{
		if(A == null){
			return null;
		}
		
		TreeNode<Integer> root = BuildBST(A, 0, A.length-1);
		return root;
	}
	
	private static TreeNode<Integer> BuildBST(Integer[] A, int p, int q){
		
		if(p > q){ //indices crossed over. return
			return null;
		}
		
		int m = (p+q)/2;
		
		TreeNode<Integer> current = new TreeNode<Integer>(A[m]);
		current.left = BuildBST(A, p, m-1);
		current.right = BuildBST(A, m+1, q);
		return current;
		
	}
	
	//bug: Forgot to return after the base case,  root = null. caused null ref. -_-
	//fix: return the response immediately
	public static boolean Q4IsBalanced(TreeNode root){
		
		if(root == null)
		{
			return true;
		}
		
		IsBalancedResponse response = CheckIfUnbalanced(root);
		return response.UnbalanceDetected;
	}
	
	private static IsBalancedResponse CheckIfUnbalanced(TreeNode root){
		
		IsBalancedResponse response = new IsBalancedResponse();
		
		if(root == null){
			response.Depth = 0;
			response.UnbalanceDetected = false;
			return response;
		}
		
		IsBalancedResponse left = CheckIfUnbalanced(root.left);
		IsBalancedResponse right = CheckIfUnbalanced(root.right);
		
		if(left.UnbalanceDetected || right.UnbalanceDetected){
			response.UnbalanceDetected = true;
			return response;
		}
		
		int depthDiff = Math.abs(left.Depth - right.Depth);
		if(depthDiff > 1){
			response.UnbalanceDetected = true;
			return response;
		}
		
		//no unbalance detected in children and current level. return depth.
		response.Depth = Math.max(left.Depth, right.Depth) + 1;
		return response;
	}
	
	public static TreeNode<Integer> GetInOrderSuccessor(TreeNode cur){
		
		if(cur == null){
			return null;
		}
		
		if(cur.right != null){
			
			TreeNode ios = cur.right;
			ios = findLeftMostChild(ios);
			return ios;
		}
		
		TreeNode parent = cur.parent;
		
		while(parent != null && parent.right != cur){
			cur = parent;
			parent = parent.parent;
		}
			
		return parent;
	}
	
	
	private static TreeNode<Integer> findLeftMostChild(TreeNode<Integer> node){
		
		if(node == null)
			return null;
		
		while(node.left != null){
			node = node.left;
		}
		
		return node;
	}
	
	
}