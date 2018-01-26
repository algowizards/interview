public class FiboEvenSum{

	public static long GetEvenSumOfFibo(int n){
		if(n < 0){
			return 0;
		}
		
		int a = 0;
		int b = 1;
		
		long sum = 0 ;
		for(int i = 0 ; i <=n ; i++){
			
			if(i%2 == 0 ){
				sum = sum + a;
			}
			int temp = b;
			b = b + a;
			a = temp;
			
			//alternatively, 
			// a = a+b; b = a+b; and iterate over n /2, summing up 'a'.
		
		} 
		
		return sum;
	}

}