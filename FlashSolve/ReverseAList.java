public class ReverseAList{
	
	public void ReverseRec(Node root, Node reversedRoot){
		if(root == null){
			return;
		}
		
		Node remainingList = root.next;
		root.next = null;
		
		if(reversedRoot == null ){
			reversedRoot = root;
		}else{
			reversedRoot.next = root;
		}
		
		ReverseRec(remainingList, reversedRoot);
	}
	public Node Reverse(Node root){
		Node reverse = null;
		ReverseRec(root, reverse);
		return reverse;
	}
	
	public Node ReverseNonRec(Node root){
		if(root == null){
			return null;
		}
		Node reversed = null;
		Node current = root;
		while(current != null){
			
			Node temp = current;
			current = current.next;
			temp.next = null;
			
			if(reversed == null){
				reversed = temp;
			}else{
				temp.next = reversed;
				reversed = temp;
			}
		}
		
	}
}