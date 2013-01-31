
import java.util.*;

public class PermuCheck{
	
	public static void main(String args[]){
		String string1 = "TestString1"; 
		String string2 = "StringTest122";
		String string3 = "StringTest1";
	
		System.out.println("string1 is a permutation of string2? " + permuCheck(string1, string2));
		System.out.println("string1 is a permutation of string2? " + permuCheck(string1, string3));

	}

//checks if the strings are perms of each other. this IS case sensitive.

	public static boolean permuCheck(String string1, String string2)
	{
		if(string1 == null || string2 == null){
			return false;	
		}
		LinkedHashMap<Character,Integer> map = new LinkedHashMap<Character,Integer>();
		//build a hashMap with string 1
		for(int i = 0; i< string1.length(); i++)
		{
			Integer mapItem = map.get(string1.charAt(i));
			if(mapItem != null)
			{
				map.put(string1.charAt(i), mapItem+1);
			}else
			{
				map.put(string1.charAt(i),1);
			}
		}
		//hashmap built. now check string 2
		for (int i = 0; i < string2.length() ;i++)
		{
				
			Integer mapItem = map.get(string2.charAt(i));
			if(mapItem == null || mapItem == 0)
			{
				return false;
			}
			else
			{
				map.put (string2.charAt(i), mapItem-1);
			}
		}
		//the map might have leftovers. (string 2 is a substring of string 1)	
		for(Map.Entry<Character, Integer> entry: map.entrySet())
		{
			if(entry.getValue() > 0){
				return false;
			}
		}
		return true;	
	}

}
