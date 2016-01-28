import java.util.*;
public class LastAttempt{

	// chapter 1
public static boolean isUniqueAscii(String str) throws Exception{
	
		//null or empty check
		if(str == null || str.length() < 1 ){
			return true;
		}
		
		//ascii - array; a-z only - bit ; unicode - hashtable 
		boolean[] table =  new boolean[256];
		for(int  i = 0 ; i < str.length(); i++){
			
			int intval = str.charAt(i);
			if(intval > 255){
				throw new Exception ("Invalid Char. Should be Ascii! " + intval);
			}
			
			if(table[intval]){
				return false;
			}
			table[intval] = true;
		}
		
		return true;
	} 

	public static boolean isUniqueAsciiAtt2(String str) throws Exception{
	
		if(str == null || str.length() < 1){
			return true;
		}
		
		boolean[] table = new boolean[256];
		
		for ( int i =  0 ; i < str.length(); i++){
			
			int intval = str.charAt(i);
			
			if(intval > 255){
				throw new Exception("Value should be Ascii (0 to 255)! but found : " + intval);
			}
			
			if(table[intval]){
				return false;
			}
			table[intval] = true;	
		}
		return true;
	}

	public static boolean isUniqueAsciiAtt3(String str) throws Exception{
		
		if(str == null  || str.length() < 1 ){
			return true;
		}
		
		boolean[] table = new boolean[256];
		
		for(int i = 0 ; i < str.length(); i++){
			
			int intVal = str.charAt(i);
			
			if(intVal > 255){
				throw new Exception ("Ascii required but found " + intVal);
			}
			
			if(table[intVal]){
				return false;
			}
			
			table[intVal] = true;
		}
		
		return true;
	}
	
	
	public static boolean isUniqueAsciiAtt4(String str) throws Exception {
		
		if(str == null || str.length() < 1){
			return true;
		}
		
		boolean[] table = new boolean[256];
		
		for (int i = 0; i < str.length(); i++){
			
			int intVal = str.charAt(i);
			if(intVal > 255){
				
				throw new Exception ("Char should be ascii but found: " + intVal);
			}
			
			if(table[intVal]){
				return false;
			}
			
			table[intVal] = true;
		}
		
		return true;
	}
	
	
	
	public boolean isUniqueAToZ(String str) throws Exception{
		
		if(str == null || str.length() < 1){
			
			return true;
		}
		
		//can also do length > 26 check for opti
		
		int table = 0;
		
		for(int i = 0; i < str.length(); i++){
			
			int intVal = str.charAt(i) - 'a';
			
			if(intVal > 26 || intVal < 0){
				throw new Exception ("Char should be between a-z but found " + str.charAt(i) );
			}
			
			int bitVal = 1 << intVal;
			
			if( (table & bitVal) > 0 ){
				return false;
			}
			
			table |= bitVal;
		}
		
		return true;
	}
	
	
	public boolean isPermAscii(String s1, String s2) throws Exception{
		
		if(s1 == null || s2 == null || s1.length() != s2.length()){
			return false;
		}
		
		int[] table = new int[256];
		
		// add s1 to ref table
		for (int i = 0; i < s1.length(); i++){
			
			int intVal = s1.charAt(i);
			if(intVal > 255)
			{
				throw new Exception("Val not ascii" + intVal);
			}
			
			table[intVal] = table[intVal] + 1;	
		}
		
		//check s2 
		for (int i = 0 ; i < s2.length(); i++){
			
			int intVal = s2.charAt(i);
			if(intVal > 255)
			{
				throw new Exception("Val not ascii" + intVal);
			}
			
			table[intVal] = table[intVal] - 1;
			
			if(table[intVal] < 0){
				return false;
			}
		}
		return true;
	}
	
	
	public boolean isPermAsciiAtt2(String s1, String s2)throws Exception{
		
		if(s1 == null || s2 == null || s1.length() != s2.length()){
			return false;
		}
		
		int[] table = new int[256];
		
		for(int i = 0 ; i < s1.length(); i++){
			
			int intVal = s1.charAt(i);
			
			if(intVal > 255){
				
				throw new Exception("Asii expected!!" + intVal);
			}
			table[intVal] = table[intVal] + 1;
		}
		
		for(int i = 0 ; i < s2.length(); i++){
			
			int intVal = s2.charAt(i);
			
			if(intVal > 255){
				
				throw new Exception ("Ascii expected!! " + intVal);
			}
			table[intVal] =  table[intVal] - 1;
			
			if(table[intVal] < 0){
				return false;
			}
		}
		return true;	
	}
	
	
	public void URLify(char[] s, int len) throws Exception{
		
		if(s == null || len <= 0 ){
			throw new Exception("Invalid Arg");
		}
		
		int spaceCnt = CountSpaces(s, len);
		
		int wPtr = len + 2 * spaceCnt;
		int rPtr = len - 1;
		
		if( wPtr > s.length - 1){
			
			throw new Exception ("Insufficient space detected");
		}
		
		while(rPtr >= 0 ){
			
			if(s[rPtr] == ' '){
				
				s[wPtr] = '0';
				wPtr--;

				s[wPtr] = '2';
				wPtr--;

				s[wPtr] = '%';
				wPtr--;
			}
			else{
				s[wPtr] = s[rPtr];
				wPtr--;
				rPtr--;
			}
		}
	}
	
