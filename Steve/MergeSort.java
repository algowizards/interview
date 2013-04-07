import java.util.*;
public class MergeSort{
	public static void MergeSort(Integer[] input) throws Exception{
		if(input == null || input.length == 0 || input.length == 1){
			return;
		}
		MergeSortRec(input, 0, input.length -1);
	}
	public static void MergeSortRec(Integer[] input, int p, int r)throws Exception{
		
		if(p < r){
			int q = p +  (r - p) /2;
			MergeSortRec(input, p, q);
			MergeSortRec(input, q+1, r);
			//System.out.println("Pivot " + q + "P =" + p + "R = " + r);
			//TestDataGenerator.PrintArray(input);
			Merge(input, p, q, r ); 
		}
	}
	
	public static void Merge(Integer[] input, int p, int q, int r)throws Exception{
		
		Integer[] a1 = new Integer[ q - p + 1 ];
		Integer[] a2 = new Integer[ r - q ];
		int i, j;
		//copy elements
		for(i = 0; i < a1.length ; i++){
			a1[i] = input[ p + i ];
		}
		
		for (j = 0 ; j < a2.length; j++){
			a2[j] = input[q + 1 + j];  
		}
		i = 0; j = 0;
		//TestDataGenerator.PrintArray(a1);
		//TestDataGenerator.PrintArray(a2);
		for( int k = p ; k <= r ; k++){
			if( i < a1.length && j < a2.length){				
				if(a1[i] < a2[j]){
					input[k] = a1[i];
					i++;
				}else{
					input[k] = a2[j];
					j++;
				}
			}else if (i < a1.length){
				input[k] = a1[i];
				i++;
			}else if ( j < a2.length){
				input[k] = a2[j];
				j++;
			}
			else{
				throw new Exception ("noooooooooo!");
			}
		}
	}
	
	public static void main(String args[])throws Exception{
		Integer[] input = TestDataGenerator.GetArray(5, true, 20);
		TestDataGenerator.PrintArray(input);
		MergeSort(input);
		TestDataGenerator.PrintArray(input);
	}
}