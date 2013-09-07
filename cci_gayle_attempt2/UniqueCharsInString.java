public class UniqueCharsInString{
	
	public static DoesStringHaveUniqueChar(String s){
		if(s == null || s.length() <= 1 ){
			return;
		}
		HashSet<Character> table = new HashSet<Character>();
		
		for (int i = 0 ; i < s.length(); i++){
			
			Character c = new Character(s.charAt(i));
			if(table.contains(c)){
				return false;
			}
			table.put(c);
		}
		return true;
	}

}
