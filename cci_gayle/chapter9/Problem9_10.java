import java.util.*;

public class Problem9_10{

	private static class StackBoxes{
		ArrayList<Box> boxes = new ArrayList<Box>();
		int maxHeight = 0;
		int MAX_BOXES = 3;
		
		public int GetMaxHeight(){
			return maxHeight;
		}
		
		public  void GenerateBoxes()
		{
			for (int i = 1 ; i <= MAX_BOXES ; i++){
				boxes.add(new Box(i,i,i));
			}
			/*
			boxes.add(new Box(1,1,1));
			boxes.add(new Box(0,10,10));
			boxes.add(new Box(2,2,2));
			*/
		}
		public void StackBoxes(){
		
			StackBoxesRec(new ArrayList<Box>(), boxes);
			
		}
		
		public void StackBoxesRec(ArrayList<Box> soFar, ArrayList<Box> remaining){
			
			if(remaining.size() <= 0){
				return;
			}
			for ( int i = 0; i< remaining.size(); i++){
				if( CanPlaceBox(soFar, remaining.get(i))){
					Box currentBox = remaining.get(i);
					
					ArrayList<Box> soFarNew =  (ArrayList<Box> ) soFar.clone();
					soFarNew.add(currentBox);
					ArrayList<Box> remainingNew =  (ArrayList<Box> ) remaining.clone();
					remainingNew.remove(currentBox);
					
					int currentHeight = GetHeight(soFarNew);
					System.out.println("Computed current height  = " + currentHeight);
					maxHeight = (currentHeight > maxHeight)? currentHeight : maxHeight;
					StackBoxesRec(soFarNew, remainingNew);
					
				}
				
			}
			
			
			
		
		}
		
		public boolean CanPlaceBox(ArrayList<Box> soFar, Box newBox){
			if(soFar.size() == 0){
				return true;
			}
			Box top = soFar.get (soFar.size() - 1);
			return ( top.Height > newBox.Height && top.Length > newBox.Length && top.Width > newBox.Width);
			
		}
		
		public int GetHeight(ArrayList<Box> boxes){
			if(boxes == null || boxes.size() == 0 ){
				return 0;
			}
			int sum = 0;
			for (int i = 0; i < boxes.size(); i++){
				sum+= boxes.get(i).Height;
			}
			return sum;
		}
		
		
		
	
	}
	
	public static void main(String args[]){
			StackBoxes sb = new StackBoxes();
			sb.GenerateBoxes();
			sb.StackBoxes();
			System.out.println("Max height using boxes = " + sb.GetMaxHeight());
		}
}