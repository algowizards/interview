import java.util.*;
public class Problem9_6{

	private static class GenerateParanthesis{
		
		public static void  GenerateAllParanthesis(int n){
			if(n < 0){
				return;
			}
			//can use a string buffer to optimize
			String paranthesisSet = "";
			for (int i = 0 ; i < n ; i++){
				paranthesisSet+="()";
			}
			HashSet<String> combinations = new HashSet<String>();
			RecGenerateAllParenthesis("", paranthesisSet, combinations);
			
			
		}
		
		private static  void RecGenerateAllParenthesis(String soFar, String remaining, HashSet<String> combinations){
			if(remaining == null || remaining.equalsIgnoreCase("")){
				if(!combinations.contains(soFar)){
					System.out.println(soFar);
					combinations.add(soFar);
				}
			}
			for(int i=0; i < remaining.length() ; i++){
				if(IsValidSequence(soFar + remaining.charAt(i))){
					RecGenerateAllParenthesis(soFar + remaining.charAt(i), remaining.substring(0,i) + remaining.substring(i+1), combinations);
				}
			}
		
		}
		private static boolean IsValidSequence(String input){
			
			int openCount = 0; 
			int closeCount = 0;
			for(int i = 0; i <input.length(); i++){
				//safely assuming that input has open or close paranthesis only
				int discard = ( input.charAt(i) == '(' ) ? openCount++ : closeCount++; 
				if(closeCount > openCount)
					return false;
			}
			return true;
		}
		
	}
	public static void main(String args[]){
		GenerateParanthesis.GenerateAllParanthesis(3);
	}
}