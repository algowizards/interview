import java.util.*;

public class AnagramFinder{
	
	public static String FindAnagram(String word){
	
		return FindAnagramRecursive("", word, word);
	}
	
	public static String FindAnagramRecursive(String soFar, String remaining, String originalWord){
		
		if(remaining == null || remaining.equalsIgnoreCase("")){
			
			
			if(!soFar.equals(originalWord) && DictionaryHelper.GetDictionary().contains(soFar)){
				System.out.println("Generated word " + soFar);
				return soFar;
			}		
			return "";
		}
		
		for(int i= 0 ; i< remaining.length() ; i++){
			
			String soFarNew = soFar + remaining.charAt(i);
			String remainingNew = remaining.substring(0,i) + remaining.substring(i+1);
			String anagram = FindAnagramRecursive(soFarNew, remainingNew, originalWord);
			if(!anagram.equalsIgnoreCase("")){
				return anagram;
			}
		}
		return "";
	}
	
	
	public static void main(String args[]){
		//DictionaryHelper.LoadDictionary("..\\common\\dictionary.csv");
		String input = "danger";
		System.out.println(String.format("Anagram of %s is %s", input, AnagramFinder.FindAnagram(input)));
	}
	
	
}