	private int CountSpaces(char[] s, int l){
		
		if(s == null ){
			return 0;
		}
		
		int counter = 0;
		for( int i = 0; i < l; i++)
		{
			if(s[i] == ' '){
				counter++;
			}
		}
		
		return counter;
	}
	
	
	public void URLifyAtt2(char [] s, int len){
		
		if(s == null || len <= 0 ){
			return ; //or throw exception
		}
		
		int cnt = CountSpacesAtt2(s, len);
		
		int rPtr = len - 1;
		int wPtr = len - 1 + 2 * cnt;
		
		if(wPtr > s.length - 1){
			return; //or throw exception
		}
		
		while( rPtr >= 0 ){
			
			if(s[rPtr] == ' '){
				
				s[wPtr] = '0';
				wPtr--;

				s[wPtr] = '2';
				wPtr--;

				s[wPtr] = '%';
				wPtr--;
				
				rPtr--;
			}else{
				
				s[wPtr] = s[rPtr];
				wPtr--;
				rPtr--;
			}
			
		}
		
	}
	
	private int CountSpacesAtt2(char[] s, int len){
		
		if(s == null || len <= 0 ){
			return 0;
		}
		
		int cnt = 0;
		for(int i = 0; i < len; i++){
			
			if(s[i] == ' '){
				cnt++;
			}
		}
		return cnt;
		
	}
	
	//assume only "char A-Z or a-z"
	public static boolean isPalindromePerm(String s) throws Exception{
		
		
		if(s == null || s.length() <= 1 ){
			return true;
		}
		
		int table = 0;
		
		for (int i = 0 ; i < s.length(); i++){
			
			int intVal = getIntVal(s.charAt(i));
			table = flipBit(table, intVal);	
			
		}
		
		int count = 0;
		while(table > 0){
			table = (table & (table - 1));
			count++;
			if(count > 1){
				return false;
			}
		}
		
		return true;
		
	}
	
	private static int getIntVal(char c) throws Exception{
		if( c >= 'a' &&  c <=  'z' ){
			return c - 'a';
		}else if ( c >= 'A' && c <= 'Z'){
			return c - 'A';
		}else{
			throw new Exception ("Invalid Char detected  " + c);
		}
		
		
	}
	
	private static int flipBit(int table, int intVal){
		
		int val = ( table & (1 << intVal));
		
		if(val > 0){ //got a bit "set". clear it.
			
			int mask = 1 << intVal;
			mask = ~mask;
			table = table & mask;
			
		}else{ // clear. then set it
			
			table =  (table | (1 << intVal));
		}
		
		return table;
	}
	
