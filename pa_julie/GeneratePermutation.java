public class GeneratePermutation
{
	public static void main(String args[]){
		Permute("eat");
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
			String nextSoFar = soFar + remaining.charAt(i);
			String nextRemaining = remaining.substring(0, i) + remaining.substring(i+1);
			RecPermute(nextSoFar, nextRemaining);
		}
		
	}
}