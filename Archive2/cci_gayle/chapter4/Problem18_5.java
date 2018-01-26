import java.util.*;

//find shortest distance between two words
public class Problem18_5{
		
	public static int GetShortestDistanceBetweenTwoWords(String[] words, String word1, String word2){
		
		int w1Index = -1;
		int w2Index = -1;
		int minDiff = Integer.MAX_VALUE;
		
		for(int i = 0; i < words.length; i++){
		
			if(words[i].equalsIgnoreCase(word1)){
				w1Index = i;
				if(w2Index != -1){
					minDiff =  ((w1Index - w2Index) < minDiff) ? (w1Index - w2Index): minDiff;
				}		
			}else if (words[i].equalsIgnoreCase(word2)){ //remove "else" here if w1=w2 and expected output = 0
				w2Index = i;
				if(w1Index != -1){
					minDiff = ( (w2Index - w1Index) < minDiff) ? (w2Index - w1Index) : minDiff;
				}
			}
			
		}
		return minDiff;
	}	
	public static void main(String args[]){
	
		String[] words = {"aaa", "aab" ,"bbb", "ccc", "dddd", "a", "b", "bbb", "aaa"};
		String w1 = "aaa";
		String w2 = "bbb";
		System.out.println( String.format("Min Distance between %s and %s ignoring order is %d",
		w1, w2, GetShortestDistanceBetweenTwoWords(words, w1, w2)));
		
		
		w1 = "aaa";
		w2 = "bbbb";
		System.out.println( String.format("Min Distance between %s and %s ignoring order is %d",
		w1, w2, GetShortestDistanceBetweenTwoWords(words, w1, w2)));
		
		w1 = "a";
		w2 = "aab";
		System.out.println( String.format("Min Distance between %s and %s ignoring order is %d",
		w1, w2, GetShortestDistanceBetweenTwoWords(words, w1, w2)));
		
		w1 = "aab";
		w2 = "aab";
		System.out.println( String.format("Min Distance between %s and %s ignoring order is %d",
		w1, w2, GetShortestDistanceBetweenTwoWords(words, w1, w2)));
	}

}