
public class Problem10_BubbleSort{

	public static void Sort(Integer[] array){
		if (array == null || array.length ==1){
			return;
		}
		
		for(int i = array.length-2; i >= 0; i--){
			for(int j = 0; j<= i; j++){
				if(array[j] > array[j+1]){
					swap(array, j, j+1);
				}
			}
		}
	}
	
	public static void swap(Integer[] array, int index1, int index2){
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}	
	
	public static void main(String args[]){
		Integer[] temp = TestDataGenerator.GetArray( 10, true, 20);
		TestDataGenerator.PrintArray(temp);
		Sort(temp);
		TestDataGenerator.PrintArray(temp);
	}

}