public class Node{
	Integer data;
	Node next;
	
	public Node(Integer nodeData)throws Exception{
		if(nodeData == null){
			throw new Exception ("Null value for nodeData is not permissible");
		}
		data = nodeData;
		next = null;
	}
}