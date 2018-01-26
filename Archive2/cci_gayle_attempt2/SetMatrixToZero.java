public class SetMatrixToZero{
	public static SetMatrixToZero(Integer[][] matrix){
		if(matrix == null){
			return;
		}
		
		int[] zeroRowArray = new int[matrix.length];
		int[] zeroColArray = new int[matrix[0].length];
		
		for(int i = 0 ; i < matrix.length; i++){
			zeroRowArray[i] = 1;
		}
		
		for(int i = 0 ; i < matrix[0].length; i++){
			zeroColArray[i] = 1;
		}
		
		
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				if(matrix[i][j] == 0){
					zeroRowArray[i] = 0;
					zeroColArray[j] = 0;
				}
			}
		}
		
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				if(zeroRowArray[i] == 0 || zeroColArray[j] == 0){
					matrix[i][j] = 0;
				}
			}
		}
	
	}

}