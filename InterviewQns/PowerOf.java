public class PowerOf{
	private static double PowerOfValue(double a, int b){
		if(b == 0)
		{
			return 1;
		}
		double temp = PowerOfValue(a, b/2);
		temp = temp * temp;
		if(b%2 !=0){
			temp = temp * a;
		}
		return temp;
	}
	public static void main(String args[]){
		System.out.println(Pow(5,3));
	}
	
	public static double Pow(int a, int b){
		double argA = a;
		if( b<0 ){
			argA = (double)1/ (double) a;
		}
		
		return PowerOfValue(argA , -b);
	}
}