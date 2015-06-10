package ctci.mysolution.chapter1;

import java.util.Arrays;

public class Question1_3 {
	
	private static String sort(String str){
		char[] ca = str.toCharArray();
		Arrays.sort(ca);
		return new String(ca);
	}
	
	public static boolean isPermutation(String str1, String str2){
		if (str1 == null && str2 == null)
			return true;
		if (str1 == null || str2 == null)
			return false;		
		return sort(str1).equals(sort(str2));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.out.println(isPermutation("abc","acb"));
		 System.out.println(isPermutation("bbccd","cdcbb"));
	}
	
}
