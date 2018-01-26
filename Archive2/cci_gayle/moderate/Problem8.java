//Max Of Two Numbers Without Comparison
public class Problem8{
	
	public static int LargestSum(Integer[] array) {
		int sum = 0;
		int maxSum = 0;
		
		for(int i =0; i < array.length; i++){
			sum = sum + array[i];
			if(sum > maxSum){
				maxSum = sum;
			}
			if(sum < 0 ){
				sum = 0;
			}
			
		}
		return maxSum;
	}
	public static void main(String args[]){
		Integer[] temp = TestDataGenerator.GetArray(10, true , 20);
		TestDataGenerator.MakeRandomValuesNegative(temp);
		TestDataGenerator.PrintArray(temp);
		System.out.println("Largest Sum = " + LargestSum(temp));
		
	}
}