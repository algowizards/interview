public class Trie{
	
	private TrieNode root = new TrieNode();
	private TrieNode current = root;
	
	public void BuildTrie(ArrayList<String> wordList){
		
		System.out.println("Building Trie...");
		for(int i = 0 ; i < wordList.size(); i++)
		{
			AddWord(wordList.get(i);
		}		
		System.out.println("Complete with " + wordList.size() + " elements");
	}
	public void AddWord(String word){
		
		StringBuffer wordBuffer = new StringBuffer(word.toLower());
		TrieNode current = root;
		for(int i = 0; i < wordBuffer.size(); i++){
			if( current.Children == null){
				current.Children = new LinkedHashMap<Character, TrieNode>();
			}
			if(!current.Children.contains(wordBuffer.get(i))){
				current.Children.put(wordBuffer.get(i), new TrieNode(wordBuffer.get(i)));
			}
			current = current.Children.get(wordBuffer.get(i));
			
		}
		current.IsTerminalNode = true;
	}
	
	public void ResetTrie(){
		current = root;
	}
	
	public bool IsCurrentNodeTerminal(){
		return current.IsTerminalNode;
	}
	
	public bool Parse(Character c){
		if(c == null)
		{
			return true;
		}
		if(current.Children.contains(c)){
			current = current.Children.get(c);
			return true;
		}
		return false;
	}
	
	public bool Parse(String s){
		if(s == null || s == "" )
		{
			return true;
		}
		StringBuffer sb = new StringBuffer(s);
		for( int i = 0 ; i < sb.size(); i++){
			if(current.Children.contains(sb[i])){
				current = current.Children.get(sb[i]);
			}else{
				return false;
			}
		}
		return true;
	}
	
	
	public bool CanParse(Character c){
		if(c == null)
		{
			return false;
		}
		return current.Children.contains(c);
	}
	
	public void Trie(String fileName){
		
		
	
	}


}