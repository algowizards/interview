import java.util.*;
import java.math.*;

public class GraphHelper{

	static int MAX = 1000;
	// bug: need paranthesis for values being typecasted. was missing them for density * MAX in " (int) (densityProb * MAX) " that resulted in a false matrix. -_-
	public static MyGraph GenerateRandomGraph(int size, double densityProb, boolean hasSelfLoop){
		
		//densityProb gives the probability of connectivity (0 being disconnected , 1 being fully connected)
		if(densityProb > 1 || densityProb < 0 || size <=0){
			return null;
		}
		
		MyGraph graph = new MyGraph();
		//fill an array of booleans based on probability (greater the probability, greater is the number of "true" values)
		boolean[] density = new boolean[MAX];
		int count = (int) (densityProb * MAX);
		for(int i = 0; i < count; i++){
			density[i] = true;
		}
		
		LinkedHashMap<Integer, GraphNode> nodesMap = new LinkedHashMap <Integer, GraphNode>();
		
		for(int i = 0 ; i < size; i++){
			GraphNode<Integer> node = new GraphNode<Integer>(i);
			nodesMap.put(i, node);
		}
		
		
		for(int i = 0 ; i < size; i++){
			GraphNode node = nodesMap.get(i);
			HashSet<GraphNode> neighbors = new HashSet<GraphNode>();
			
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
					GraphNode neighbor = nodesMap.get(j);
					System.out.println("Debug: neighbor key node from local cache!!" + neighbor.data);
					neighbors.add(neighbor);
				}
			}
			// now that we have a node and it's neighbors, add it to the graph
			//System.out.println("Debug: Node: " + node.data + " has new neighbors. adding them all. total neighbors: " + neighbors.size());
			graph.AddGraphNode(node, neighbors);
		}
		return graph;
	}
}
