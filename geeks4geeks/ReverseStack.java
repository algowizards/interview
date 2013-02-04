import java.util.*;

public class ReverseStack{
	Stack<Integer> s = new Stack<Integer>();
	
	public void GenerateStack(int n){
		for (int i = n ; i > 0 ; i--){
			s.push(i);
		}
	}
	
	public void ReverseStackRec(){
		if(s.empty()){
			return;
		}
		int temp = s.pop();
		ReverseStackRec();
		InsertAtBottomRec( temp);
	
	}
	
	private void InsertAtBottomRec(int data){
		if(s.empty()){
			s.push(data);
		} else{
			int temp = s.pop();
			InsertAtBottomRec ( data);
			s.push(temp);
		}
	
	}
	
	public void PrintStackRec(){
		if(s.empty()){
			System.out.println ("null");
			return;
		}
		int temp = s.pop();
		System.out.println (temp);
		PrintStackRec();
		s.push(temp);
	}
	
	public static void main(String args[]){
		ReverseStack rs = new ReverseStack();
		rs.GenerateStack(4);
		rs.PrintStackRec();
		rs.ReverseStackRec();
		rs.PrintStackRec();
	}

}