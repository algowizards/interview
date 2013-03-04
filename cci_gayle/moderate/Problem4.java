//Max Of Two Numbers Without Comparison
public class Problem4{
	
	public static int MaxOfTwoNumbersWithoutComparison(int a, int b){
		
		int c = a - b;
		int sa = Sign(a);
		int sb = Sign(b);
		int sc = Sign(c);
		
		int ovFlag =   sa ^ sb;
		int invOvFlag =  Flip(ovFlag);
		
		int k = ovFlag * sa  + invOvFlag * sc;
		int invK = Flip(k);
		
		return k * a + invK * b;
	
	}
	
	public static int Sign(int a){
		return Flip( a >> 31 & 0x1);
	
	}
	
	public static int Flip(int a){
		return 1^a;
	}
	
	public static void main(String args[]){
		
		int a = 100;
		int b = 20;
		System.out.println (" Max of " + a + " and " + b +" is " + MaxOfTwoNumbersWithoutComparison(a,b));
		a = -10; b = 10;
		System.out.println (" Max of " + a + " and " + b +" is " + MaxOfTwoNumbersWithoutComparison(a,b));
		a = Integer.MAX_VALUE; b = -10;
		System.out.println (" Max of " + a + " and " + b +" is " + MaxOfTwoNumbersWithoutComparison(a,b));
		a = Integer.MIN_VALUE; b = 10;
		System.out.println (" Max of " + a + " and " + b +" is " + MaxOfTwoNumbersWithoutComparison(a,b));
		a = Integer.MIN_VALUE; b = -10;
		System.out.println (" Max of " + a + " and " + b +" is " + MaxOfTwoNumbersWithoutComparison(a,b));

		
	}
}