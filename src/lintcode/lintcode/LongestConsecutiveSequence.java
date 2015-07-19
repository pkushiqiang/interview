package lintcode;
import java.util.*;
public class LongestConsecutiveSequence {
	
	public static int longestConsecutive(int[] num) {
        // write you code here
        if ( num == null )
            return 0;
        if (num.length < 2)
            return num.length;
        Map<Integer,Integer> map = new HashMap<>();
        int max = 1;
        for ( int i:num) {
            
            if ( !map.containsKey(i) ) {
                if (  map.containsKey(i-1) && map.containsKey(i+1) ) {
                    int start = i-1 - map.get(i-1)+1;
                    int end = i+1 + map.get(i+1) -1; 
                    int len = map.get(i-1) + map.get(i+1) + 1;
                    map.put(start,len);
                    map.put(i,len);
                    map.put(end,len);
                    if ( len > max)
                        max = len;
                } else if (  map.containsKey(i-1)  ) {
                    int start = i-1 - map.get(i-1)+1;
                    int len = map.get(i-1) + 1;
                    map.put(start,len);
                    map.put(i,len);
                    if ( len > max)
                        max = len;
                }else if (  map.containsKey(i+1)  ) {
                    int end = i+1 + map.get(i+1) -1; 
                    int len = map.get(i+1) + 1;
                    map.put(i,len);
                    map.put(end,len);
                    if ( len > max)
                        max = len;
                }else {
                    map.put(i,1);
                }
            }
            
        } // for
        return max;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3 };
		System.out.println(longestConsecutive(A));
	}

}
