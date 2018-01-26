public class Problem3{
	
	public static int CountTrailingZerosSubOptimal( int n){
		
		int count = 0;
		for(int i=5; i <= n ; i+=5){
			count = count + CountFiveFactors(i);
		}
		return count;
	}
	
	public static int CountFiveFactors(int n){
		int count = 0;
		while( (n > 0) && (n%5 == 0) ){
			count++;
			n = n/5;
		}
		return count;
	}
	
	//from crackin the coding interview soln
	public static int CountTrailingZerosOptimal( int n){
		
		int count = 0;
		for(int i=5; n /i > 0 ; i*=5){
			count = count + n/i;
		}
		return count;
	}
	
	
	public static void main(String args[]){
		
		int n  = 1000;
		
		System.out.println (" (SubOpt) Number of trailing zeros in " + n + " factorial is : " +
		CountTrailingZerosSubOptimal(n));
		
		System.out.println (" (Opt) Number of trailing zeros in " + n + " factorial is : " +
		CountTrailingZerosOptimal(n));

		n = Integer.MAX_VALUE;
		
		
		System.out.println (" (Opt) Number of trailing zeros in " + n + " factorial is : " +
		CountTrailingZerosOptimal(n));
		
		//this one goes on forever!
		System.out.println (" (SubOpt) Number of trailing zeros in " + n + " factorial is : " +
		CountTrailingZerosSubOptimal(n));


		
		
	}

	
}