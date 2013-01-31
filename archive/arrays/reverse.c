#include<stdio.h>
//#include<conio.h>
#include<string.h>

void reverse(char * source){
	int i = 0, j, length;
	if(source == NULL)
		return; //null check
	length = strlen(source);
	if(length == 0 || length == 1){
		return; //nothing to reverse
	}
	//printf(" \nLength is %d", length);
	for(i =0, j=length-1; i< length/2; i++,j--){
		
		char temp = source[i];
		source[i] = source[j];
		source[j]= temp; 
	}	

}
int main()
{
	char test[10][50];
	int i;
	strcpy(test[0],  "hello, world");
	strcpy(test[1] , "abcde");
	strcpy(test[2] , "abcdef");
	strcpy(test[3] , "");
	strcpy(test[4] , "a");
	strcpy(test[5] , "ab");
	test[6][0] = '\0';
	
	for(i=0; i< 7;i++)
	{
		printf("\nreversing.... %s", test[i]);
		reverse(test[i]);
		printf("\n %s", test[i]);
	}

}


