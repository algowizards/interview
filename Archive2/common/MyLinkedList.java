public class MyLinkedList<T>{

	Node<T> head;

	public Node<T> GetHead()
	{
		return head;
	}
	
	public Node<T> addToTail(T data){
		Node<T> newNode = new Node<T>(data);
		if(head == null){
			head = newNode;
			return head;
		}
		
		Node<T> cur = head;
		while(cur.next !=null){
			cur = cur.next;
		}
		cur.next = newNode;
		return newNode;
	}

	public boolean editNode (int index, T newData){
		
		if(newData == null){
			return false;
		}
		
		Node<T> cur = head;
		int count = 0;
		while(cur != null){
			if(count == index){
				cur.data = newData;
				return true;
			}
			count++;
			cur = cur.next;
		}
		return false;	
	}
	
	public boolean deleteData(T delData){
		
		//empty list
		if(head == null){
			return false;
		}
		//element is the first node
		if(head.data == delData){
			head = head.next;
			return true;
		}
		//general case
		Node<T> cur = head;
		while(cur!=null && cur.next != null){
			if(cur.next.data == delData){
				cur.next = cur.next.next;
				return true;
			}
			cur = cur.next;
		}
		return false;
	}
	
	public boolean deleteNode(Node delNode){
		
		//empty list
		if(head == null){
			return false;
		}
		//element is the first node
		if(head == delNode){
			head = head.next;
			return true;
		}
		//general case
		Node<T> cur = head;
		while(cur!=null && cur.next != null){
			if(cur.next == delNode){
				cur.next = cur.next.next;
				return true;
			}
			cur = cur.next;
		}
		return false;
	}
	
	public static MyLinkedList<Integer> GenerateTestLinkedListOfIntegers(int count, boolean isValuesSequential){
		
		if (count <= 0) {
			return null;
		}
		
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		if(isValuesSequential){
			for(int i = 0; i < count; i++){
				list.addToTail(i);
			}
		}
		else{
			return null;
		}
		return list;
	}
	
	public void Print()
	{
		Node<T> cur = head;
		System.out.println("");
		while( cur != null ){
			System.out.print(cur.data + "-->");
			cur = cur.next;
		}
		System.out.println("null");
		
	}


}