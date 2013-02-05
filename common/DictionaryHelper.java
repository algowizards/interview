
import java.io.*;
import java.util.*;

public class DictionaryHelper{

	private  static Set<String> Dictionary = new HashSet<String> ();
	
	public static Set<String>  GetDictionary(){
		if(Dictionary.size() == 0)
		{
			LoadDictionary();
		}
		return Dictionary;
	}
	
	public static void LoadDictionary(){
		LoadDictionary("C:\\Users\\KayySean\\Documents\\GitHub\\interview\\common\\dictionary.csv");
	}
	public static void LoadDictionary(String fileName){	
		
		BufferedReader bi = null;
		String input= null;
		try{
			bi = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
			while( (input = bi.readLine()) != null){
				if( input.trim().length() > 0){
					Dictionary.add(input);
				}
			}
			System.out.println(String.format(" Dictionary created with %d words successfully ", Dictionary.size()));
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
		finally{
			try{
				if( bi!= null ) { 
					bi.close();
				}
			}catch (IOException fce){
				fce.printStackTrace();
			}
		}
	}
	
	/* library code. commenting out main to avoid conflict
	public static void main(String args []){
		DictionaryHelper.LoadDictionary();
	}*/
}