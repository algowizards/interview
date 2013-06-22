
public class GraphNode{
		int id;
		GraphNode(int idParam){
			id = idParam;
		}
		
		public boolean equals(Object b){
			return id == ((GraphNode) b).id;
		}
		public int hashCode(){
			return id;
		}
	}