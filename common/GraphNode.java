import java.util.*;
import java.math.*;

//bug: had to override equals and hashCode as "GraphNode"s are same if they have same "data" and should not be compared using objectID (created dups in hash table) -_-
public class GraphNode<T>{
	
	T data;
	HashSet<T> neighbors;
	boolean isProcessed;
	
	public GraphNode(T inputData){
		data = inputData;
		neighbors = new HashSet<T>();
	}
	/*
	@Override
    public int hashCode() {
		return this.data.hashCode();
	}
	
	@Override
	public  boolean equals(Object obj){
		
        GraphNode rhs = (GraphNode) obj;
        return this.data.equals(rhs.data);
	} 
	*/
	
}