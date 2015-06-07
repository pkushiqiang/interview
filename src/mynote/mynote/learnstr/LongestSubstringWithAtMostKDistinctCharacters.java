package mynote.learnstr;
import java.util.*;

public class LongestSubstringWithAtMostKDistinctCharacters {
	
	public static String klongest(String s, int k){
		if (s==null)
			return null;
		if (s.length() <=k)
			return s;
		int max = 0;
		String maxstr = null;
		int last = 0;
		Map<Character, Integer> map = new HashMap<>();
		for(int i=0; i<s.length();i++) {
			char c = s.charAt(i);
			if ( map.containsKey(c) ){
				map.put(c, map.get(c)+1);
			} else if (map.size()< k) {
				map.put(c, 1);
			} else {
				if ( i- last > max){
					max = i-last;
					maxstr = s.substring(last, i);
				}
				while (last < i) {
					char c2 = s.charAt(last++);
					if (map.get(c2)>1){
						map.put(c2, map.get(c2)-1);
					} else {
						map.remove(c2);
						map.put(c, 1);	
						break;
					}					 
				}
			}
		}		
		
		if ( s.length() - last > max){
			max = s.length()-last;
			maxstr = s.substring(last, s.length());
		}
		
		return maxstr;
	}
	
	public static String klongest2(String s, int k){
		if (s==null)
			return null;
		if (s.length() <=k)
			return s;
		int max = 0;
		String maxstr = null;
		Queue<Integer> queue  = new LinkedList<>();	   
		Map<Character, Integer> map = new HashMap<>();
		int last = 0;
		int i = 0;
		while (  i<s.length() ){ 
			char c = s.charAt(i);
			if (!map.containsKey(c)){
				if ( map.size() == k){
					if ( i-last > max ){
						max = i-last;
						maxstr = s.substring(last, i);
					}					
					map.remove(s.charAt(queue.peek()));
					queue.remove();
					last = queue.peek();					
				}
				map.put(c,i);
				queue.offer(i);
			} else if ( c != s.charAt(i-1) ){
				map.put(c,i);
				queue.remove();
				queue.offer(i);
			}
			i++;
		}		 
		
		if ( s.length()-last > max ){
			max = i-last;
			maxstr = s.substring(last, i);
		}
		return maxstr;
	}
	
	public static void test (String str, int k,String should){
		String longest = klongest(str, k);
		System.out.println (k+ " " + str +  "  " + longest + "  " +  should + "  " + longest.length() + " "  + should.length()  );
	}
    
	public  static void testCase1(){
		test ("ab", 2, "ab");
		test ("a", 2,"a");
		test ("abcc", 2,"bcc");
		test ("eceba",2, "ece");
		test ("aabbaabbcc", 2,"aabbaabb");
		test ("cccaabbaabbcc", 2,"aabbaabb");
	//	test (null, 2, "");
		test ("ccaaabbbbaaccccccccaaaa", 2, "aaccccccccaaaa");
		test ("abcddccc", 3, "bcddccc");
		test ("abcd", 4, "abcd");
		test ("abbbbcccc", 4, "abbbbcccc");
		test ("ccddaaabbbbaaccccccccaaaabb", 3, "aaabbbbaaccccccccaaaabb");
		
	}
	
	public  static void testCase2(){
		// test ("ccaaddaabbaacccc", 3, "aabbaacccc");
		 test ("ccddaaabbbbaaccccccccaaaabb", 3, "aaabbbbaaccccccccaaaabb");
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testCase1();
		testCase2();
	}

}
