package ctci.mysolution.chapter1;
import java.util.*;
public class Question1_5 {
	
	public static String compress(String str) {
		if (str == null || str.length() < 3)
			return str;
		StringBuilder sb = new StringBuilder();
		char c = str.charAt(0);
		int n = 1;
		for (int i=1; i<str.length(); i++) {
			if ( c == str.charAt(i)){
				n++;
			} else {
				sb.append(c);
				sb.append(n);
				c = str.charAt(i);
				n = 1;
			}
		}
		sb.append(c);
		sb.append(n);
		
		if (sb.length() < str.length())
			return sb.toString();
		else
			return str;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.out.println(compress("abc"));
		 System.out.println(compress("aaa"));
		 System.out.println(compress("aaabbcc"));
		 System.out.println(compress("aacbbccccdddvv"));
		 System.out.println(compress("aa"));
	}

}
