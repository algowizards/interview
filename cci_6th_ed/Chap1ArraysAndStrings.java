import java.util.*;

public class Chap1ArraysAndStrings{


	// assuming case sensitive
	// assuming "space" is a character 
	public static boolean Q1_IsUnique(String input){
		
	if(input == null || input.length() == 0){
		return false;
	}
	
	HashSet<Character> inputSet = new HashSet<Character>();
	for(int i = 0; i< input.length(); i++){
		char checkChar = input.charAt(i);
		if(inputSet.contains(checkChar)){
			return false;
		}
		inputSet.add(checkChar);
	}
	return true;
	}
	
	public static boolean Q1_IsUniqueWithoutAdditionalDS(String input){
		if(input == null || input.length() == 0){
			return false;
		}else if (input.length() < 2){
			return true;
		}
		
		// though we are using additional space, this is a requirement for using the sorting algo in java. 
		// if this is not allowed, we have to use a n^2 comparing algo (similar to bubble sort)
		char[] charArray = input.toCharArray();
		Arrays.sort(charArray);
		String sortedInput = new String(charArray);
		
		for(int prev = 0, cur = 1 ; cur < sortedInput.length(); prev++, cur++ ){
			
			if(sortedInput.charAt(prev) == sortedInput.charAt(cur)){
				return false;
			}
		}
		return true;
		
	}

	public static boolean Q2IsPerumutation(String s1, String s2){
		
		if(s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0 || s1.length() != s2.length() ){
			return false;
		}
		
		Hashtable<Character, Integer> table = new Hashtable<Character, Integer>();
		
		for(int i = 0 ; i < s1.length(); i++){
			//System.out.println("Does table contain "+ s1.charAt(i) + "??? " + table.contains(s1.charAt(i)));
			// NOTE:: Warning!!! table.contains fails if you search for key. use table.containsKey.  Grr! darn you, java!
			if(table.containsKey(s1.charAt(i))){
				Integer cnt = table.get(s1.charAt(i));
				table.put(s1.charAt(i), cnt+1);
			}
			else{
				table.put(s1.charAt(i), 1);
			}
		}
		
		// now to check
		for(int i = 0 ; i < s2.length(); i++){
			char c = s2.charAt(i);
			Integer cnt = table.get(c);
			if(cnt == null || cnt == 0){
				//System.out.println("Count was " + cnt +" For char" + c);
				return false;
			}
			table.put(s2.charAt(i), cnt-1);
		}
		
		return true;
		
	}

	public static String URLify(char[] original){
		if(original == null || original.length == 0){
			return "";
		}
		
		int lastIndex = -1;
		for(int i=original.length -1; i>=0;i--){
			if(original[i]!=' '){
				lastIndex = i;
				break;
			}
		}
		
		for(int j = lastIndex, i = original.length-1; j>=0 ; ){
			
			if(original[j] ==' '){
				original[i--] = '0';
				original[i--] = '2';
				original[i--] = '%';
				j--;
			}else{
				original[i--] = original[j--];
			}
		}
		
		return new String(original);
	}

	public static boolean PalindromePermutation(String palinPerm){
		
		if(palinPerm == null || palinPerm.length() == 0){
			return false;
		}
		
		Hashtable<Character, Integer> table = new Hashtable<Character, Integer>();
		
		// add all chars to Hashtable. case insensitive comparison is required here
		for(int i = 0; i < palinPerm.length(); i++){
			char c = Character.toLowerCase(palinPerm.charAt(i));
			
			//ignore whitespaces inbetween
			if(Character.isWhitespace(c)){ 
				continue;
			}
			
			Integer count = table.get(c);
			if(count != null){
				table.put(c, count+1);
			}else{
				table.put(c, 1);
			}
		}
		
		// odd  palindromes can have one char that occurs odd number of times. rest should all be even.
		boolean isMiddleCharUnused = true;
		
		Enumeration<Character> enumKeys = table.keys();
		while(enumKeys.hasMoreElements()){
			Character key = enumKeys.nextElement();
			Integer count = table.get(key);
			if(count%2 != 0){ 
				if(isMiddleCharUnused){
					isMiddleCharUnused = false;
				}else{
					return false;
				}
			}
		}
		return true;	
	}

