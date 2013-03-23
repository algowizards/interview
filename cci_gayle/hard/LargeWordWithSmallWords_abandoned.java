public class LargeWordWithSmallWords{
	Trie trie;

	public LargeWordWithSmallWords(String filePath){
		trie = new Trie();
		trie.BuildTrie(GetWordsFromFile(filePath));
	}
	public ArrayList<String> GetWordsFromFile(String filePath){
	
	}
	
	public String FindLargestWithSmallWords(ArrayList<String> words){
		String result = "";
		Arrays.Sort(words, new MyStringComparator<String>());
		
		for(int i = 0 ; i < words.size(); i++){
			if(CanBuildWordFromOtherWords("", words[i], 0) > 1){
				return words[i];
			}
		} 
	
	}
	public BuildResult CanBuildWordFromOtherWords(String soFar, String remaining, BuildResult res){
		if(remaining == null || remaining.size() == 0){
			return res;
		}
		
		StringBuffer sb = new StringBuffer(remaining);
		trie.Reset();
		for(int i = 0; i< sb.size(); i++){
			while(trie.CanParse(sb[i])){
				soFar = soFar + sb[i];
				trie.Parse(sb[i]);
				if(trie.IsCurrentNodeTerminal()){
					CanBuildWordFromOtherWords (
					soFar, remaining.subString(i), new BuildResult(res.StackDepth+1,true);
				}
			}
		}
		res.IsParseSuccessFul = false;
		return res;
		
		
	}
	
	


}

class MyStringComparator<String> implements Comparator{
		@Override
		public int compare(String s1, String s2){
			return s2.length.compareTo(s1.length);
		}
	}