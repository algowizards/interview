import java.util.*;

public class Problem10_MergeSort{

	public static void Sort(Integer[] array){
		if (array == null || array.length ==1){
			return ;
		}
		SortRec(array, 0, array.length - 1);
	}
	
	private static void SortRec(Integer[] array, int p, int r){
		if( p < r ){
			int q = (p+r)/2;
			SortRec(array, p, q);
			SortRec(array, q+1, r);
			merge(array, p, q , r );
		}	
		
	}
	private static void merge(Integer[] array, int p, int q, int r){
		
		Integer[] left = new Integer[q-p+1];
		Integer[] right = new Integer[r-(q+1)+1]; //ie, r-q
		
		for(int i = 0; i < left.length; i++){
			left[i] = array[p+i];
		}
		
		for(int i = 0; i < right.length; i++){
			right[i] = array[q+1+i];
		}
		int lp = 0;
		int rp = 0;
		for (int k = p ;  k<=r ; k++){
			if(lp < left.length && rp < right.length){
				if( left[lp] < right[rp] )
				{
					array[k] = left[lp];
					lp++;
				}else{
					array[k] = right[rp];
					rp++;
				}
			}else if( lp < left.length){
				array[k] = left[lp];
				lp++;
			}else{
				array[k] = right[rp];
					rp++;
			}
		}
	}
	
	public static void main(String args[]){
		Integer[] temp = TestDataGenerator.GetArray(10, true, 20);
		Sort(temp);
		TestDataGenerator.PrintArray(temp);
	}

}