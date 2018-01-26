import java.util.*;

public class Problem10_RadixSort{

	public static ArrayList<Integer> Sort(Integer[] array){
		if (array == null || array.length ==1){
			return new ArrayList<Integer>(Arrays.asList(array));
		}
		//new ArrayList<Integer>()
		return SortRec(new ArrayList<Integer>(Arrays.asList(array)), 1);
	}
	private static ArrayList<Integer> SortRec(ArrayList<Integer> arrayList, int digitToExtract){
		
		LinkedHashMap<Integer,ArrayList<Integer>> bucket = new LinkedHashMap<Integer,ArrayList<Integer>>();
		
		for(int i = 0; i < 10 ; i++){
			bucket.put(i, new ArrayList<Integer>());
		}
		
		for(int i=0 ; i< arrayList.size() ; i++){
			int bucketDigit = getBucketDigit(arrayList.get(i), digitToExtract);
			bucket.get(bucketDigit).add(arrayList.get(i));
		}
		
		ArrayList<Integer> resultList = new ArrayList<Integer>();
		int bucketCounter = 0;
		
		for(int i=0;i<10;i++){
			if (bucket.get(i).size() > 0){
				resultList.addAll(bucket.get(i));
				bucketCounter++;
			}	
		}
		if(bucketCounter > 1){
			return SortRec(resultList, digitToExtract+1);
		}
		return resultList;
	}
	private static int getBucketDigit(int number, int digitToExtract){
		
		int div = 1;
		for(int i = 0 ; i< digitToExtract; i++){
			div*=10;
		}
		int modVal = number % div;
		return modVal / (div/10);
	}
	
	public static void main(String args[]){
		Integer[] temp = TestDataGenerator.GetArray(10000000, true, 20);
		//TestDataGenerator.PrintArray(temp);
		TestDataGenerator.PrintArray(Sort(temp));
	}

}