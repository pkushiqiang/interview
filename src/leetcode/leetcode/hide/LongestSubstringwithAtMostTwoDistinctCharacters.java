package leetcode.hide;

/*
 * Given a string, find the length of the longest substring T that contains at most 2 distinct characters.

For example, Given s = ¡°eceba¡±,

T is "ece" which its length is 3.
 */

public class LongestSubstringwithAtMostTwoDistinctCharacters {
	
	public static int longest(String s) {
		 if (s == null || s.length() == 0  )
			 return 0;
		 char c1 = s.charAt(0);		
		 int last  = 0 ;		
		 
		 int i = 1;		 
		 while ( i<s.length() && s.charAt(i) == c1 ){
			 	i++;			 	
		 }		 
		 if ( i >= s.length()-1)
			 return s.length();		 
		 char c2 = s.charAt(i);
		 int lastc2 = i;
		 i++;
		 while ( i < s.length() && s.charAt(i) == c2){			 
			 i++;
		 }
		 if ( i == s.length() )
			 return s.length();		
		 
		 int max = i;
		  
		 while ( i<s.length() ) {
			 if ( s.charAt(i) != c1 ){
				last = lastc2;
			 }
			 c1 = c2;
			 c2 = s.charAt(i);			
			 lastc2 = i;			 
			 
			 i++;
			 while ( i<s.length() && s.charAt(i) == c2 ){
				 	i++;			 	
			 }	
			 if ( i - last > max)
				 max = i - last;			 		 
		 }		 
		
		 return max;
	}
	
	public static void test (String str, String should){
		System.out.println ( str +  "  " + longest(str) + "  " +  should + "  " + should.length() );
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test ("ab", "ab");
		test ("a", "a");
		test ("abcc", "bcc");
		test ("eceba", "ece");
		test ("aabbaabbcc", "aabbaabb");
		test ("cccaabbaabbcc", "aabbaabb");
		test (null, "");
		test ("ccaaabbbbaaccccccccaaaa", "aaccccccccaaaa");
		
	}

}
