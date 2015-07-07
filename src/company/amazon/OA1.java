package amazon;
import java.io.*;
import java.util.*;
public class OA1 {

	 public static boolean findInK( Scanner in  ) {
	        int n = in.nextInt();
	        if ( n <= 0) {
	            return false;
	        }
	        in.nextLine();
	        Map<Integer, List<int[]>> map = new HashMap<>();
	        int m=0;
	        for (int i=0; i<n; i++) {
	            String line = in.nextLine();
	            String[] strs = line.split(" ");
	            m = strs.length; 
	            for (int j=0; j<strs.length; j++) {
	                int v = Integer.parseInt(strs[j]);
	                if (!map.containsKey(v)) {
	                    map.put(v, new ArrayList<int[]>());
	                }
	                int[] pos = {i,j};
	                map.get(v).add(pos);
	            }            
	        }
	        
	        int k = in.nextInt();
	        if ( k==0)
	            return true;
	        if ( k> m+n-2)
	            return false;
	        
	        for (int v: map.keySet()) {
	            if ( map.get(v).size()>1) {
	                if ( hasDup(map.get(v),k))
	                    return true;
	            }
	        }
	        return false;
	    }
	    
	    private static boolean hasDup(List<int[]> list, int k) {
	        for (int i=0; i<list.size()-1; i++) {
	            int[] pos1 = list.get(i);
	            for (int j=i+1; j<list.size();j++) {
	                int[] pos2 = list.get(j);
	                if ( ( Math.abs(pos1[0]-pos2[0]) + Math.abs(pos1[1]-pos2[1]) ) <=k  )
	                    return true;
	            }
	        }
	        return false;
	    }
	    
	public static void main(String args[] ) throws Exception {
	    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
	    Scanner in = new Scanner(System.in);
		if(findInK(in)) {
	        System.out.println("YES");
	    } else {
	        System.out.println("NO");
	    }
	}
}
