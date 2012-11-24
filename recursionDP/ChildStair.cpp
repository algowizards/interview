#include<iostream>
#include<unordered_map>
using namespace std;

int FindNumberOfWaysRecursiveHelper(int n, unordered_map<int,int> cache){
	
	unordered_map<int,int>::const_iterator iterator = cache.find(n);
	if(iterator != cache.end())
	{
		return cache[n];
	}

	int numberOfWays;
	if(n > 3){
		numberOfWays = FindNumberOfWaysRecursiveHelper(n-1, cache) + FindNumberOfWaysRecursiveHelper(n-2, cache) + FindNumberOfWaysRecursiveHelper(n-3, cache);
	}
	else if(n == 3)
		numberOfWays = 4;
	else if(n == 2)
		numberOfWays = 2;
	else if(n == 1)
		numberOfWays = 1;
	else 
		numberOfWays = 0;	
			
	cache[n] = numberOfWays;
	cout << "Debug: Number of ways for n = " << n <<" is " << cache[n]<< endl;
	return numberOfWays;

}

int FindNumberOfWays(int n){
	unordered_map<int,int> cache;
	return FindNumberOfWaysRecursiveHelper(n, cache);
}


int main(){
		
	cout << "Number of ways "<< FindNumberOfWays(14) << endl;		
	cout << "Number of ways "<<  FindNumberOfWays(5)<< endl;		
	cout << "Number of ways "<<  FindNumberOfWays(6)<< endl;
	cout << "Number of ways "<< FindNumberOfWays(1)<< endl;
}
