
//this is an additional problem of Longest non-decreasing contiguous sequence of integers
public class Problem10_7_0{

	public static Integer[] GetLongestSequence(Integer[] array){
		if(array == null){
			return null;
		}
		
		int savedStart = 0;
		int savedLength = 1;
		int currentStart = 0;
		for(int i = 1; i < array.length; i++){
			if( array[i] >= array[i-1] ) {
				int currentLength = (i - currentStart + 1);
				if( currentLength > savedLength){
					savedStart = currentStart;
					savedLength = currentLength;
				}else{}
			}else{
				currentStart = i;
			}
		}
		Integer[] result = new Integer[savedLength];
		for(int i=0; i<savedLength; i++){
			result[i] = array[savedStart + i];
		}
		return result;
	}
	public static void main(String args[]){
		Integer[] testData = TestDataGenerator.GetArray(10, true, 10);
		TestDataGenerator.PrintArray(testData);
		Integer[] result = GetLongestSequence(testData);
		TestDataGenerator.PrintArray(result);
	}

}