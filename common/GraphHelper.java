import java.util.*;
import java.math.*;

public class GraphHelper{

	static int MAX = 1000;
	// bug: need paranthesis for values being typecasted. was missing them for density * MAX in " (int) (densityProb * MAX) " that resulted in a false matrix. -_-
	public static MyGraph<Integer> GenerateRandomGraph(int size, double densityProb, boolean hasSelfLoop) throws Exception{
		
		//densityProb gives the probability of connectivity (0 being disconnected , 1 being fully connected)
		if(densityProb > 1 || densityProb < 0 || size <=0){
			return null;
		}
		
		MyGraph<Integer> graph = new MyGraph<Integer>();
		//fill an array of booleans based on probability (greater the probability, greater is the number of "true" values)
		boolean[] density = new boolean[MAX];
		int count = (int) (densityProb * MAX);
		for(int i = 0; i < count; i++){
			density[i] = true;
		}
		
		ArrayList<GraphNode<Integer>> nodesList = new ArrayList<GraphNode<Integer>>();
		
		for(int i = 0 ; i < size; i++){
			GraphNode<Integer> node = new GraphNode<Integer>(i);
			graph.addNode(node);
			nodesList.add(node);
		}
		
		
		for(int i = 0 ; i < size; i++){
			GraphNode<Integer> node = nodesList.get(i);
						
			// generate random links in graph
			for(int j = 0; j < size; j++){
				
				// if self loop is not allowed, skip
				if(i==j && !hasSelfLoop){
					continue;
				}
				
				Random r = new Random();
				int index = Math.abs(r.nextInt()%MAX);
				//System.out.println("Debug: Density: " + density[index] + " Since the index was: " + index);
				if(density[index]){
					GraphNode<Integer> neighbor = nodesList.get(j);
					//System.out.println("Debug: neighbor key node from local cache!!" + neighbor.data);
					graph.addEdge(node, neighbor);
				}
			}
		}
		
		return graph;
	}

	public static MyGraph<Integer> CreateTopSortGraph()throws Exception{
		
		MyGraph<Integer>  graph = new MyGraph<Integer>(true);
		ArrayList<GraphNode<Integer>> list =  new ArrayList<GraphNode<Integer>> ();
		
		for(int i = 0; i <7; i++){
			GraphNode<Integer> node = new GraphNode<Integer>(i);
			list.add(node);
			graph.addNode(node);
		}
		
		graph.addEdge(list.get(1), list.get(2));
		
		graph.addEdge(list.get(2), list.get(3));
		graph.addEdge(list.get(2), list.get(4));
		
		graph.addEdge(list.get(3), list.get(4));
		graph.addEdge(list.get(3), list.get(5));
		graph.addEdge(list.get(3), list.get(6));
		
		graph.addEdge(list.get(4), list.get(6));
		
		return graph;		
	}		
	
	public static MyGraph<Integer> CreateLoopDetectionGraph1() throws Exception{
		
		MyGraph<Integer>  graph = new MyGraph<Integer>(true);
		ArrayList<GraphNode<Integer>> list =  new ArrayList<GraphNode<Integer>> ();
		
		for(int i = 0; i <7; i++){
			GraphNode<Integer> node = new GraphNode<Integer>(i);
			list.add(node);
			graph.addNode(node);
		}
		
		graph.addEdge(list.get(0), list.get(1));
		graph.addEdge(list.get(0), list.get(4));
		
		graph.addEdge(list.get(1), list.get(3));
		
		graph.addEdge(list.get(3), list.get(0));
		graph.addEdge(list.get(3), list.get(1));
		graph.addEdge(list.get(3), list.get(4));
		
		graph.addEdge(list.get(4), list.get(0));
		graph.addEdge(list.get(4), list.get(3));
		
		return graph;
	}
	
	public static MyGraph<Integer> CreatePotentialMayorGraph() throws Exception{
		
		MyGraph<Integer>  graph = new MyGraph<Integer>(true);
		ArrayList<GraphNode<Integer>> list =  new ArrayList<GraphNode<Integer>> ();
		
		for(int i = 0; i < 4; i++){
			GraphNode<Integer> node = new GraphNode<Integer>(i);
			list.add(node);
			graph.addNode(node);
		}
		
		graph.addEdge(list.get(0), list.get(1));
		graph.addEdge(list.get(0), list.get(2));
		
		graph.addEdge(list.get(1), list.get(2));
		
		graph.addEdge(list.get(3), list.get(0));
		graph.addEdge(list.get(3), list.get(1));
		graph.addEdge(list.get(3), list.get(2));
		
		return graph;
	
	}
	
	public static String ToString(HashSet<GraphNode<Integer>> nodes){
		StringBuffer result =  new StringBuffer();
		
		if(nodes == null){
			return "<Empty Set>";
		}
		
		for(GraphNode<Integer> node : nodes){
			result.append(", ");
			result.append(node.data);
		}
		
		return result.toString();
	}
}
