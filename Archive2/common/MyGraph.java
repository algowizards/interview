import java.util.*;
import java.math.*;

//bug: Adjacency list should have been <Node, HashSet> but i started off with <Node, LinkedList> and figured that linked list caused dups -_-
public class MyGraph<T>{

	LinkedHashMap<GraphNode<T>, HashSet<GraphNode<T>>> adjList;
	boolean isDirected;
	public MyGraph(){
		this(false);
	}
	
	public MyGraph(boolean isDir){
		adjList = new LinkedHashMap<GraphNode<T>, HashSet<GraphNode<T>>>();
		isDirected = isDir;
	}

	public void addNode(GraphNode<T> node) throws Exception{
		if(adjList.containsKey(node)){
			throw new Exception("Already added the node with id: "+  node.uuid + " and data: " + node.data);
		}
		adjList.put(node, new HashSet<GraphNode<T>>());
	}
	
	public void addEdge(GraphNode<T> start, GraphNode<T> end) throws Exception{
		
		if(!adjList.containsKey(start) ){
			throw new Exception ("START node does not exist! StarT ID: " + start.uuid + " Data: " + start.data);
		}
		if(!adjList.containsKey(end)){
			throw new Exception ("End node does not exist! End ID: " + end.uuid + " End data: " + end.data);
		}
		
		HashSet<GraphNode<T>> startNeighbors = adjList.get(start);
		startNeighbors.add(end);
		
		if(!isDirected){
			HashSet<GraphNode<T>> endNeighbors = adjList.get(end);
			endNeighbors.add(start);
		}
	}
	
	public HashSet<GraphNode<T>> GetAllNeighbors(GraphNode<T> node){
		return adjList.get(node);
	}

	public void PrintGraph(){
		if(adjList == null){
			System.out.println("Graph empty");
		}
		
		for (Map.Entry<GraphNode<T>, HashSet<GraphNode<T>>> entry : adjList.entrySet()) {
			GraphNode<T> key = entry.getKey();
			HashSet<GraphNode<T>> value = entry.getValue();
			System.out.print("Key: " +"(" +  key.data + ") " + key.uuid + "   ");
		for (GraphNode<T> neighbor : value) {
				System.out.print("--> " + neighbor.data + " ");
			}
			System.out.println("");
		}
	}

	public GraphNode<T> GetRandomNode(){
		if(adjList == null || adjList.isEmpty()){
			return null;
		}
		ArrayList<GraphNode<T>> list = new ArrayList<GraphNode<T>> ();
		for (Map.Entry<GraphNode<T>, HashSet<GraphNode<T>>> entry : adjList.entrySet()) {
			list.add(entry.getKey());
		}
		
		Random r = new Random();
		int index = Math.abs(r.nextInt()%list.size());
		return list.get(index);
	}
	
	public GraphNode<T> GetStartNode(){
		
		if(adjList == null || adjList.isEmpty()){
			return null;
		}
		
		for (Map.Entry<GraphNode<T>, HashSet<GraphNode<T>>> entry : adjList.entrySet()) {
			return (entry.getKey());
		}
		return null;
	}
	
	public GraphNode<T> GetKeyNode(T key){
		
		if(adjList == null || adjList.isEmpty()){
			return null;
		}
		
		for (Map.Entry<GraphNode<T>, HashSet<GraphNode<T>>> entry : adjList.entrySet()) {
			GraphNode<T> keyNode = entry.getKey();
			if(keyNode.data == key)
			return (keyNode);
		}
		return null;
	}
	
	public HashSet<GraphNode<T>> GetAllNodes(){
		HashSet<GraphNode<T>> keys = new HashSet<GraphNode<T>>();
		
		for (Map.Entry<GraphNode<T>, HashSet<GraphNode<T>>> entry : adjList.entrySet()) {
			GraphNode<T> keyNode = entry.getKey();
			keys.add(keyNode);
		}
		return keys;
	}
	
	public boolean AreNeighbors(GraphNode<T> n1, GraphNode<T> n2){
	
		if(n1 == null || n2 == null){
			return false;
		}
		
		if(adjContains(n1, n2)){
			return true;
		}
		if(!isDirected){
			return adjContains(n2, n1);
		}
		
		return false;
	}
	
	private boolean adjContains(GraphNode<T> n1, GraphNode<T> n2){
		
		HashSet<GraphNode<T>> set = adjList.get(n1);
		return (set != null  && set.contains(n2)) ;
	}
}