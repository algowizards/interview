import java.util.*;

public class SearchLongwordForShortWords{
	public static void SearchPrint(String longWord, String[] shortWords){
		
		if(longWord == null || shortWords == null || longWord =="" || shortWords.length == 0){
			return;
		}
		Trie trie = new Trie();
		for(int i = 0; i < longWord.length(); i++){
			trie.AddWord(longWord.substring(i));
		}
		
		for(int i = 0 ; i < shortWords.length; i++){
			System.out.println(shortWords[i] +" is present?  " + trie.Parse(shortWords[i]));
		}
	}
	
	public static void main(String args[]){
	
		String longW = "abracadabra";
		String[] shortL = new String[]{"ab", "xy", "cadabra", "cadabrra", "bra", "dabra", "poco" , "dabrac"};
		SearchPrint(longW, shortL);
	}
}