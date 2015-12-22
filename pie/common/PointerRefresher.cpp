#include<iostream>
#include "Node.cpp"
int* TestFunc(int** z);

int main(){
	
	PointerRefresh();
}

int void PointerRefresh(){
	Node *newNode = new Node();
	newNode->data = 100;
	cout << newNode ->data << endl;
	delete newNode;		
	
	int x = 99;
	int* y = &x;
	int **z = &y;
	int* yPrime = TestFunc(&y);
	
	cout << "value through Yprime " << *yPrime << endl;
	cout << "value through Z  " << **z <<  endl;
	
	
	
	cout << "value through Yprime (addr)" << yPrime << endl;
	cout << "value through Z  (addr)" << *z <<  endl;

}
int* TestFunc(int** z){
	*z = new int(101);
}