	public static boolean isPalindromePermAtt2(String s){
		
		if(s == null || s.length() <= 1){
			return true;
		}
		
		int table = 0;
		
		for (int i= 0; i < s.length() ; i++){
			
			int intVal = getIntValAtt2(s.charAt(i));
			if(intVal != -1){ //consider valid alphabets only
				table = flipBitAtt2(table, intVal);
			}
		}
	
		int count = 0;
		while(table > 0 ){
			
			table = ( table & (table - 1));
			count++;
			if(count > 1){
				return false;
			}
		}
		return true;
	}
	
	private static int getIntValAtt2(char c){
		
		if(c>= 'a' && c <= 'z'){
			return c - 'a';
		}
		else if (c>= 'A' && c<= 'Z'){
			return c - 'Z';
		}
		else return -1;
		
	}
	
	private static int flipBitAtt2(int table, int intVal){
		
		int bitVal = (table & (1 << intVal));
		
		if(bitVal > 0){ //set. reset it.
			
			int mask = 1 << intVal;
			mask  = ~mask;
			table = table & mask;		
		}
		else{
			
			table |= (1 << intVal);
			
		}
		return table;
	}
	
	public static boolean isPalindromePermUnicode(String s){
		
		if(s== null || s.length() <= 1){
			return true;
		}
		
		Hashtable<Character,Boolean> table = new Hashtable<Character, Boolean>();
		
		for(int i = 0 ; i < s.length(); i++){
			char c = s.charAt(i);
			if(Character.isLetterOrDigit(c)){
				if(table.containsKey(c)){
					Boolean flag = table.get(c);
					table.put(c, !flag);
				}
				else
				{
					table.put(c, true);
				}
			}
		}
		
		boolean oddFound = false;
		
		Enumeration<Character> enumKeys = table.keys();
		while(enumKeys.hasMoreElements()){
			
			Character c = enumKeys.nextElement();
			Boolean oddFlag = table.get(c);
			if(oddFlag){
				if(oddFound){
					return false;
				}else{
					oddFound = true;
				}
			}
		}
		
		return true;
	}
	
	public static boolean isPalindromePermUnicodeAtt2(String s){
		
		if (s == null || s.length() <= 1){
			return true;
		}
		Hashtable<Character, Boolean> table = new Hashtable<Character, Boolean>();
		
		for(int i = 0 ; i < s.length(); i++){
			char c = s.charAt(i);
			
			if(Character.isLetterOrDigit(c)){
				if(table.containsKey(c)){
					Boolean val = table.get(c);
					table.put(c, !val);
				}
				else{
					table.put(c, true);
				}
			}
		}
		
		boolean oddFound = false;
		
		Enumeration<Character> enumIter = table.keys();
		while(enumIter.hasMoreElements()){
			
			Character key = enumIter.nextElement();
			Boolean val = table.get(key);
			
			if(val){
				if(oddFound){
					return false;
				}else{
					oddFound = true;
				}
			}
		}
		return true;
	}
	
	
	public boolean OneCharAway(String s, String t){
		
		if(s == null || t== null){
			return false;
		}
		
		if(s.length() == t.length()){
			return IsReplace(s,t);
		}
		else if( (s.length() - t.length()) == 1){
			return IsOneChar(s, t);
		}
		else if( (t.length() - s.length()) == 1){
			return IsOneChar(t, s);
		}
		else { //review: else is redundant here
			return false;
		}
	}
	
