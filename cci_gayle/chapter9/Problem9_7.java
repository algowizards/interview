
public class Problem9_7{

	private static class PaintFill{
		int[][] canvas;
		
		public PaintFill(){
			canvas = new int[7][7];
		}
		public PaintFill(int[][] canvasParam) throws Exception{
			if(canvasParam == null || canvasParam.length!=canvasParam[0].length){
				throw new Exception ("Only square canvas supporteD");
			}
			canvas = canvasParam;
		}
		
		public void PrintCanvas(){
			if(canvas != null){
				System.out.println("\n\n ------***** Printing Canvas ******----------\n");
				for(int  i=0; i<canvas.length; i++){
				System.out.println("\n");	
					for(int  j=0; j<canvas.length; j++){ //assuming no jagged array
						System.out.print(canvas[i][j] +" " );		
					}
				}
			}
		}
		
		public void GenerateCanvas(){
			int col1 = 1;
			int col2 = 2;		
			for(int  i=0; i<canvas.length; i++){
				for(int  j=0; j<canvas.length; j++){ //assuming no jagged array
					if( i % (canvas.length -1) == 0 ||  j % (canvas.length -1)  == 0){
						canvas[i][j] = col1;
					}else{
						canvas[i][j] = col2;
					}
				}
			}
		}
		
		public void FillWithNewPaint( int x, int y , int newColor){
			FillPaintRecursive(  x, y , canvas[x][y] , newColor); //assuming x,y within bound
		}
		
		public void FillPaintRecursive( int x, int y , int originalColor, int newColor){
			
			if( x < 0 || x >= canvas.length || y < 0 || y >= canvas.length || canvas[x][y] != originalColor)
			{
				return; // outside the boundary of canvas, already processed or bounded by a different color
			}
			canvas[x][y] = newColor;
			FillPaintRecursive( x - 1, y , originalColor, newColor); //top
			FillPaintRecursive( x  + 1, y , originalColor, newColor); //bot
			FillPaintRecursive( x , y - 1, originalColor, newColor); //left 
			FillPaintRecursive( x , y + 1, originalColor, newColor); //right
		}
	}	
	public static void main(String args[]) throws Exception{
		PaintFill paintFill = new PaintFill();
		paintFill.GenerateCanvas();
		paintFill.PrintCanvas();
		paintFill.FillWithNewPaint(5,5,9);
		paintFill.PrintCanvas();
		
		paintFill.FillWithNewPaint(0,0,6);
		paintFill.PrintCanvas();

	}
	
	
}