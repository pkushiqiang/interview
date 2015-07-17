package mynote.algorithm.sort;

import java.util.*;


public class LearnComparator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] names = {"Alice","Bob","Clyde"};
		int[] ages = {30,17,49};
		Map<String, Integer> map = new HashMap<>();
		for (int i=0; i<names.length; i++) 
			map.put(names[i], ages[i]);
		
	    Arrays.sort(names, new Comparator<String>() {
	    	public int compare(String a, String b) {
	    		return (map.get(a) - map.get(b));
	    	}
	    });
	    for (String name: names) {
	    	System.out.println(name);
	    }
	}

}
