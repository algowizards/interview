public class Problem10_1{

	public static void MergeArrays(Integer[] A, Integer[] B, int validElementsInA){
	
		int i = validElementsInA - 1;
		int j = B.length -1;
		for(int k = validElementsInA + B.length -1 ; k>=0; k--){
			if( i >=0 && j >=0 ){
				if(A[i] > B[j]){
					A[k] = A[i];
					i--;
				}else{
					A[k] = B[j];
					j--;
				}
			}
			else if (i >=0){
				A[k] = A[i];
				i--;
			}else{
				A[k] = B[j];
				j--;
			}
		}
	}
	public static void main(String args[]){
		Integer[] A = TestDataGenerator.GetArray(10, false, 20);
		Integer[] B = TestDataGenerator.GetArray(5, false, 20);
		TestDataGenerator.PrintArray(A);
		MergeArrays(A,B,5);
		TestDataGenerator.PrintArray(A);
	}
}
