public class DLLHelper{

	public static void printList(DLLNode root){
	
		while(root!= null){
			System.out.print(root.data + " <=> ");
			root = root.right;
			
		}
		System.out.println( "null");
	
	}
}