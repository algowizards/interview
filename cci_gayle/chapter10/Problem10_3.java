import java.util.*;

public class Problem10_3{
		static int statCounter = 0;
		public static int ModifiedBinarySearchRec(Integer[] array, int p, int r, int data){
			//System.out.println ( " p = " + p + " r= "+ r + " Data = " + data);
			//System.out.println ("Call made. count = " + (++statCounter));
			if( p <= r ){
				int q = (p+r)/2;
				System.out.println ( " q = " + q); 
				if(array[q] == data){
					System.out.println ( "Success!");
					return q;
				}
				
				if( data < array[q] || data > array[r]){ 
					int returnVal  = ModifiedBinarySearchRec(array, p, q-1, data); //search left
					if(data > array[r] && returnVal == -1){
						return ModifiedBinarySearchRec(array, q+1, r, data);	//search right
					}else{
						return returnVal;
					}
				}
				else if(data > array[q] || data < array[p]){ 
					int returnVal  = ModifiedBinarySearchRec(array, q+1, r, data); //search right
					if(data < array[p] && returnVal == -1){
						return ModifiedBinarySearchRec(array, p, q-1, data); //search left
					}else{
						return returnVal;
					}
				}
			
			}
			return -1;
		}
		
		public static int ModifiedBinarySearch(Integer[] array, int data){
			return ModifiedBinarySearchRec(array, 0, array.length-1, data);
		}
		public static void main(String args[]){
			//Integer[] testData = TestDataGenerator.GetArray(10, false, 10);
			//System.out.println("Found at index" + ModifiedBinarySearch(testData, 3));
			Integer[] testData1 = new Integer[]{2,2,2,3,4,2};
			System.out.println("Found at index" + ModifiedBinarySearch(testData1, 3));
		}
}