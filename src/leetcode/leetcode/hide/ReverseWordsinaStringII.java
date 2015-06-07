package leetcode.hide;

/*
 * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

	The input string does not contain leading or trailing spaces and the words are always separated by a single space.
	
	For example,
	Given s = "the sky is blue",
	return "blue is sky the".
 */

public class ReverseWordsinaStringII {
	
	 public  static void reverseWords(char[] s) {
		 reverse(s,0,s.length-1);
		 int last  = 0;
		 for ( int i=0; i<s.length; i++ ){
			 if (s[i] == ' '){
				 reverse(s,last,i-1);
				 last = i+1;
			 }
		 }
		 reverse(s,last,s.length-1);
	 }
	 
	 private static void reverse(char[] s, int i, int j){
		 while ( i<j){
			 char c = s[i];
			 s[i] = s[j];
			 s[j] = c;
			 i++;
			 j--;
		 }		 
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	char[] s = "the sky is blue".toCharArray();
		
	//	char[] s = "the".toCharArray();
		char[] s = "the".toCharArray();;
		reverseWords(s);
		System.out.println( new String( s));
	}

}
