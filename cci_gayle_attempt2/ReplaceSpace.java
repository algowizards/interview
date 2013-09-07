public class ReplaceSpace{

	public static void ReplaceSpace(char[] input){
	
		char spaceChar = ' ';
		if(input == null){
			return;
		}
		try{
			//count space
			int spaceCount = 0;
			for(int i = 0; i < input.length; i++){
				if(input[i] == spaceChar){
					spaceCount++;
				}
			}
			
			//compute end of string
			int eos =  input.length + 2 * spaceCount;
			int readIndex = input.length - 1;
			int writeIndex = eos - 1;
			
			while( writeIndex >=0 ){
				if(input[readIndex] == spaceChar){
					input[writeIndex--] = '0';
					input[writeIndex--] = '2';
					input[writeIndex--] = '%';
				
				}else{
				input[writeIndex--] = input[readIndex];
				}
				readIndex --;		
			}
		
		}catch(ArrayIndexOutOfBoundException aoe){
			Console.writeLine(aoe.getStackTrace());
			throw aoe;
		}
	}
}