import java.util.*;

//m small elements from array of n unsorted elements (using i-th order statistics)
// other solutions: 
// Sort and pickup (nlog n)
// Min Heap 
public class Problem18_6{
		
	public static Integer[] GetMSmallestFromArrayOfNElements(Integer[] array, int m){
		if( m >= array.length || m <= 0){
			return null; //or throw exception
		}
		int mThLargestElementIndex = GetIthOrderStatisticsRec(array, 0, array.length-1, m-1);
		int mThLargestElement = array[mThLargestElementIndex];
		Integer[] result = new Integer[m];
		int j = 0;
		for (int i = 0; i < array.length; i++){
			if(array[i] <= mThLargestElement){
				result[j++] = array[i];
			}
		}
		return result;
	}
	
	public static int GetIthOrderStatisticsRec(Integer[] array, int p, int r, int reqdIndex){
		if(p == r){
			return p;
		}
		else if (p < r){
			int q = Partition(array, p, r);
			if(reqdIndex == q){
				return q; 
			}
			else if (reqdIndex < q){
				return GetIthOrderStatisticsRec(array, p, q-1, reqdIndex);
			
			}else{
				return GetIthOrderStatisticsRec(array, q+1, r, reqdIndex);
			}
		
		}
		return -1;
	}
	
	public static int Partition(Integer[] array, int p, int r){
		if(p <= r){
			
			int x = array[r];
			int j = p-1;
			for (int i= p; i < r; i++){
				if(array[i] < x){
					j++;
					TestDataGenerator.Swap(array, i, j);
				}
			}
			j++;
			TestDataGenerator.Swap(array, r, j);
			return j;
		}
		return -1;
	}
	public static void main(String args[]){
	
		Integer[] array = TestDataGenerator.GetArray(10000000, false, 10000000);
		TestDataGenerator.Shuffle(array);
		Integer[] result = GetMSmallestFromArrayOfNElements(array, 10);
		TestDataGenerator.PrintArray(result);
	}
}