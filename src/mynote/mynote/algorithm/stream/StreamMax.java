package mynote.algorithm.stream;
import java.util.*;
public class StreamMax {
	
	
	public static List<Integer> streamMax(int[] N, int k){
		List<Integer> list = new ArrayList<Integer>();
		if(N==null || N.length< k)
			return list;
		
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
			public int compare(Integer x, Integer y) {
				if (x < y) return 1;
				if (x > y) return -1;
				return 0;
				}});
		int i=0;
		for ( ; i<k-1; i++) {
			heap.add(N[i]);
		}
		int head = 0;
		for ( ; i<N.length ; i++) {
			heap.add(N[i]);
			list.add(heap.peek());
			heap.remove(N[head]);
			head++;			
		}
		
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[] A = {1,2,3,4,5,6,7,8,9,10};
		int[] A = {7,2,6,8,8,0,7,8,4,-1,4,5,9,3,6,10};
		int k = 3;
		List<Integer> list = StreamMax.streamMax(A, k);
		for ( int i=0; i<A.length-k+1; i++ ){
			for ( int j=i; j<i+k; j++ )
				System.out.print(A[j]+ " ");
			System.out.println(" --> "+list.get(i)+ " ");
		}
	}

}
