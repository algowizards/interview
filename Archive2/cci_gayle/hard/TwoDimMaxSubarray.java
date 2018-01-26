public class TwoDimMaxSubarray{

	public static int FindMaxSumSubArray(Integer[][] array){
		
		if( array == null || array.length == 0 || array[0].length == 0 ){
			return 0;
		}
		int rowSize = array.length;
		int colSize = array[0].length;
		int maxSum = Integer.MIN_VALUE;
		Integer[] partialSumArray = new Integer[colSize];
		
		for( int rowStart = 0; rowStart < rowSize; rowStart++){
			ClearArray(partialSumArray);
			for(int rowEnd = rowStart; rowEnd < rowSize; rowEnd++){
				for(int i = 0 ; i < colSize; i++){
					partialSumArray[i] = partialSumArray[i] + array[rowEnd][i];
				}	
				int tempSum = GetMaxSubArraySum(partialSumArray, colSize);
				maxSum = Math.max(tempSum, maxSum);
			}
		}
		return maxSum;
	}
	public static int GetMaxSubArraySum(Integer[] array, int n){
		int runningSum = 0;
		int maxSum = 0;
		for(int i = 0; i < n ; i++){
			runningSum = runningSum + array[i];
			maxSum = Math.max(maxSum, runningSum);
			if(runningSum < 0 ) {
				runningSum = 0;
			}
		}
		return maxSum;
	}
	
	public static void ClearArray(Integer[] array){
		if(array == null){
			return;
		}
		for(int i = 0; i < array.length; i++){
			array[i] = 0;
		}
	}
	public static void main(String args[]){
		Integer[][] array = TestDataGenerator.GetArray(2,3, true, 10);
		TestDataGenerator.MakeRandomValuesNegative(array);
		TestDataGenerator.PrintArray(array);
		int maxSum = FindMaxSumSubArray(array);
		System.out.println("Max Sum = " + maxSum);
	}
}