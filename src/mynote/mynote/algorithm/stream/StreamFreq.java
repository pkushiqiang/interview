package mynote.algorithm.stream;

import java.util.*;

public class StreamFreq {
	
	public static List<String> streamMaxFreq(String[] N, int k) {
		List<String> list = new ArrayList<String>();
		if(N==null || N.length< k)
			return list;
		List<Set<String>> setList = new ArrayList<Set<String>>();
		for (int i=0; i<=k; i++) {
			setList.add(new HashSet<String>());
		}
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i=0; i<k; i++) {
			String s = N[i];
			if (map.get(s) !=null ) {
				map.put(s,map.get(s)+1);
			} else {
				map.put(s, 1);
			}
		}
		int max = 0;
		for (String s: map.keySet()) {
			int v = map.get(s);
			max = Math.max(v,max);
			setList.get(v).add(s);
		}
		
		Set<String> maxSet = setList.get(max);
		list.add(maxSet.iterator().next());
		
		int head = -1;
		for (int i=k; i<N.length; i++) {
			head++;
			String hs = N[head];			
			String ts = N[i];
			if ( !hs.equals(ts)) {
				int v = map.get(hs);
				map.put(hs,v-1);
				setList.get(v).remove(hs);
				if (v>1) {
					setList.get(v-1).add(hs);
				}
				if ( max == v && setList.get(v).size() == 0 ) {	
					max--;
				}
				
				// ---- tail 
				if ( map.get(ts) == null ) {
					map.put(ts,1);
					setList.get(1).add(ts);
				} else {
					v = map.get(ts);
					map.put(ts,v+1);
					setList.get(v).remove(ts);
					setList.get(v+1).add(ts);
					if (max == v)
						max++;
				}				
			}
			maxSet = setList.get(max);
			list.add(maxSet.iterator().next());
		} // for
		
		
		return list;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] S="a b c a b c a b c a b c ".split(" ");
		int k= 6;
		List<String> list= StreamFreq.streamMaxFreq(S, k);
		for ( int i=0; i<S.length-k+1; i++ ){
			for ( int j=i; j<i+k; j++ )
				System.out.print(S[j]+ " ");
			System.out.println(" --> "+list.get(i)+ " ");
		}
		
	}

}
