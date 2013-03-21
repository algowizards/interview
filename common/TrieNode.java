public class TrieNode{
	public Character Data;
	public LinkedHashMap<Character, TrieNode> Children;
	public bool IsTerminalNode;
	
	public bool IsLastChar(){
		if(Children == null || Children.size() == 0){
			return true;
		}
		return false;
	}
	
	public TrieNode(Character data){
		Data = data;
	}	

}