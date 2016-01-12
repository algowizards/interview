import java.util.*;
import java.math.*;

//bug: Adjacency list should have been <Node, HashSet> but i started off with <Node, LinkedList> and figured that linked list caused dups -_-
public class MyGraph{

	LinkedHashMap<GraphNode, HashSet<GraphNode>> adjList;
	
	public MyGraph(){
		adjList = new LinkedHashMap<GraphNode, HashSet<GraphNode>>();
	}
	
	public boolean AddGraphNode(GraphNode node, HashSet<GraphNode> neighbors){
		if(node == null){
			return false;
		}
		
		HashSet<GraphNode> existingNeighbors = adjList.get(node);
		
		if(existingNeighbors == null){
			adjList.put(node, neighbors);
		}
		else{
			existingNeighbors.addAll(neighbors);
		}
		
		for (GraphNode neighbor : neighbors) {
			if( adjList.get(neighbor) == null ){
				adjList.put(neighbor, new HashSet<GraphNode>());
			}
			adjList.get(neighbor).add(node);
		}
		return true;
	}
	
	public HashSet<GraphNode> GetAllNeighbors(GraphNode node){
		return adjList.get(node);
	}

	public void PrintGraph(){
		if(adjList == null){
			System.out.println("Graph empty");
		}
		
		for (Map.Entry<GraphNode, HashSet<GraphNode>> entry : adjList.entrySet()) {
			GraphNode key = entry.getKey();
			HashSet<GraphNode> value = entry.getValue();
			System.out.print("Key: " + key.data);
		for (GraphNode neighbor : value) {
				System.out.print("--> " + neighbor.data + " ");
			}
			System.out.println("");
		}
	}

	public GraphNode GetStartNode(){
		
		if(adjList == null || adjList.isEmpty()){
			return null;
		}
		
		for (Map.Entry<GraphNode, HashSet<GraphNode>> entry : adjList.entrySet()) {
			return (entry.getKey());
		}
		return null;
	}
	
	public GraphNode GetKeyNode(int key){
		
		if(adjList == null || adjList.isEmpty()){
			return null;
		}
		
		for (Map.Entry<GraphNode, HashSet<GraphNode>> entry : adjList.entrySet()) {
			GraphNode keyNode = entry.getKey();
			if((int) keyNode.data == key)
			return (keyNode);
		}
		return null;
	}
}