package mynote.algorithm.combination;

import java.util.*;

public class RepeatableCombination {

	public static List<List<Integer>> repeatableCombination(int[] A, int k) {
		List<List<Integer>> res = new ArrayList<>();
		if (A == null || A.length == 0 || k == 0)
			return res;

		List<Integer> list = new ArrayList<>();
		helper(res, list, A, 0, 0, k);
		return res;
	}

	private static void helper(List<List<Integer>> res, List<Integer> list,
			int[] A, int s, int n, int k) {
		if (n == k) {
			res.add(new ArrayList(list));
			return;
		}

		for (int i = s; i < A.length; i++) {
			list.add(A[i]);
			helper(res, list, A, i, n + 1, k);
			list.remove(list.size() - 1);
		}
	}
	
	public static void printRes(int[] A, int k) {
		List<List<Integer>> res = repeatableCombination(A, k);
		System.out.println("\n\n------------" + k + "-----------size=" + res.size());
		for (List<Integer> list : res) {
			int pro  = 1;
			for (int i : list) {
				System.out.print(i + "  ");
				pro *=i;
			}
			System.out.println( "  ="+pro);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 3, 5, 7 };
		for (int k=0; k<7; k++) {
			
			printRes(  A,   k) ;
			
		}
		
	}

}
