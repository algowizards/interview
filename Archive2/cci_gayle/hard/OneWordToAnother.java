import java.util.*;


public class OneWordToAnother{
	
	private Set<String> dictionary;
	
	public OneWordToAnother(){
		dictionary = DictionaryHelper.GetDictionary();
	}
	
	public ArrayList<String> ConvertOneWordToAnother(String word1, String word2){
		word1 = word1.toLowerCase();
		word2 = word2.toLowerCase();
		if(word1== null || word2 == null || word1 == "" || word2 == "" || word1.equals(word2)){
			System.out.println("Invalid input");
			return null;
		}
		
		Queue<String> actionQ = new LinkedList<String>();
		HashSet<String> visitedSet = new HashSet<String>();
		LinkedHashMap<String,String> pathMap = new LinkedHashMap<String,String>();
		
		actionQ.offer(word1);
		visitedSet.add(word1);
		
		while(!actionQ.isEmpty()){
		
			String wordOut = actionQ.poll();
			//System.out.println("Processing word : " + wordOut);
			ArrayList<String> oneCharWords = GetAllValidOneCharChangedWords(wordOut);
			
			for( int i = 0 ; i < oneCharWords.size(); i++){
				String curWord = oneCharWords.get(i);
				if(curWord.equals(word2)){
					System.out.println("\nYahoo! found a path!");
					return BuildPath(wordOut, word2, pathMap);
				}
				
				if(!visitedSet.contains(curWord)){
					visitedSet.add(curWord);
					actionQ.offer(curWord);
					pathMap.put(curWord, wordOut);
					//System.out.println("action q size " + actionQ.size());
				}
			}
		}	
		return null;	
	}
	public ArrayList<String> GetAllValidOneCharChangedWords(String wordOut){
		
		ArrayList<String> validWordsList = new ArrayList<String>();
		for (int i = 0; i < wordOut.length(); i++){
			for( char c = 'a'; c <='z'; c++){
				if( c != wordOut.charAt(i))
				{
					String newWord = wordOut.substring(0, i) + c + wordOut.substring(i+1);
					if(dictionary.contains(newWord)){
						validWordsList.add(newWord);
					}
				}
			}
			
		}
		//TestDataGenerator.PrintArray(validWordsList);
		//System.out.println(String.format("Returning %d valid words for %s", validWordsList.size(), wordOut));
		return validWordsList;
	}
	public ArrayList<String> BuildPath(String curWord, String word2, LinkedHashMap<String,String> pathMap){
		ArrayList<String> result = new ArrayList<String>();
		result.add(word2);
		while(curWord != null){
			result.add(0, curWord);
			curWord = pathMap.get(curWord);
		}
		return result;
	}
	
	public static void main(String args[]){

		String word1 = "bunk";
		String word2 = "sent";
		ArrayList<String> result = (new OneWordToAnother()).ConvertOneWordToAnother(word1, word2);
		TestDataGenerator.PrintArray(result);
		
		word1 = "glide";
		word2 = "drive";
		result = (new OneWordToAnother()).ConvertOneWordToAnother(word1, word2);
		TestDataGenerator.PrintArray(result);
		
	}
	
}