#include<iostream>
#include "Node.cpp"
using namespace std;

public class LinkedList{
	
	public:
	
	void AddToHead(Node** head, int newData){
		if(head == NULL) {
			return NULL;
		}
		
		Node* newNode = new Node();
		if(newNode == NULL){
			return NULL;
		}
		newNode-> data = newData;

		newNode->next = *head;	//make the new node point to the current head	
		*head = newNode; //move the head to point the new node (now it becomes the new head)
	}

	bool AddToTail(Node** head, int newData){
		
		Node* newNode = new Node();
		if(newNode == NULL){
			return false;
		}
		//initialize the node data and next pointer.
		newNode->data = newData;
		newNode ->next = null;

		//special case. empty list
		if(*head == NULL){
			*head = newNode;
			return true;
		}
			
		Node cur = *head;
		while(cur->next !=null){
			cur = cur-> next;
		}
		
		cur.next = newNode;
		return true;
	}
}
