
//problem stmt: implement 3 stacks using a single array
public class Problem3_1{
	
	private static class MultiStack{
		int STACK_COUNT = 3;
		int[] top;
		int[] stack;
		
		public MultiStack(int stackSize){
			
			stack = new int[stackSize];
			top = new int[STACK_COUNT];
			for(int i = 0; i < STACK_COUNT; i++){
				top[i] = getStackStartPosition(i) - 1 ;
			}
		}

		public void Push(int data, int stackIndex)throws Exception{
			
			if(top[stackIndex] + 1   >= getStackStartPosition(stackIndex + 1)){
				throw new Exception("Stack overflow");
			}
			top[stackIndex]++;
			stack[top[stackIndex]] = data;
		}
		
		public int Pop(int stackIndex)throws Exception{
			if(top[stackIndex] <= getStackStartPosition(stackIndex) - 1 ){
				throw new Exception( "Stack underflow");
			}			
			int temp = stack[top[stackIndex]];
			top[stackIndex]--;
			return temp;
		}
		
		private int getStackStartPosition(int stackIndex){
			return (stackIndex * stack.length)/STACK_COUNT ;
		}
	
	}

	public static void main(String args[]) throws Exception{
	
		MultiStack m = new MultiStack(6);
		
		//stack 3
		
		m.Push(3,2); //push 3 in 3rd stack
		m.Push(33,2); //push 3 in 3rd stack
		//throws stack full exception 
		//m.Push(3,2); //push 3 in 3rd stack
		
		System.out.println(m.Pop(2));
		System.out.println(m.Pop(2));
		//throws stack empty exception 
		//System.out.println(m.Pop(2));
		

		//stack 2
		
		m.Push(1,1); 
		m.Push(11,1); 
		//throws stack full exception 
		//m.Push(1,1); 
		
		System.out.println(m.Pop(1));
		System.out.println(m.Pop(1));
		//throws stack empty exception 
		//System.out.println(m.Pop(1));
		
		
		//stack 1
		
		m.Push(0,0);
		m.Push(0,0); 
		//throws stack full exception 
		//m.Push(0,0); 
		
		System.out.println(m.Pop(0));
		System.out.println(m.Pop(0));
		//throws stack empty exception 
		//System.out.println(m.Pop(0));
		
	}
	
}