import java.util.*;

public class MedianOfInfiniteNumbers{
	private PriorityQueue<Integer> minHeap, maxHeap;
	
	public MedianOfInfiniteNumbers(){
		minHeap = new PriorityQueue<Integer>(10);
		maxHeap = new PriorityQueue<Integer>(10, new MaxHeapComparator());
	}

	public void AddNumber(int n){
		
		if(minHeap.peek() != null  && n >= minHeap.peek()){
			minHeap.offer(n);
		}else{
			maxHeap.offer(n);
		}
		//the new element is in the right heap. now balance heaps.
		if (minHeap.size() > maxHeap.size()){
			maxHeap.offer(minHeap.poll());
		}else if(maxHeap.size() - minHeap.size() > 1){
			minHeap.offer(maxHeap.poll());
		}
		
	}
	
	public int GetMedian(){
		if(maxHeap.peek() == null)
			return Integer.MIN_VALUE;
		return maxHeap.peek();
	}

	public static void main(String args[]){
		
		MedianOfInfiniteNumbers moin = new MedianOfInfiniteNumbers();
		moin.AddNumber(1);
		moin.AddNumber(2);
		moin.AddNumber(3);
		moin.AddNumber(4);
		System.out.println("Median so far = " + moin.GetMedian());
		moin.AddNumber(1);
		moin.AddNumber(1);
		moin.AddNumber(1);
		System.out.println("Median so far = " + moin.GetMedian());
		moin.AddNumber(4);
		moin.AddNumber(4);
		System.out.println("Median so far = " + moin.GetMedian());
		moin.AddNumber(4);
		System.out.println("Median so far = " + moin.GetMedian());
		moin.AddNumber(4);
		System.out.println("Median so far = " + moin.GetMedian());
		System.out.println("-------------------------------");
		moin = new MedianOfInfiniteNumbers();
		System.out.println("Median so far = " + moin.GetMedian());
		moin.AddNumber(4);
		System.out.println("Median so far = " + moin.GetMedian());
		moin.AddNumber(1);
		System.out.println("Median so far = " + moin.GetMedian());
		moin.AddNumber(2);
		System.out.println("Median so far = " + moin.GetMedian());
		moin.AddNumber(5);
		System.out.println("Median so far = " + moin.GetMedian());
		moin.AddNumber(5);
		System.out.println("Median so far = " + moin.GetMedian());

		
	}
	
}
class MaxHeapComparator implements Comparator<Integer>{
	@Override
	public int compare(Integer i1, Integer i2){
		return i2-i1;
	}
}