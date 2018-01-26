import java.util.*;

public class Problem10_2{
	
	private static class AnagramComparator implements Comparator<String>{
		
		public String SortChar(String s){
			char[]	charArray = s.toCharArray();
			Arrays.sort(charArray);
			//return charArray.toString(); //wont work cuz it returns junk like "[C@190d11" (tostring on Object)
			return new String(charArray);
		}
		
		
		public int compare(String s1, String s2){
			return SortChar(s1).compareTo(SortChar(s2));
			
				
		}
		
	}

	public static void main(String args[]){
		String[] testData = TestDataGenerator.GetStringArray();
		Arrays.sort(testData, new AnagramComparator());
		TestDataGenerator.PrintArray(testData);
		
	}
}