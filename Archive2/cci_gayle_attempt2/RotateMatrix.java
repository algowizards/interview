public class RotateMatrix{
	public static void RotateMatrix(int[][] matrix){
	
		if(matrix == null || matrix.length  == 1 ){
			return;
		}
		RotateMatrixRec(matrix, 0, 0, matrix.length -1, matrix.length -1 );
	}
	public static void RotateMatrixRec(int[][] matrix, startRow, startCol, endRow, endCol){
		
		if(startRow >= endRow){  // terminal condition
			return;
		}
		
		for(int i = startCol; j = endRow;  i < endCol-1 ; i++ , j--){
			int temp  = matrix[startRow][i];
			matrix[startRow][i] = matrix[j][startCol];	
			matrix[j][startCol] = matrix[endRow][j];
			matrix[endRow][j] = matrix[i][endCol];
			matrix[i][endCol] = temp;
		}
	
		//recursively call for submatrix
		RotateMatrixRec(startRow+1, startCol +1, endRow -1 , endCol - 1);
		
	}
}