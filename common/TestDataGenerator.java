import java.util.*;

public class TestDataGenerator{

	public static Integer[] GetArray(int n, boolean fillWithRandom, int bound){
		Integer[] array = new Integer[n];
		if(fillWithRandom){
			FillWithRandomValues (array, bound);
		}else{
			for(int i = 0; i< n; i++){
				array[i] = i % bound;				
			}
		}
		return array;
	}
	public static Integer[][] GetArray(int dim1, int dim2, boolean fillWithRandom, int bound){
		if(dim1 < 0 || dim2 < 0 || bound < 0){
			return null;
		}
		Integer[][] result = new Integer[dim1][];
		for(int i = 0 ; i < dim1 ; i++){
			result[i] = GetArray(dim2, fillWithRandom, bound);
		}
		return result;
	}
	
	
	public static void FillWithRandomValues(Integer[] array, int bound){
		if(array == null || bound < 1){
			return;
		}
		Random r = new Random();
		for(int i = 0; i< array.length; i++){
			array[i] = r.nextInt(bound);
		}
	}
	
	public static void Shuffle(Integer[] array) {
		Random r = new Random();
		for(int i = 0; i < array.length ; i++){
			int randIndex = r.nextInt((array.length-i) );
			Swap(array, (array.length-i-1) , randIndex);
		
		}
		
	}
	
	public static void PrintMasterList(ArrayList<ArrayList<Node>> masterList){
	
		for(int i = 0; i < masterList.size(); i++){
			System.out.print(String.format("\nPrinting List# %d  : ", i));	
			PrintNodeList(masterList.get(i));
		}
	}
	
	public static void PrintNodeList(ArrayList<Node> list){
		for( int i=0; i < list.size(); i++){
			System.out.print(String.format("%d ",list.get(i).data));
		}
	}
	
	
	public static void MakeRandomValuesNegative(Integer[] array){
		if(array == null)
			return;
		Random r = new Random();	
		for(int i = 0; i< array.length; i++){
			if( (r.nextInt()%2) == 0 ){
				array[i] = -array[i];				
			}
		}	
	}
	public static void MakeRandomValuesNegative(Integer[][] array){
		if(array == null){
			return;
		}
		for(int i = 0; i< array.length; i++){
			MakeRandomValuesNegative(array[i]);
		}
	}
	
	public static<T> void PrintArray(T[] array){
	
		PrintArray(new ArrayList<T>(Arrays.asList(array)));
	}
	
	public static<T> void PrintArray(T[][] array){
		for(int i = 0; i < array.length; i++){
			PrintArray(array[i]);
		}
	}
	
	public static<T> void PrintArray(ArrayList<T> array){
		System.out.println("");
		
		if(array == null)
		{
			System.out.println("Empty array");
			return;
		}
		for (int i = 0; i< array.size(); i++){
			System.out.print(" " + array.get(i));
		}
		
		System.out.println("");
	}
	
	public static void Swap(Integer[] array, int index1, int index2){
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
	public static String[] GetStringArray(){
		return new String[] {"abc", "aaa", "abbc", "bca", "dca", "cab"};
	}
	
	public static void main(String args[]){
		
		Integer[] temp = GetArray( 10, true, 20);
		PrintArray(temp);
		MakeRandomValuesNegative(temp);
		PrintArray(temp);
	}
	
}