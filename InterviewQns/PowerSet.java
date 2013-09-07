import java.util.*;

public class PowerSet{

	public static Set<String> GetPowerSet(String input){
		return PowerSetRec(input);
		
	}
	public static HashSet<String> PowerSetRec(String input){
		
		if(input == null || input.length() == 0){
			HashSet<String> result = new HashSet<String>();
			result.add("."); //. to print visible content for null set! :)
			return result;
		}	
		
		char removed = input.charAt(0);
		
		HashSet<String> result = PowerSetRec(input.substring(1));
		HashSet<String> clone = new HashSet<String>();
		
		for(String s:result){
			clone.add( removed + s);
		}
		result.addAll(clone);
		return result;
	}
	
	public static void main(String args[]){
	
		Set<String> res = GetPowerSet("SeanK");
		for(String s: res){
			System.out.println(s);
		}
		System.out.println("Powerset size = " + res.size());
	}
	
}