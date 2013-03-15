import java.util.*;

public class GetMRandomFromN{

	public static Integer[] GetMRandomFromN(Integer[] input, int m)throws Exception{
	
		if(input == null || input.length < m || m <=0){
			throw new Exception ("Invalid input array size Or requested count <=0");
		}
		Integer[] result = new Integer[m];
		Random r = new Random();
		int i = input.length -1;
		
		for(int j = 0; j < m ; j++  ){
			int randomIndex = r.nextInt(i+1); 
			result[j] = input[randomIndex];
			TestDataGenerator.Swap(input, randomIndex, i);
			i--;
		}
		return result;
	}

	public static void main(String args[]) throws Exception{
		Integer [] testArray = TestDataGenerator.GetArray(10, false, 20);
		TestDataGenerator.PrintArray(testArray);
		Integer[] result = GetMRandomFromN(testArray, 10);
		TestDataGenerator.PrintArray(result);
		result = GetMRandomFromN(testArray, 1);
		TestDataGenerator.PrintArray(result);
		result = GetMRandomFromN(testArray, 3);
		TestDataGenerator.PrintArray(result);
		result = GetMRandomFromN(testArray, 0);
		TestDataGenerator.PrintArray(result);
		result = GetMRandomFromN(testArray, -1);
		TestDataGenerator.PrintArray(result);



		
	}
	

}