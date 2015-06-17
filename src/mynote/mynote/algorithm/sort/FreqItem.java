package mynote.algorithm.sort;
import java.util.*;
public class FreqItem {
	
	public static List<Integer> findFreq(int[] A, int K) {
		List<Integer> res = new ArrayList<Integer>();
		if(A==null || A.length<=K)
			return res;
		int maplen = K-1;
		Map<Integer, Integer> map = new HashMap<Integer,Integer>();
		
		for (int i=0; i<A.length; i++){
			int key = A[i];
			if(map.get(key)!=null){
				map.put(key, map.get(key)+1);
			} else {				
				if (map.size() < maplen){
					map.put(key, 1);
				} else {
					List<Integer> remove = new ArrayList<Integer>();
					for ( int k : map.keySet() ) {
						int v = map.get(k)-1;
						if ( v > 0)
							map.put(k, v );
						else 
							remove.add(k);
					}
					for (Integer k : remove){
						map.remove(k);
					}
				}				
			}
		}// for
		
		for ( int k : map.keySet() ) {
			map.put(k, 0 );
		}
		
		for (int i: A){
			if (map.get(i)!=null){
				map.put(i, map.get(i)+1);
			}
		}
		int freq = A.length/K;
		for ( int k : map.keySet() ) {
			if ( map.get(k) > freq)
					res.add(k);
		}
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A={3,5,5,5,4,3,3,4,5};
		int K= 3;
		List<Integer> res = FreqItem.findFreq(A, K);
		for (Integer i: res){
			System.out.println(i);
		}
	}

}
