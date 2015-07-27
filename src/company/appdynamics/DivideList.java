package appdynamics;

import java.io.*;
import java.util.*;

/*

Divide a list of numbers (no duplicates) into groups of consecutive numbers, Maintain the original order

List<List<Integer>> divide(int[] a)

Example: 8,2,4,7,1,0,3,6

[[2,4,1,0,3], [8,7,6]]

[0, 5, 8]

[5, 4, 1, 6, 2], [7, 3, 0]

8

 */

class DivideList {
	
	public static List<List<Integer>> foundGroups2(final int[] A) {
		List<List<Integer>> res = new ArrayList<>();
		if (A == null || A.length == 0)
			return res;
		
		Map<Integer,Integer> map = new HashMap<>();		 
		for (int i=0; i<A.length;i++) {
			map.put(A[i],i);			 
		}		
		// 	int[] A = { 8, 2, 4, 7, 1, 0, 3, 6 };
		boolean[] flag = new boolean[A.length];
		for (int n: A) {
			if ( map.get(n)==null) {
				continue;
			}
			for (int k=0; k<flag.length;k++)
				flag[k] = false;
			Integer[] B = new Integer[A.length];
			flag[map.get(n)] = true;
			map.remove(n);
			int i=n-1;
			int j=n+1;
			while(map.containsKey(i)) {
				flag[map.get(i)] = true;			
				map.remove(i);
				i--;
			}
			while(map.containsKey(j)) {
				flag[map.get(j)] = true;
				map.remove(j);
				j++;
			}
			List<Integer> list = new ArrayList<>();
			for (int k=0; k<flag.length; k++) {
				if (flag[k])
					list.add(A[k]);
			}
			res.add(list);
		}
		return res;
	}

	public static List<List<Integer>> foundGroups(final int[] A) {
		List<List<Integer>> res = new ArrayList<>();
		if (A == null || A.length == 0)
			return res;

		Integer[] index = new Integer[A.length];
		for (int i = 0; i < A.length; i++)
			index[i] = i;
		Arrays.sort(index);
		Arrays.sort(index, new Comparator<Integer>() {
			@Override
			public int compare(Integer v1, Integer v2) {
				return A[v1] - A[v2];
			}

		});

		// index: 5, 4, 1, 6, 2, 7, 3, 0

		// list [ 0 1 ]

		int i = 0;

		while (i < A.length) {
			List<Integer> list = new ArrayList<>();
			list.add(index[i]); // [5]
			i++;
			while (i < A.length && (A[index[i]] - A[index[i - 1]] == 1)) {
				list.add(index[i]); // [5, 4, 1, 6, 2] [7, 3, 0]
				i++;
			}
			res.add(list);
		}

		List<List<Integer>> res2 = new ArrayList<>();

		for (List<Integer> list : res) {
			Collections.sort(list);
			List<Integer> list2 = new ArrayList<>();
			for (int j : list) {
				list2.add(A[j]);
			}
			res2.add(list2);
		}

		return res2;
	}
	
	public static void printGroups(List<List<Integer>> res2) {
		
		for (List<Integer> list : res2) {
			for (int j : list) {
				System.out.print(j + ",");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[] A = { 8, 2, 4, 7, 1, 0, 3, 6 };
		List<List<Integer>> res1 = foundGroups(A);
		printGroups(res1);
		
		System.out.println("---------------------");
		List<List<Integer>> res2 = foundGroups2(A);
		printGroups(res2); 
	}
}
