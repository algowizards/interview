import java.util.*;

public class Problem9_8{

	private static class RepresentNCents{
		static int[] _allowedCoins = new int[]{25, 10, 5, 1};	
		int _cents;
		
		public RepresentNCents(int centsParam){
			_cents = centsParam;
		}
		
		public int GenerateCoinCombination(){
			return GenerateCoinCombination(_cents);
		}
		
		public static int GenerateCoinCombination(int amount){
			System.out.println("Generating combinations for the amount " + amount);
			//not handling 0 or -ve validation here. can add.
			int total = GenerateCoinCombinationRec(new ArrayList<Integer>() , amount, Integer.MAX_VALUE);
			System.out.println("\n Total combinations generated= " + total	);
			return total;
		}		
		
		private static int GenerateCoinCombinationRec( ArrayList<Integer> coinsSoFar, int remainingValue, int prevSel){
			
			if(remainingValue <= 0){ //though < should be exception, assuming that we will never get there
				System.out.print ("\n Generated Combination : ");
				for( int x= 0 ; x < coinsSoFar.size() ; x++)
				{
					System.out.print( coinsSoFar.get(x) + ", ");
				}
				return 1;
			}
			
			ArrayList<Integer> coinChoices = GetPossibleCoinChoices(remainingValue ,prevSel);
			
			int sum = 0;
			for(int k = 0; k < coinChoices.size() ; k++)
			{
				Integer coinValue = coinChoices.get(k);
				/*ArrayList<Integer> tempList = (ArrayList<Integer>) coinsSoFar.clone();
				tempList.add(coinValue);*/
				coinsSoFar.add(coinValue);
				sum+=GenerateCoinCombinationRec(coinsSoFar, remainingValue - coinValue , coinValue);
				coinsSoFar.remove(coinValue);
			}
			return sum;
		}
		
		public static ArrayList<Integer>  GetPossibleCoinChoices(int remainingValue, int prevSel){
			
			ArrayList<Integer> choices = new ArrayList<Integer>();
			for (int i = 0; i<_allowedCoins.length; i++){
				if(_allowedCoins[i] <=prevSel && (remainingValue - _allowedCoins[i] >= 0) ){
					choices.add(new Integer(_allowedCoins[i]));
				}
			}
			return choices;
		}
	
	}
	
	public static void main(String args[]){
		RepresentNCents rep = new RepresentNCents(0);
		rep.GenerateCoinCombination();
	}
}