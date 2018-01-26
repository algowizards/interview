import java.util.*;

public class PairOfNumbers{

	public static void PrintPairs(Integer[] array, int sum){
		if(array == null){
			return;
		}
		Set<Integer> setOfNumbers = new HashSet<Integer>();
		for(int i = 0; i < array.length; i++){
			if(setOfNumbers.contains(sum-array[i])){
				System.out.println("Found pairs " + array[i] +" paired with " + (sum - array[i]) );
			}
			setOfNumbers.add(array[i]);
		}
	
	}
	public static void main(String args[]){
		Integer[] input = TestDataGenerator.GetArray(10, true, 20);
		TestDataGenerator.PrintArray(input);
		PrintPairs(input, 10);
	}

	

}