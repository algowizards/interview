import java.util.*;

public class MyGraph{
	int NODE_CNT = 1000;
	LinkedHashMap<Node, ArrayList<Edge>> adjList = new LinkedHashMap<Node, ArrayList<Edge>>(NODE_CNT);
	
	class Edge{
		Node node;
		int weight = 1;
		Edge(Node n){
			node = n;
		}
		public boolean equals(Object b){
			return node.equals(((Edge) b).node);
		}
	}
	
	class Node{
		int id;
		Node(int idParam){
			id = idParam;
		}
		
		public boolean equals(Object b){
			return id == ((Node) b).id;
		}
		public int hashCode(){
			return id;
		}
	}
	
	public void AddEdge(EdgeSet es){
	
		if(es == null){
			return;
		}
		
		Edge e = new Edge(es.end); 
		if(adjList.get(es.start) == null){
			adjList.put(es.start, new ArrayList<Edge>());
		}
		if(!adjList.get(es.start).contains(e)){
			adjList.get(es.start).add(e);
		}
	}
	
	class EdgeSet{
		Node start;
		Node end;
		EdgeSet(Node s, Node e){
			start = s;
			end = e;
		}
	}
	
	public void BuildGraph( EdgeSet[] input){
		
		if(input == null){
			return;
		}
		for(EdgeSet e:input){
			AddEdge(e);
		}
	
	}
	
	public EdgeSet[] GenerateData(int n, int c, boolean digraph){
		System.out.println("Generating for n = " + n  + "c = " + c );
		if(c >= n){
			return null;
		}
		int mulF = digraph? 1: 2;
		EdgeSet[] ea = new  EdgeSet[n * c * mulF];
		Random r = new Random();
		int counter = 0;
		for (int i = 0; i < n ; i++){
			for(int j = 0; j < c; j++){
				int randNode =  r.nextInt(n);
				ea[counter++] = new EdgeSet(new Node(i), new Node(randNode));
				if(!digraph && randNode!=i){
					ea[counter++] = new EdgeSet( new Node(randNode), new Node(i));
				}
			}
		}
		return ea;
	
	}
	
	public void DumpGraph(){
		System.out.println("-----------Dumping Graph-------------- of size " + adjList.size());
		for ( Map.Entry<Node, ArrayList<Edge>> entry : adjList.entrySet()){
		Node node = entry.getKey();
		System.out.print("\n Node # " + node.id + ": ");
			for(Edge e: entry.getValue()){
				System.out.print(" " + e.node.id + "-> ");
			}
		}
	}
	
	public static void main(String args[]){
		MyGraph mg = new MyGraph();
		mg.BuildGraph(mg.GenerateData( 4, 2, false));
		mg.DumpGraph();
	}
	
}