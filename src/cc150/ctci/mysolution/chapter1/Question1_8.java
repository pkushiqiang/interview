package ctci.mysolution.chapter1;
import java.util.*;
public class Question1_8 {
	
	public static boolean isSubString(String target, String src){
		return ( src.indexOf(target) != -1 );
	}
	
	public static boolean isRotation(String s1, String s2){
		String s1s1 = s1+s1;
		return isSubString(s2,s1s1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.out.println( isRotation("abcd", "cdab")  );
	}

}
