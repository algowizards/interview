public class Chap4TreesAndGraphsTest{

	public static void main(String args[]){
		//TestInOrderTraversal();
		//TestBFS();
		//TestDFS();
		//TestDFSStackStack();
		//TestGraphBFS();
		//TestGraphDFS();
		//TestHeapSort();
		//TestBinarySearchTree();
		TestIsBalanced();
	}
	
	public static void TestInOrderTraversal(){
		TreeNode<Integer> root = TreeHelper.BuildRandomTree(10, 10, false, true, false);
		BTreePrinter.printNode(root);
		System.out.println("In order traversal:");
		Chap4TreesAndGraphs.InOrderTraversal(root);
		System.out.println("-------------------------------------------");
		
		System.out.println("Pre-order traversal:");
		Chap4TreesAndGraphs.PreOrderTraversal(root);
		System.out.println("-------------------------------------------");
		
		System.out.println("Post order traversal:");
		Chap4TreesAndGraphs.PostOrderTraversal(root);
		System.out.println("-------------------------------------------");

	}
	
	public static void TestBFS(){
		TreeNode<Integer> root = TreeHelper.BuildRandomTree(10, 10, false, true, false);
		BTreePrinter.printNode(root);
		System.out.println("BFS");
		int data = 9;
		System.out.println("Searching for data = " + data  + "Yielded : " + Chap4TreesAndGraphs.BFS(root, data));
		System.out.println("-------------------------------------------");
		
		data = 0;
		System.out.println("Searching for data = " + data  + "Yielded : " + Chap4TreesAndGraphs.BFS(root, data));
		System.out.println("-------------------------------------------");
		
		data = 2;
		System.out.println("Searching for data = " + data  + "Yielded : " + Chap4TreesAndGraphs.BFS(root, data));
		System.out.println("-------------------------------------------");
		
		data = 99;
		System.out.println("Searching for data = " + data  + "Yielded : " + Chap4TreesAndGraphs.BFS(root, data));
		System.out.println("-------------------------------------------");
		
		root = TreeHelper.BuildRandomTree(10, 5, false, true, false);
		BTreePrinter.printNode(root);
		
		data = 3;
		System.out.println("Searching for data = " + data  + "Yielded : " + Chap4TreesAndGraphs.BFS(root, data));
		System.out.println("-------------------------------------------");
	}
	
	public static void TestDFS(){
		TreeNode<Integer> root = TreeHelper.BuildRandomTree(10, 10, false, true, false);
		BTreePrinter.printNode(root);
		System.out.println("DFS");
		
		int data = 9;
		System.out.println("Searching for data = " + data  + "Yielded : " + Chap4TreesAndGraphs.DFS(root, data));
		System.out.println("-------------------------------------------");
		
		data = 0;
		System.out.println("Searching for data = " + data  + "Yielded : " + Chap4TreesAndGraphs.DFS(root, data));
		System.out.println("-------------------------------------------");
		
		data = 2;
		System.out.println("Searching for data = " + data  + "Yielded : " + Chap4TreesAndGraphs.DFS(root, data));
		System.out.println("-------------------------------------------");
		
		data = 99;
		System.out.println("Searching for data = " + data  + "Yielded : " + Chap4TreesAndGraphs.DFS(root, data));
		System.out.println("-------------------------------------------");
		
		root = TreeHelper.BuildRandomTree(10, 5, false, true, false);
		BTreePrinter.printNode(root);
		
		data = 3;
		System.out.println("Searching for data = " + data  + "Yielded : " + Chap4TreesAndGraphs.DFS(root, data));
		System.out.println("-------------------------------------------");
	}
	
	public static void TestDFSStackStack(){
		TreeNode<Integer> root = TreeHelper.BuildRandomTree(10, 10, false, true, false);
		BTreePrinter.printNode(root);
		System.out.println("DFSStack");
		
		int data = 9;
		System.out.println("Searching for data = " + data  + "Yielded : " + Chap4TreesAndGraphs.DFSStack(root, data));
		System.out.println("-------------------------------------------");
		
		data = 0;
		System.out.println("Searching for data = " + data  + "Yielded : " + Chap4TreesAndGraphs.DFSStack(root, data));
		System.out.println("-------------------------------------------");
		
		data = 2;
		System.out.println("Searching for data = " + data  + "Yielded : " + Chap4TreesAndGraphs.DFSStack(root, data));
		System.out.println("-------------------------------------------");
		
		data = 99;
		System.out.println("Searching for data = " + data  + "Yielded : " + Chap4TreesAndGraphs.DFSStack(root, data));
		System.out.println("-------------------------------------------");
		
		root = TreeHelper.BuildRandomTree(10, 5, false, true, false);
		BTreePrinter.printNode(root);
		
		data = 3;
		System.out.println("Searching for data = " + data  + "Yielded : " + Chap4TreesAndGraphs.DFSStack(root, data));
		System.out.println("-------------------------------------------");
	}
	
	public static void TestGraphBFS(){
		
		MyGraph mg = GraphHelper.GenerateRandomGraph(5, 0.5, false);
		mg.PrintGraph();
		GraphNode start = mg.GetStartNode();
		System.out.println("Random start node: " + start.data + "\n");
		int key = 3;
		System.out.println("Searching for key = " + key  + "Yielded : " + Chap4TreesAndGraphs.GraphBFS( mg,  start,  key));
		System.out.println("-------------------------------------------");

		mg = GraphHelper.GenerateRandomGraph(5, 0.5, false);
		mg.PrintGraph();
		start = mg.GetStartNode();
		System.out.println("Random start node: " + start.data + "\n");
		key = 9;
		System.out.println("Searching for key = " + key  + "Yielded : " + Chap4TreesAndGraphs.GraphBFS( mg,  start,  key));
		System.out.println("-------------------------------------------");

		mg = GraphHelper.GenerateRandomGraph(5, 0.5, false);
		mg.PrintGraph();
		start = mg.GetStartNode();
		System.out.println("Random start node: " + start.data + "\n");
		key = (Integer) start.data;
		System.out.println("Searching for key = " + key  + "Yielded : " + Chap4TreesAndGraphs.GraphBFS( mg,  start,  key));
		System.out.println("-------------------------------------------");
}
	
	public static void TestGraphDFS(){
		
		MyGraph mg = GraphHelper.GenerateRandomGraph(5, 0.5, false);
		mg.PrintGraph();
		GraphNode start = mg.GetStartNode();
		System.out.println("Random start node: " + start.data + "\n");
		int key = 3;
		System.out.println("Searching for key = " + key  + "Yielded : " + Chap4TreesAndGraphs.GraphDFS( mg,  start,  key));
		System.out.println("-------------------------------------------");

		mg = GraphHelper.GenerateRandomGraph(5, 0.5, false);
		mg.PrintGraph();
		start = mg.GetStartNode();
		System.out.println("Random start node: " + start.data + "\n");
		key = 9;
		System.out.println("Searching for key = " + key  + "Yielded : " + Chap4TreesAndGraphs.GraphDFS( mg,  start,  key));
		System.out.println("-------------------------------------------");

		mg = GraphHelper.GenerateRandomGraph(5, 0.5, false);
		mg.PrintGraph();
		start = mg.GetStartNode();
		System.out.println("Random start node: " + start.data + "\n");
		key = (Integer) start.data;
		System.out.println("Searching for key = " + key  + "Yielded : " + Chap4TreesAndGraphs.GraphDFS( mg,  start,  key));
		System.out.println("-------------------------------------------");
	}

	public static void TestHeapSort(){
		
		Integer[] testdata = TestDataGenerator.GetArray(10, true, 20);
		testdata[0] = -1;
		System.out.println("Before sorting the array.....");
		TestDataGenerator.PrintArray(testdata);
		
		Chap4TreesAndGraphs.HeapSort(testdata);
		System.out.println("AFTER sorting the array.....");
		TestDataGenerator.PrintArray(testdata);
	}

	public static void TestBinarySearchTree()
	{
		
		Integer[] testdata = TestDataGenerator.GetArray(15, false, 20);
		System.out.println("Sorted array.....");
		TestDataGenerator.PrintArray(testdata);
		
		TreeNode<Integer> root = Chap4TreesAndGraphs.Q2BinarySearchTree(testdata);
		BTreePrinter.printNode(root);
		
	}
		
		
	public static void TestIsBalanced(){
		
		TreeNode<Integer> root = TreeHelper.BuildRandomTree(20, 20, false, false, true);
		BTreePrinter.printNode(root);
		System.out.println("Is tree unbalanced? " + Chap4TreesAndGraphs.Q4IsBalanced(root));
		System.out.println("\n");
		
		root = TreeHelper.BuildRandomTree(5, 20, true, false, true);
		BTreePrinter.printNode(root);
		System.out.println("Is tree unbalanced? " + Chap4TreesAndGraphs.Q4IsBalanced(root));
		System.out.println("\n");
		
		root = TreeHelper.BuildRandomTree(10, 20, true, false, true);
		BTreePrinter.printNode(root);
		System.out.println("Is tree unbalanced? " + Chap4TreesAndGraphs.Q4IsBalanced(root));
		System.out.println("\n");


	}	
}