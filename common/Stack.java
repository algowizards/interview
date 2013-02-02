import java.util.*;

public class Stack{
	ArrayList<Integer> _stack;
	int size;
	//int top = -1;

	public Stack(int stackSize){
		_stack  = new ArrayList<Integer> ();
		size = stackSize;
	}
	
	public void Push(Integer data) throws Exception{
	
		if(_stack.size() < size){
			_stack.add(data);
			//top++;
			return;
		}
		throw new Exception ("Stack overflow");
	}
	
	public Integer Pop()throws Exception{
	
		if(_stack.size() > 0){
			return _stack.remove(_stack.size() - 1);
		}
		throw new Exception ("Stack underflow");
	}
	
	public Integer Peek() throws Exception{
	
		if(_stack.size() > 0){
			return _stack.get(_stack.size() - 1);
		}
		throw new Exception ("Stack underflow");
	}

	public static void main(String args[]){
		try{
		
			Stack s = new Stack(2);
			s.Push(new Integer(1));
			s.Push(new Integer(2));
			System.out.println( String.format(" Peek  %d" , s.Peek()));
			System.out.println( String.format(" Pop  %d" , s.Pop()));
			System.out.println( String.format(" Pop  %d" , s.Pop()));
			
			/*
		
			//this will throw overflow exception
			s.Push(2);
			s.Push(1);
			s.Push(3);
			
			//this will throw underflow excpetion
			s.Pop();
			s.Pop();
			s.Pop(); 
			
			*/
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
