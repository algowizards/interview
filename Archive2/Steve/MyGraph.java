import java.util.*;

public class MyGraph{
	int GraphNode_CNT = 1000;
	LinkedHashMap<GraphNode, ArrayList<Edge>> adjList = new LinkedHashMap<GraphNode, ArrayList<Edge>>(GraphNode_CNT);
	
	class Edge{
		GraphNode GraphNode;
		int weight = 1;
		Edge(GraphNode n){
			GraphNode = n;
		}
		public boolean equals(Object b){
			return GraphNode.equals(((Edge) b).GraphNode);
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
		GraphNode start;
		GraphNode end;
		EdgeSet(GraphNode s, GraphNode e){
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
				int randGraphNode =  r.nextInt(n);
				ea[counter++] = new EdgeSet(new GraphNode(i), new GraphNode(randGraphNode));
				if(!digraph && randGraphNode!=i){
					ea[counter++] = new EdgeSet( new GraphNode(randGraphNode), new GraphNode(i));
				}
			}
		}
		return ea;
	
	}
	
	public void DumpGraph(){
		System.out.println("-----------Dumping Graph-------------- of size " + adjList.size());
		for ( Map.Entry<GraphNode, ArrayList<Edge>> entry : adjList.entrySet()){
		GraphNode GraphNode = entry.getKey();
		System.out.print("\n GraphNode # " + GraphNode.id + ": ");
			for(Edge e: entry.getValue()){
				System.out.print(" " + e.GraphNode.id + "-> ");
			}
		}
	}
	
	public static void main(String args[]){
		MyGraph mg = new MyGraph();
		mg.BuildGraph(mg.GenerateData( 4, 2, false));
		mg.DumpGraph();
	}
	
}