	// bugfixes: wrongly defined the iteration 'a' to 'z' as "int" instead of "char" -_- and fixed it
	// this code does not handle oneEdit for null/empty and single char (for instance, s1 = "" and s2 = "a"). that can be fixed by adding a check for the generic trivial cases.
	public static boolean OneEditAway(String s1, String s2){
		
		if(s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0 ){
			return false;
		}
		
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();
		
		for(int i = 0; i < s1.length(); i++){
			
			StringBuilder sb = new StringBuilder(s1);
		
			//replace
			char savedChar = sb.charAt(i);
			for(char j = 'a' ; j<='z' ; j++){
				sb.setCharAt(i, j);
				//check if the one char replace makes the strings equal
				if(s2.equals(sb.toString())){
					return true;
				}
			}
			// put the original char back
			sb.setCharAt(i, savedChar) ;
			
			//try adding a new char
			// note: can be optimized by adding a new char and reusing the replace logic above (refactor it and reuse). 
			for(char j = 'a' ; j<='z' ; j++){
				sb.insert(i, j);
				if(s2.equals(sb.toString())){
					return true;
				}
				sb.deleteCharAt(i);
			}
			//finally try deleting the char
			
			sb.deleteCharAt(i);
			//System.out.println("Buffer after deletion: " + sb.toString());
			if(s2.equals(sb.toString())){
					return true;
			}
			
			//replace the deleted char
			sb.insert(i, savedChar);
		}
		
		return false;
	}

	
	public static String Compress(String input){
		
		if(input == null || input.length() == 0){
			return input;
		}
		//string is treated as case sensitive as the allowed char set is a-z and A-Z
		int prev = 0; 
		int cur = 0;
		int count = 0;
		StringBuffer compressed = new StringBuffer();
		while(cur < input.length()){
			
			//keep moving cur until prev char and cur char are same and keep counting
			if(input.charAt(prev) == input.charAt(cur)){
				count++;
				cur++;
			}else{
				compressed.append(input.charAt(prev));
				compressed.append(count);
				count = 0;
				prev = cur;
			}
		}
		//the last piece of the string has to be accounted for.
		// i hate the 1 1/2 loop but still... -_-
		compressed.append(input.charAt(prev));
		compressed.append(count);
		
		String compressedString = compressed.toString();
		System.out.println("Compressed string: " + compressedString);
		return ((compressedString.length() < input.length())? compressedString : input);
	}
	
	// This is sub optimal (N ^3). 
	// Optimal solution can be obtained by adding the rows and column indexes to "sets"  and iterating over the set and making them all zero. (N^2 solution)
	public static void ZeroOutMatrix (int[][] matrix){
		
		//can be more rigorous to check all rows but leaving it here.
		if(matrix == null || matrix.length == 0 || matrix.length != matrix[0].length){
			return;
		}
		//mark all rows and columns that contains zero
		for(int i = 0 ; i < matrix.length; i++){
			for (int j = 0; j < matrix[0].length; j++){
				if( matrix[i][j] == 0){
					MarkRow(i, matrix);
					MarkColumn(j, matrix);
				}
			}
		}
		//sweep. mark and sweep is required to ensure we don't zero out the entire matrix because each zero we add will in turn trigger a row/column zero-isation.
		for(int i = 0 ; i < matrix.length; i++){
			for (int j = 0; j < matrix[0].length; j++){
				Sweep(matrix);
			}
		}		
		
	}
	
	private static void MarkRow(int row, int[][] matrix){
		for(int k = 0; k < matrix.length; k++){
			if(matrix[row][k]  == 1){
				matrix[row][k] = 2;
			}
		}
	}
	
	private static void MarkColumn(int column, int[][] matrix){
		for(int k = 0; k < matrix.length; k++){
			if(matrix[k][column]  == 1){
				matrix[k][column] = 2;
			}
		}
	}
	
	private static void Sweep(int [] [] matrix){
		for(int i = 0 ; i < matrix.length; i++){
			for (int j = 0; j < matrix[0].length; j++){
				if(matrix [i][j] ==2){
					matrix[i][j] = 0;
				}
			}
		}
	}
	
}