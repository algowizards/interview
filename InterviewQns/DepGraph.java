import java.util.*;

public class DepGraph{
	private LinkedHashMap<Software, Neighbor>_graph;
	public DepGraph(){
		_graph = new LinkedHashMap<Software, Neighbor>();
	}
	public void AddNode(Software s){
		if(!_graph.containsKey(s)){
			_graph.put(s, new Neighbor());
		}
	}
	public void AddDependsOnEdge(Software s, Software d){
		if(!_graph.containsKey(s)){
			System.out.println("Software " + s.Name +" is not found in the graph! Can't add edge!");
			return;
		}
		if(!_graph.containsKey(d)){
			System.out.println("Software " + d.Name +" is not found in the graph! Can't add edge!");
			return;
		}
		_graph.get(s).AddtoDependsOn(d);
	}
	
	public void AddNeededForEdge(Software s, Software d){
		if(!_graph.containsKey(s)){
			System.out.println("Software " + s.Name +" is not found in the graph! Can't add edge!");
			return;
		}
		if(!_graph.containsKey(d)){
			System.out.println("Software " + d.Name +" is not found in the graph! Can't add edge!");
			return;
		}
		_graph.get(s).AddtoNeededFor(d);
	}
	
	public boolean ContainsNode(Software s){
		return _graph.containsKey(s);
	}
	
	
	public ArrayList<Software> GetDependencies(Software s){
		if (s == null || !_graph.containsKey(s)){
			return null;
		}
		return _graph.get(s).GetDependencies();
	}
	
	public ArrayList<Software> GetNeededFors(Software s){
		if (s == null || !_graph.containsKey(s)){
			return null;
		}
		return _graph.get(s).GetNeededFors();
	}
	
	
	
}