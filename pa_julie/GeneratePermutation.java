public class GeneratePermutation
{
	public static void main(String args[]){
		Permute("apple");
	}
	
	public static void Permute (String input){
		RecPermute("", input);
	}
	
	private static void RecPermute(String soFar, String remaining){
		
		if(remaining == null || remaining.equalsIgnoreCase("")){
			System.out.println(soFar);
			return;
		}
		for(int i = 0; i < remaining.length(); i++){
			//to eliminate duplicates on repeating chars. like for example, 2 p-s in apple
			//logic: when we are at i, if the char was seen in 0 to i-1 space, it would have already been expanded. so ignore.
			if(remaining.substring(0, i).indexOf(remaining.charAt(i))!= -1){
				continue;
			}
			String nextSoFar = soFar + remaining.charAt(i);
			String nextRemaining = remaining.substring(0, i) + remaining.substring(i+1);
			RecPermute(nextSoFar, nextRemaining);
		}
		
	}
}