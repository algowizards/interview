#include<iostream>
#include "LinkedList.cpp"

int* TestFunc(int** z);

int main(){
	
	LinkedList list = new LinkedList();
	
	Node n = new Node();
	n.data = 100;
	n.next = NULL;
	list.AddToHead(&n,100);
	
}
