public class DLLNode<T extends Comparable<?>>{
	public T data;
	public DLLNode<T> left;
	public DLLNode<T> right;

	public DLLNode(T d){
		data = d;
	}	
}