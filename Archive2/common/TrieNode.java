import java.util.*;

public class TrieNode{
	public Character Data;
	public LinkedHashMap<Character, TrieNode> Children;
	public Boolean IsTerminalNode;
	
	public Boolean IsLastChar(){
		if(Children == null || Children.size() == 0){
			return true;
		}
		return false;
	}
	
	public TrieNode(Character data){
		Data = data;
	}	

}