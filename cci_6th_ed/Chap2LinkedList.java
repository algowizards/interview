import java.util.*;

public class Chap2LinkedList
{
	//efficient in time, O(N), but takes O(N) space
	public static void Q1RemoveDups(Node<Integer> head){
	
		if(head == null){
			return;
		}
		
		HashSet<Integer> table	=  new HashSet<Integer>();
		table.add(head.data);
		
		while(head.next != null){
			if(table.contains(head.next.data)){
				head.next = head.next.next;
			}
			else {
				table.add(head.next.data);
				head = head.next;
			}
		}
	}
	
	//ineffecient in time, O(N^2) algo, but no additional space
	public static void Q1RemoveDupsNoBuffer(Node<Integer> head){
	
		if(head == null){
			return;
		}
		
		for(Node ptr1 = head; ptr1!=null; ptr1 = ptr1.next){
			for(Node ptr2 = ptr1; ptr2.next!=null;){
				if(ptr2.next.data== ptr1.data){
					ptr2.next = ptr2.next.next;
				}else{
					ptr2 = ptr2.next;
				}
			}
		}
	}
	
	
	public static Node<Integer> GetKthToTheLast(Node<Integer> head, int k){
		
		if(head == null || k < 0 ){
			return null;
		}
		Node<Integer> fast = head;
		Node<Integer> slow = head;
		int cnt = 1;
		while(fast != null && fast.next!=null && cnt != k){
			fast = fast.next;
			cnt++;
		}
		if( cnt != k ){
			return null; //not enough elements
		}
		
		while(fast.next != null){
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}
	
	
	public static DeleteMiddleNode(Node<Integer> delNode){
		
		Node<Integer> savedParent = null;
		//copy over next node to current node iteratively. this technically "erases" the delNode 
		while(delNode.next != null){
			
			delNode.data = delNode.next.data;
			savedParent = delNode;
			delNode = delNode.next;
		}
		//delete the last node as 
		savedParent.next = null;
	}
	
	public static partition(Node<Integer> head, Integer k){
		
		Node<Integer> highListHead = null;
		Node<Integer> lowListHead = null;
		
		Node<Integer> highListTail = null;
		Node<Integer> lowListTail = null;

		Node<Integer> cur = head;
		while( cur != null ){

			//separate out the node
			Node<Integer> splitNode = head;
			head = head.next;
			splitNode.next = null;
		
			if(splitNode.data < k){
				
				if(lowListTail == null){
						lowListHead = lowListTail = splitNode;
				}else{
					lowListTail.next = splitNode;
					lowListTail = splitNode;
				}
				
			}else if(splitNode.data == k){  //add it to the head of highList 
			
				if(highListHead == null){
					highListHead = highListTail = splitNode;
				}else{
					splitNode.next = highListHead;
					highListHead = splitNode;
				}
			
			}else{ // data > k/ add it to the tail of highList
			
				if(highListHead == null){
					highListHead = highListTail = splitNode;
				}else{
					highListTail.next = splitNode;
					highListTail = splitNode;
				}
			}
		}
		
		//now merge the two lists
		lowListTail.next = highListHead;
		return lowListHead;
	}
	
	// digits are in reverse order. e.g.: 123 is written as 3->2->1
	public static Node<Integer> SumList(Node<Integer> num1, Node<Integer> num2){
		
		if(num1== null){
			return num2;
		}
		if num2 == null){
			return num1;
		}
		
		int carry = 0;
		Node<Integer> sumHead = null;
		Node<Integer> sumTail = null;
		
		while(num1 != null || num2 != null){
			Integer n1 = (num1 != null)? num1.data: 0;
			Integer n2 = (num2 != null)? num2.data: 0;
			
			int sum = n1+n2+carry;
			Node<Integer> sumNode = new Node<Integer>(sum%10);
			carry = sum/10;
			
			if(sumHead == null){
				sumHead = sumNode;
				sumTail = sumNode;
			}else{
				sumTail.next = sumNode;
				sumTail = sumNode;
			}
			
			if(num1!=null){
				num1 = num1.next;
			}
			if(num2!=null){
				num2= num2.next;
			}
			
		}
		return sumHead;
	}
	
	
	// digits are in natural order. e.g.: 123 is written as 1->2->3
	//Note: this code can also be written recursively. 
	public static Node<Integer> SumList(Node<Integer> num1, Node<Integer> num2){
		
		if(num1== null){
			return num2;
		}
		if num2 == null){
			return num1;
		}
		
		Stack<Integer> n1Stack = new Stack<Integer>();
		Stack<Integer> n2Stack = new Stack<Integer>();
		
		while(num1 != null || num2 != null){
			
			if( num1 != null){
				n1Stack.push(num1.data);
				num1 = num1.next;
			}
			if( num2 != null){
				n2Stack.push(num2.data);
				num2 = num2.next;
			}
		}
		// now we have all digits in stack . we need to start adding the digits in right order
		int carry = 0;
		Node<Integer> sumHead = null;
		while(!n1Stack.empty() || !n2Stack.empty()){
			
			int n1=0;
			int n2 = 0;
			if(!n1Stack.empty()){
				n1 = n1Stack.pop();
			}
			
			if(!n2Stack.empty()){
				n2 = n2Stack.pop();
			}

			int sum = n1+n2+carry;
			Node<Integer> sumNode = new Node<Integer>(sum%10);
			carry = sum/10;
			
			if(sumHead == null){
				sumHead = sumNode;

			}else{
				sumNode.next = sumHead;
				sumHead = sumNode;
			}
			
		}
		return sumHead;
	}
	
	public static boolean IsListAPalindrome(Node<Character> head){
		
		if(head == null){
			return false;
		}
		
		Node<Character> fastPtr = head;
		Node<Character> slowPtr = head;
		
		Stack<Character> stack = new Stack<Character>();
		while( fastPtr!=null && fastPtr.next !=null ){
			fastPtr = fastPtr.next.next;
			stack.push(slowPtr.data);
			slowPtr = slowPtr.next;
		}
		// for odd length palindrome, we need to skip the middle char.
		// in odd length palindromes, the fast ptr jumps from 1,3,5.. last non-null character whereas in even length pal, it ends at null.
		if(fastPtr != null){
			stack.pop();
		}
		while(!stack.empty){
			if(stack.pop != lowPtr.data){
				return false;
			}
			slowPtr = slowPtr.next;
		}
		return true;
	}
	
	public static Node<Integer> Intersection(Node<Integer> head1, Node<Integer> head2){
		
		int l1 = FindLength(head1);
		int l2 = FindLength(head2);
		
		if(l1>l2){
			for(int i = 0; i < l1-l2; i++){
				head1 = head1.next;
			}
		}else if (l2 > l1){
			for(int i = 0; i < l2-l1; i++){
				head2 = head2.next;
			}
		}
		//now both lists are equidistant from the end
		while( head1.next != null ){
			if(head1 == head2){
				return head1;
			}
			head1 = head1.next;
			head2 = head2.next;
		}		
	}
	
	private int FindLength(Node<Integer> head){
		int count = 0;
		while( head != null){
			head = head->next;
			count++;
		}
		return count;
	}
	
	
	
	
}