public class Node<T>{
	T data;
	Node<T> next;
	
	public Node(T nodeData){
		data = nodeData;
		next = null;
	}
}