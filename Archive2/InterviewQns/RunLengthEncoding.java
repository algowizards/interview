public class RunLengthEncoding{
	public static String Encode(String input)throws Exception{
		if(input == null)
			return null;
		int encodedLength = GetEncodedStringLength(input);
		if(encodedLength > input.length()){
			System.out.println("Returning original as enc length:" + encodedLength + "vs input length" + input.length());
			return input;
		}
		return encodeString(input, encodedLength);
	}
	public static int GetEncodedStringLength(String input)throws Exception{
		
		int encodedLength = 0;
		for(int i = 0 ; i < input.length() ; i++){
			char tempChar = input.charAt(i);
			int k = i;
			for( k = i ; input.charAt(k)== tempChar ; k++){
				if(k == input.length()-1){
					k++;
					break;
				}
			}
			System.out.println("BEFORE encodedLength :" + encodedLength);
			encodedLength = encodedLength + (1 + CountDigits(k-i));
			System.out.println("AFTER encodedLength :" + encodedLength);
			i=k;
		}
		return encodedLength;
	}
	
	private static int CountDigits(int n) throws Exception{
		System.out.println("count digits in " + n);
		if(n<0){
			throw new Exception ("Illegal argument");
		}
		int dc = 0;
		while(n > 0 ){
			n = n/10;
			dc++;
		}
		return dc;
	}
	
	private static String encodeString(String inputStr, int encodedLength){
		StringBuilder input = new StringBuilder(inputStr);
		int encoderIndex = -1;
		System.out.println("Processing string: " + input.toString()); 
		for(int i = 0; i < input.length();){
			int k = i;
			System.out.println("Assigning k = " + i);
			char tempChar = input.charAt(k);
			for( k = i ; input.charAt(k)== tempChar ; k++){
				if(k == input.length()-1){
					k++;
					break;
				}
			}
			encoderIndex++;
			input.setCharAt(encoderIndex, input.charAt(i));
			//encoderIndex++;
			
			int charCnt = (k-i);
			System.out.println(" char cnt of "+tempChar +" Is " + charCnt);
			if(charCnt > 1){
				String tempStr = Integer.toString(charCnt);
				
				for(int z = 0 ; z < tempStr.length(); z++){
					encoderIndex++;
					char tempC = tempStr.charAt(z);
					System.out.println("XXX enc index" + encoderIndex);
					input.setCharAt(encoderIndex , tempC);
				}
				
			}
			i = k;
		}
		int ptrWrite = 	encodedLength-1;
		int ptrRead = encoderIndex;
		System.out.println("Before copy over : " +input.toString());
		System.out.println("Ptr write = " + ptrWrite);
		System.out.println("Ptr Read = " + ptrRead);
		while ( ptrWrite >=0 ){
		
			if(ptrRead == encoderIndex && Character.isLetter(input.charAt(ptrRead))){
				input.setCharAt(ptrWrite--, '1');
				input.setCharAt(ptrWrite--, input.charAt(ptrRead));
				ptrRead--;
			}
			else if(
			(ptrRead - 1) >= 0 && Character.isLetter(input.charAt(ptrRead)) && 
			Character.isLetter(input.charAt(ptrRead-1))){
				input.setCharAt(ptrWrite, input.charAt(ptrRead));
				ptrWrite--;ptrRead--;
				input.setCharAt(ptrWrite--, '1');
				input.setCharAt(ptrWrite, input.charAt(ptrRead));
				ptrWrite--;ptrRead--;
			}
			else{
				input.setCharAt(ptrWrite, input.charAt(ptrRead));
				ptrWrite--;ptrRead--;
			}
			System.out.println(input.toString());
			System.out.println("Ptr writexx = " + ptrWrite);
			System.out.println("Ptr Readxx = " + ptrRead);

		}
		for(int i = encodedLength; i < input.length(); i++){
		input.setCharAt(i,'\0');
		}
		return input.toString();
	}
	public static void main (String args[]) throws Exception{
		//System.out.println(Encode("aaaaabbbcccccc"));
		System.out.println(Encode("aaabbc"));
	}
	
}
