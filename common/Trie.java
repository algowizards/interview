import java.util.*;

public class Trie{
	
	private TrieNode root = new TrieNode(null);
	
	public void BuildTrie(ArrayList<String> wordList){
		
		System.out.println("Building Trie...");
		for(int i = 0 ; i < wordList.size(); i++)
		{
			AddWord(wordList.get(i));
		}		
		System.out.println("Trie Complete with " + wordList.size() + " elements");
	}
	
	public void AddWord(String word){
	
		word = word.toLowerCase();
		System.out.println("Adding word: " + word);	
		TrieNode current = root;
		
		for(int i = 0; i < word.length(); i++){
			
			Character curChar = word.charAt(i);
			if( current.Children == null){
				current.Children = new LinkedHashMap<Character, TrieNode>();
			}
			if( !current.Children.containsKey(curChar) ){
				current.Children.put(curChar, new TrieNode(curChar));
			}
			current = current.Children.get(curChar);
			
		}
		current.IsTerminalNode = true;
		current = root;	
	}
	
	
	public Boolean Parse(String s){
	
		Trie current = root;
		if(s == null || s == "" )
		{
			return true;
		}
		for( int i = 0 ; i < s.length(); i++){
			Character curChar = new Character(s.charAt(i));
			if(current.Children == null || !current.Children.containsKey(curChar) ){
				return false;
			}else{
				current = current.Children.get(curChar);
			}
		}
		return true;
	}
	
	
	/* not required currently, but still leaving it. not tested! */
	/*
	public void ResetTrie(){
		current = root;
	}
	
	public Boolean IsCurrentNodeTerminal(){
		return current.IsTerminalNode;
	}
	
	public Boolean Parse(Character c){
		if(c == null)
		{
			return true;
		}
		if(current.Children.containsKey(c)){
			current = current.Children.get(c);
			return true;
		}
		return false;
	}
	*/
}