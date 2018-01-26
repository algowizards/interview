import java.util.*;

public class LastAttempt_List{

	public static void removeDups(Node<Integer> head){
		
		if(head == null){
			return;
		}
		
		Node<Integer> p = head;
		Node<Integer> q = p.next;
		
		HashSet<Integer> table = new HashSet<Integer>();
		table.add(p.data);
		
		while(q != null){
			if(table.contains(q.data)){
				p.next = q.next;
				q = p.next;
			}else{
				table.add(q.data);
				p = q;
				q = q.next;
			}
		}
	}
	
	public static void removeDupsNoStorage(Node<Integer> head){
	
		if(head == null){
			return;
		}
		
		while(head != null){
			
			Node<Integer> p = head;
			Node<Integer> q = head.next;
			//review: nitpik: q is not needed. can use p.next directly.
			while(q != null){
				if(q.data == head.data){
					p.next = q.next;
					q = p.next;
				}else{
					p = q;
					q = q.next;
				}
			}
			
			head = head.next;
		}			
	}
	
	//review: checked OK
	public static Node<Integer> KthFromLast(Node<Integer> head, int k){
	
		if(head == null || k<0 ){
			return head;
		}
		
		Node<Integer> fp = head;
		int i = 0;
		while( fp != head && i<k ){
			fp = fp.next;
			i++;
		}
		if( fp == null)
		{
			return fp;
		}
		
		Node<Integer> sp = head;
		
		while( fp.next != null){
			fp = fp.next;
			sp = sp.next;
		}
		return sp;
	}
	
	//review: checked OK
	public static Node<Integer> Partition(Node<Integer> head, int x){
	
		if(head == null){
			return head;
		}
		
		Node<Integer> lh = null, lt = null, rh = null, rt = null;
		
		while(head != null){
			
			//split the node
			Node<Integer> t = head;
			head = head.next;
			t.next = null;
			
			//add to the right list
			
			if( t.data < x){
				
				if(lt == null){
					lh = lt = t;
				}else{
					lt.next = t;
					lt = t;
				}
				
			} else if (t.data > x){
			
				if(rt == null){
					rh = rt = t;
				}
				else{
					rt.next = t;
					rt = t;
				}
			}else{ //equal to x. 
				
				if(rh == null){
					rh = rt = t;
				}else{
					t.next = rh;
					rh = t;
				}
			}
		}
		
		if(lt == null){
			return rh;
		}
		
		lt.next = rh;
		return lh;
	}
	
	//review: checked OK
	public Node<Integer> reverseList(Node<Integer> head){
		/* redundant null check */
		if(head == null){
			return head;
		}
		
		Node<Integer> p = null;
		Node<Integer> q = head;
		
		while( q != null){
			
			Node<Integer> t = q.next;
			q.next = p;
			p = q;
			q = t;
		}
		
		return p;
	}

	
	public Node<Integer> MergeSortedLists(Node<Integer> h1, Node<Integer> h2){
		
		if(h1 == null){
			return h2;
		}else if (h2 == null){
			return h1;
		}
		
		Node<Integer> mh = null, mt = null;	
		
		while(h1 != null && h2 != null){
			
			Node<Integer> t;
			if(h1.data <= h2.data){
				t = h1;
				h1 = h1.next;
				t.next = null;
			}else{
				t =  h2;
				h2 = h2.next;
				t.next = null;
			}
			
			if(mh == null){
				mh = mt = t;
			}else{
				mt.next = t;
				mt = t;
			}
		}
		
		Node<Integer> rem = (h1 == null) ? h2 : h1;
		mt.next = rem;
		
		return mh;
	}
	
	// 1->2->3 + 1->2 = 2-4->3. Can also add a wrapper with just 2 param and make this internal
	//review: OK
	public Node<Integer> sumListInRevOrder(Node<Integer> n1, Node<Integer> n2, int carry){
		
		if(n1 == null && n2 == null && carry == 0){
			return null;
		}
		
		int sum = carry;
		
		if( n1 != null){
			sum+= n1.data;
		}
		
		if( n2 != null){
			sum+= n2.data;
		}
		
		Node<Integer> sumDigitNode = new Node<Integer>(sum %10);
		Node<Integer> remSum = sumListInRevOrder( (n1 != null) ? n1.next: null, (n2 != null)? n2.next: null, (sum >= 10) ? 1: 0);
		
		sumDigitNode.next = remSum;
		
		return sumDigitNode;
		
	}
	
	//review: OK
	public static Node<Integer> SumNodesForward(Node<Integer> n1, Node<Integer> n2){
		
		int l1 = Length(n1);
		int l2 = Length(n2);
		
		if(l1 >= l2){
			n2 = pad(n2, l1 - l2);
		}else{
			n1 = pad(n1, l2 - l1);
		}
		
		SumResult res = SumNodesForwardRec(n1, n2);
		Node<Integer> list = res.sumList;
		
		if(res.carry > 0){
			list = addToHead(list, new Node<Integer>(res.carry));
		}
		
		return list;
		
	}
	
	// review: OK
	public static SumResult SumNodesForwardRec(Node<Integer> n1, Node<Integer> n2){
		if(n1 == null && n2 == null){
			return new SumResult(null, 0);
		}
		
		SumResult res = SumNodesForwardRec( n1.next, n2.next);
		int curSum = res.carry + n1.data + n2.data;
		
		Node<Integer> list = addToHead(res.sumList, new Node<Integer>(curSum %10) );
		
		return new SumResult(list, ( (curSum >= 10) ? 1: 0) );
	}
	
	private static Node<Integer> addToHead(Node<Integer> head, Node<Integer> newNode){
		
		if(head == null){
			return newNode;
		}
		
		newNode.next = head;
		return newNode;
	}
	
	private static Node<Integer> pad(Node<Integer> list, int count){
	
		while(count > 0){
			list = addToHead(list, new Node<Integer>(0));
			count--;
		}
		
		return list;
	}

	private static int Length(Node<Integer> head){
		int count = 0;
		
		while(head != null){
			count++;
			head = head.next;
		}
		
		return count;
	}
	
	//review: OK
	public static Node<Integer> Intersect(Node<Integer> l1, Node<Integer> l2){
	
		if(l1 == null || l2 == null){
			return null;
		}
		
		int length1 = Length(l1);
		int length2 = Length(l2);
		
		Node<Integer> longer = (length1 >= length2) ? l1 : l2;
		Node<Integer> shorter = (length1 >= length2) ? l2 : l1;
		
		for(int i = 0; i < Math.abs(length1-length2) ; i++){
			longer = longer.next;
		}
		
		while( longer != null && longer != shorter){
			longer = longer.next;
			shorter = shorter.next;
		}
		
		return longer;
	}
	
	//review: OK
	public static boolean IsPalindrome(Node<Integer> head ){
		
		if(head == null){
			return false;
		}
		
		Node<Integer> fast = head;
		Node<Integer> slow = head;
		
		java.util.Stack<Integer> s = new java.util.Stack<Integer>();
		
		while(fast != null && fast.next != null){
			
			s.push(slow.data);
			
			fast = fast.next.next;
			slow = slow.next;
		}
		
		if(fast != null){ //odd
			slow = slow.next; //skip mid element
		}
	
		while(!s.isEmpty()){
			if( slow.data != s.pop()){
				return false;
			}
			slow = slow.next;
		}
		
		return true;
	}
	
}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              