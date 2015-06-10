package ctci.mysolution.chapter1;

public class Question1_1 {
	
	public static boolean isUnique(String str){
		if ( str.length() > 256 )
			return false;
		boolean[] map = new boolean[256];
		for ( int i=0; i<str.length(); i++) {
			int val = str.charAt(i);
			if (map[val]) {
				return false;
			}
			map[val] = true;
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isUnique("abc"));
		System.out.println(isUnique("bbc"));
		System.out.println(isUnique("cef"));
	}

}
