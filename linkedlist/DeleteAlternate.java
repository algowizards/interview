import java.io.*;
class Node{
	int data;
	Node next;
}
public class DeleteAlternate{
	static int MAXLISTS = 5;
	public static void main(String args[]){
		Node listHead[] = new Node[MAXLISTS];
		for (int i = 0; i < ; i++){
			Node listHead[i] = createLinkedList(i);
			System.Out.println("Before deleting alt elements");
			printList(listHead[i]);
			deleteAlternate(listHead[i]);
			System.Out.println("After deleting alt elements");
			printList(listHead[i]);
		}
		
	}
	
	public static void deleteAlternate(Node head){
	
		if(head == null || head.next == null){
			return; //nothing to delete as there are zero/one elements
		}
		Node iterator = head;
		while(iterator != null && iterator.next != null){
			//Node temp = iterator.next;  
			iterator = iterator.next.next;
			//delete(temp); not required in java. it is GC'ed automatically.
		}
	}
}