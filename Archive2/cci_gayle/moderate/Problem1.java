
//crappy way to do it. f*kin Integer is immutable in java!
// c would hav been a better n cleaner option!
public class Problem1{
	
	public static void Swap(int[] a, int[] b){
		
		a[0] = a[0]-b[0];
		b[0] = b[0]+a[0];
		a[0] = b[0]-a[0];
		//System.out.println("after swap " + "a = " + a + "b = " + b);
	}
	
	public static void main(String args[]){
		int[] a = new int[]{5}; 
		int[] b = new int[]{10};
		System.out.println(" before swap " + "a = " + a[0] + " b = " + b[0]);
		Swap(a,b);
		System.out.println(" after swap " + "a = " + a[0] + " b = " + b[0]);
	}

}