	private boolean IsReplace(String s, String t){
		
		boolean mismatchFound = false;
		
		for(int i = 0; i < s.length(); i++){
			
			if(s.charAt(i) != t.charAt(i)){
				if(mismatchFound){
					return false;
				}else{ // review: redundant else again
					mismatchFound = true;
				}
			}
		}
		return true;
	}
	
	
	private boolean IsOneChar(String longer, String shorter){
		
		boolean misMatchFound = false;
		for(int i = 0 , j = 0 ; i < shorter.length(); ){ //for generic case, good to check j<longer.length() as well. 
			
			if(shorter.charAt(i) != longer.charAt(j)){
				if(misMatchFound){
					return false;
				}else{ // review : else is redundant again
					misMatchFound = true;
					j++;
				}
			}else{
				i++;
				j++;
			}
		}
		return true;
	}
	
	
	public static String Compress(String s){
		
		if(s == null || s.length() == 0){
			return s;
		}
		
		int compressCnt = countCompressed(s);
		
		if(compressCnt >= s.length()){
			return s;
		}
		
		StringBuffer sb = new StringBuffer(compressCnt);
		
		int curCnt = 0;
		for(int i = 0 ; i < s. length(); i++){
			
			curCnt++;
			
			if( (i + 1 >= s.length()) || s.charAt(i) != s.charAt(i+1) ){
				sb.append(s.charAt(i));
				sb.append(curCnt);
				curCnt = 0;
			} 
		}
		
		return sb.toString();
		
	}
	
	private static int countCompressed(String s){
		
		int totalCnt = 0;
		int curCnt = 0;
		
		for(int i = 0 ; i < s.length(); i++){
			curCnt ++;
			
			if( (i+1 >= s.length()) || s.charAt(i) != s.charAt(i+1)){
				totalCnt += 1 + String.valueOf(curCnt).length();
				curCnt=0;
			}
			
		}
		
		return totalCnt;
		
	}
	
	public static boolean OneCharAwayAtt2(String s, String t){
		
		if(s == null || t == null || s.length() == 0 || t.length() == 0){
			return false;
		}
		
		if(s.length() == t.length()){
			return IsReplaceAtt2(s, t);
		}else if (s.length() - t.length() == 1){
			return IsOneCharAtt2(s, t);
		}else if (t.length() - s.length() == 1){
			return IsOneCharAtt2(t, s);
		}
		return false;
	}
	
	private static boolean IsReplaceAtt2(String s, String t){
		
		boolean isDiffFound = false;
		for(int i = 0; i < s.length(); i++){
			
			if(s.charAt(i) != t.charAt(i)){
				if(isDiffFound){
					return false;
				}
				isDiffFound = true;
			}
		}
		return true;
	}
	
	
	private static boolean IsOneCharAtt2(String longer, String shorter){
		
		boolean isDiffFound = false;
		for(int i = 0, j = 0; i < shorter.length() && j < longer.length();){
			
			if(shorter.charAt(i) != longer.charAt(j)){
				
				if(isDiffFound){
					return false;
				}
				isDiffFound = true;
				j++;
			}
			else{
				i++;
				j++;
			}
		}
		return true;
	}
	
	
	public  static void main(String args[]) throws Exception{
		
		String data = "abc";
		System.out.println("Is " + data + " palindrome perm? " + isPalindromePermUnicodeAtt2(data));
		data = "ab ,a";
		System.out.println("Is " + data + " palindrome perm? " + isPalindromePermUnicodeAtt2(data));	
		data = "abcc";
		System.out.println("Is " + data + " palindrome perm? " + isPalindromePermUnicodeAtt2(data));
		data = "ab cca";
		System.out.println("Is " + data + " palindrome perm? " + isPalindromePermUnicodeAtt2(data));
		data = "தேரு வருதே";
		System.out.println("Is " + data + " palindrome perm? " + isPalindromePermUnicodeAtt2(data));
		
		String s1 = "car";
		String s2 = "scar";
		System.out.println("Is " + s1 + " and " + s2 + " One Char away? " + OneCharAwayAtt2(s1, s2));
		s2 = "kar";
		System.out.println("Is " + s1 + " and " + s2 + " One Char away? " + OneCharAwayAtt2(s1, s2));
		s2 = "ar";
		System.out.println("Is " + s1 + " and " + s2 + " One Char away? " + OneCharAwayAtt2(s1, s2));
		s2 ="carty";
		System.out.println("Is " + s1 + " and " + s2 + " One Char away? " + OneCharAwayAtt2(s1, s2));
		
	}
}

