public class PowerOf{
	public static int PowerOfValue(int a, int b){
		if(b == 0)
		{
			return 1;
		}
		int temp = PowerOfValue(a, b/2);
		temp = temp * temp;
		if(b%2 !=0){
			temp = temp * a;
		}
		return temp;
	}
	public static void main(String args[]){
		System.out.println(PowerOfValue(3,0));
	}
}