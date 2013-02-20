import java.util.*;

public class TestDataGenerator{

	public static Integer[] GetArray(int n, boolean fillWithRandom, int bound){
		Integer[] array = new Integer[n];
		if(fillWithRandom){
			FillWithRandomValues (array, bound);
		}else{
			for(int i = 0; i< n; i++){
				array[i] = i % bound;				
			}
		}
		return array;
	}
	
	public static void FillWithRandomValues(Integer[] array, int bound){
		if(array == null || bound < 1){
			return;
		}
		Random r = new Random();
		for(int i = 0; i< array.length; i++){
			array[i] = r.nextInt(bound);
		}
	}
	
	public static void Shuffle(Integer[] array) throws Exception{
		throw new Exception("Not implemented yet");
	}
	
	public static void PrintArray(Integer[] array){
		System.out.println("");
		
		if(array == null)
		{
			System.out.println("Empty array");
			return;
		}
		for (int i = 0; i< array.length; i++){
			System.out.print(" " + array[i]);
		}
		
		System.out.println("");
	}
	
	public static void main(String args[]){
		
		Integer[] temp = GetArray( 10, true, 20);
		PrintArray(temp);
	}
}