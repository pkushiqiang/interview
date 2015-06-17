package mynote.java.basic;
import java.util.*;
public class LearnPriorityQueue {
	
	public static void remove(){
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(3);
		for (int i=0; i<10; i++){
			pq.add(i);
		}
		
		for (int i=7; i<14; i++){
			pq.remove(i);
			System.out.println("size = " + pq.size() + ", min= " + pq.peek());
		}
		
		for (int i=0; i<14; i++){
			pq.remove(i);
			System.out.println("size = " + pq.size() + ", min= " + pq.peek());
		}
		
	}
	
	public static void topk(){
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(3);
		for (int i=0; i<3; i++){
			pq.add(i);
		}
		for (int i=4; i<10; i++){
			if ( i > pq.peek() ){
				pq.poll();
				pq.add(i);
			}
			System.out.println("size = " + pq.size() + ", max= " + pq.peek());
		}
		Integer[] array = new Integer[pq.size()];
		pq.toArray(array);
		for (int i : array ){
			System.out.print(i + "  ");
		}
		System.out.println();
	}
	
	public static void maxheap(){
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(5, Collections.reverseOrder());
		for (int i=10; i>=0; i--){
			pq.add(i);
			System.out.println("size = " + pq.size() + ", max= " + pq.peek());
		}
		
	}
	
	public static void size(){
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(5);
		for (int i=10; i>=0; i--){
			pq.add(i);
			System.out.println("size = " + pq.size() + ", min= " + pq.peek());
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// size();
		// maxheap();
		// topk();
		remove();
	}

}
