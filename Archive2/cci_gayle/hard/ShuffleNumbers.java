import java.util.*;

public class ShuffleNumbers{

	public static void Shuffle(Integer[] input){
	
		if(input == null || input.length <= 1){
			return;
		}
		
		Random r = new Random();
		for(int i = input.length -1 ; i > 0 ; i--){
			int randomIndex = r.nextInt(i+1); 
			TestDataGenerator.Swap(input, randomIndex, i);
		}
	}

	public static void main(String args[]){
		Integer [] testArray = TestDataGenerator.GetArray(10, false, 20);
		TestDataGenerator.PrintArray(testArray);
		Shuffle(testArray);
		TestDataGenerator.PrintArray(testArray);
	}

}