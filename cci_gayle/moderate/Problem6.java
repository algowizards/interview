public class Problem6{
	
	public static Result GetMinReqdArrayToSort(Integer[] array){
		
		if(array == null)
			return null;
		
		int startIndex = 0;
		int i;
		for(i =0;  i < array.length-1; i++){
			if(array[i] > array[i+1])
				break;
		}
		startIndex = i;
		int j;
		for(j = array.length-1; j >0; j--){
			if(array[j] < array[j-1])
				break;
		}
		
		int endIndex = j;
		
		if(startIndex == array.length-1 && endIndex==0){
		System.out.println("No sorting required");
			return new Result(array.length-1,array.length-1);
		}
		
		//see if there are smaller elements to the right of startIdnex
		int smallIndex = startIndex;
		for (i = startIndex; i < array.length; i++){
			if(array[i] < array[smallIndex])
				smallIndex = i;
		}
		
		//see if there are larger elements to the left of endIndex
		int largeIndex = endIndex;
		for (i = endIndex; i >=0; i--){
			if(array[i] > array[largeIndex])
				largeIndex = i;
		}
		
		int smallElement = array[smallIndex];
		int k;		
		for(k = startIndex; k >=0; k--){
			if(array[k] < smallElement){
				break;
			}
		}
		startIndex = k+1;
		
		int l;	
		int largeElement = array[largeIndex];
		for(l = endIndex; l < array.length; l++){
			if(array[l] > largeElement){
				break;
			}
		}
		endIndex = l-1;
		return new Result(startIndex, endIndex);
	
	}
	
	public static void main(String args[]){
		
		//Integer[] temp = TestDataGenerator.GetArray(10, true , 20);
		
		Integer[] temp = new Integer[]{1, 2, 3, 5, 4, 6, 17, 8, 10, 9, 2};
		TestDataGenerator.PrintArray(temp);
		Result r = GetMinReqdArrayToSort(temp);
		System.out.println("Start index = " + r.startIndex + " End Index = " + r.endIndex);
		
		
		temp = new Integer[]{9, 2, 4, 5, 4, 6, 7, 8, 10, 11};
		TestDataGenerator.PrintArray(temp);
		r = GetMinReqdArrayToSort(temp);
		System.out.println("Start index = " + r.startIndex + " End Index = " + r.endIndex);
		
		temp = new Integer[]{9, 8, 7, 6, 4};
		TestDataGenerator.PrintArray(temp);
		r = GetMinReqdArrayToSort(temp);
		System.out.println("Start index = " + r.startIndex + " End Index = " + r.endIndex);

		temp = TestDataGenerator.GetArray(10, false , 20);
		TestDataGenerator.PrintArray(temp);
		r = GetMinReqdArrayToSort(temp);
		System.out.println("Start index = " + r.startIndex + " End Index = " + r.endIndex);
		
		temp = new Integer[]{9};
		TestDataGenerator.PrintArray(temp);
		r = GetMinReqdArrayToSort(temp);
		System.out.println("Start index = " + r.startIndex + " End Index = " + r.endIndex);
		

		
		
		
	}

	
	
	static class Result{
		int startIndex;
		int endIndex;
		
		public Result(int s, int e){
			startIndex = s;
			endIndex = e;
		}
	
		
	}
}