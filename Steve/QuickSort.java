import java.util.*;

public class QuickSort{
	public static void QuickSort(Integer[] input){
		
		if (input == null || input.length == 0 || input.length == 1){
			return ;
		}
		QuickSortRec(input , 0, input.length - 1);
		
	}
	
	public static void QuickSortRec(Integer[] input, int p, int r){
	
		if( p <= r){
			//System.out.println( "P =" + p + "R = " + r);
			int q = Pivot(input, p, r);
			//System.out.println("Pivot " + q + "P =" + p + "R = " + r);
			QuickSortRec(input, p, q - 1 );
			QuickSortRec(input, q + 1, r );
			
		}
	
	}
	
	private static int Pivot(Integer [] input, int p, int r){
		
		int x = input[r];
		int j = p-1;
		int i = p;
		for(; i < r ; i++){
			if( input[i] <= x){
				j++;
				SwapElement(input, i, j);
			}
		}
		j++;
		SwapElement(input, i, j);
		return j;
	}
	
	private static void SwapElement(Integer[] input, int i, int j){
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
	
	public static void main(String args[]){
		Integer[] input = TestDataGenerator.GetArray(10, true, 20);
		TestDataGenerator.PrintArray(input);
		QuickSort(input);
		TestDataGenerator.PrintArray(input);
	}
}