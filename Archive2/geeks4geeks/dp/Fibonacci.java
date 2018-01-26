import java.util.*;

//recursive method, using DP. the optimized version is iterative (more space efficient)
public class Fibonacci {

	private static LinkedHashMap<Long,Long> cache = new LinkedHashMap<Long,Long>();
	
	public static long Fibo(long n) throws Exception{
		if(n < 0){
			throw new Exception("Invalid Input Exception");
		}
		return FiboRec(n);
	}
	
	private static long FiboRec(long n){
		if(n == 0 || n == 1){
			return n;
		}
		if(cache.containsKey(n)){
			return cache.get(n);
		}
		cache.put(n, (FiboRec(n-1) +  FiboRec(n-2)) );
		return cache.get(n);
	}
	
	public static void main(String args[]) throws Exception{
		System.out.println(String.format("Fibonacci of %d is %d ", 0, Fibo(0)));
		System.out.println(String.format("Fibonacci of %d is %d ", 1, Fibo(1)));
		System.out.println(String.format("Fibonacci of %d is %d ", 2, Fibo(2)));
		System.out.println(String.format("Fibonacci of %d is %d ", 100, Fibo(100)));
		System.out.println(String.format("Fibonacci of %d is %d ", -1, Fibo(-1)));
	}

}