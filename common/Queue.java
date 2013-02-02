

public class Queue{

	private Node _head = null;
	private Node _tail = null;
	
	public void Enqueue(Integer data) throws Exception{
	
		Node newNode = new Node(data);
		if(_head == null){ //empty Q
			_head = newNode;
			_tail = newNode;
			return;
		}
		_tail.next = newNode;
		_tail = newNode;
	}
	
	public Integer Dequeue()throws Exception{
	
		if(_head == null){
			throw new Exception ("Empty Q");
		}
		Node retVal = _head;
		_head = _head.next;
		if(_head == null)
		{
		_tail = null;
		}
		return retVal.data;
	}
	
	public static void main(String args[])throws Exception{
		Queue q = new Queue();
		q.Enqueue(new Integer(1));
		q.Enqueue(new Integer(2));
		
		System.out.println(q.Dequeue());
		System.out.println(q.Dequeue());
		q.Enqueue(new Integer(3));
		System.out.println(q.Dequeue());
		//this will throw exception
		System.out.println(q.Dequeue());

	}
}