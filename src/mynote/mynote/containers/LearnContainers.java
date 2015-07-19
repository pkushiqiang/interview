package mynote.containers;

import java.util.*;

class Node {
	int val;
}

public class LearnContainers {
	
	public void charandString(){		
		char[] cs = {'a','b'};
		String str = new String(cs);
		cs = str.toCharArray();	}
	
	public void listAndSet(){
		Set<String> hashset = new HashSet<String>();
		hashset.add("A");
		hashset.add("B");
		hashset.add("C");
		List<String> list = new ArrayList<String>(hashset);
		System.out.println(list.toString());	
		
		Set<String> foo = new HashSet<>(list);
	}
	
	public static void keyset(){
		 Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		 for (int k: map.keySet()){
			 
		 }
	}
	
	public static void arrayAndSet() {
		
		Integer[] sourceArray = { 0, 1, 2, 3, 4, 5 };
		Set<Integer> targetSet = new HashSet<Integer>();
		Collections.addAll(targetSet, sourceArray);		
		Integer[] targetArray = targetSet.toArray(new Integer[targetSet.size()]);
	    Set<Integer> set = new HashSet<Integer>();
	    Iterator<Integer> iter = set.iterator();
	    while (iter.hasNext()){
	    	
	    }
	
	}

	public static void arrayAndList() {

		int[] spam = new int[] { 1, 2, 3 };
	//	List<Integer> list1 = Arrays.asList(spam); wrong

		List<String> list = new ArrayList<String>();	     
		String[] strs = list.toArray(new String[list.size()]);
		List<Node> nodeList = new ArrayList<Node>();
		Node[] nodes = nodeList.toArray(new Node[nodeList.size()]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 4;
		int[] p = {0, a};
	//	p = {0, a};
		List<int[]> list  = new ArrayList<int[]>();
		list.add(p);
	}

}
