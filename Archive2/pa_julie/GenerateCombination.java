public class GenerateCombination{
	public static void main(String args[]){
		RecGenCombination("abc");
	}
	
	public static void RecGenCombination( String input){
		RecGenCombination("", input);
	}
	
	private static void RecGenCombination(String soFar, String remaining){
		if(remaining == null || remaining.equalsIgnoreCase("")){
			System.out.println(soFar);
			return;
		}
		char selectedChar = remaining.charAt(0);
		//String remainingNext = remaining.length() > 1 ? remaining.substring(1) : "";
		String remainingNext = remaining.substring(1) ;
		RecGenCombination(soFar + selectedChar  , remainingNext);
		RecGenCombination(soFar , remainingNext);
	}
}