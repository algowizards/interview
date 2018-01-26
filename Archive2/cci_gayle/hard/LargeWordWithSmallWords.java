import java.io.*;
import java.util.*;

public class LargeWordWithSmallWords{

	public static String FindLargestWithSmallWords(String[] words){
		
		Arrays.sort(words, new ReverseSortComparator());
		LinkedHashMap<String,Boolean> dictionary = new LinkedHashMap<String,Boolean>();
		
		for(int i = 0 ; i < words.length; i++){
			dictionary.put(words[i], true);
		}
		
		for(int i = 0 ; i < words.length; i++){
			if(CanBuildWordFromOtherWords(words[i], true, dictionary)){
				return words[i];
			}
		} 
		return null;
	}
	
	public static Boolean CanBuildWordFromOtherWords(String word, Boolean isOriginal, 
	LinkedHashMap<String,Boolean> dictionary){
		
		if(dictionary.containsKey(word) && isOriginal != true){
			return dictionary.get(word);
		} 
		
		for(int i = 1; i < word.length(); i++){
			String left = word.substring(0,i);
			String right = word.substring(i);
			
			if(dictionary.containsKey(left) && dictionary.get(left) && 
			CanBuildWordFromOtherWords(right, false, dictionary )){
				return true;
			}
		}
		dictionary.put(word, false);
		return false;
	}
	
	public static void main(String args[]){
	
		String result = FindLargestWithSmallWords(DictionaryHelper.GetDictionary().toArray(new String[0]));
		System.out.println("The largest word made of other words is: "  + result);
	}
	


}

class ReverseSortComparator implements Comparator<String>{
	@Override
	public int compare(String s1, String s2){
		return s2.length() - s1.length();
	}
}