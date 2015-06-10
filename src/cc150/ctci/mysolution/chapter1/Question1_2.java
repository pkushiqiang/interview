package ctci.mysolution.chapter1;

public class Question1_2 {
	
	public static String reverse(String str){
		char[] ca = str.toCharArray();
		int i=0, j=ca.length-1;
		char t ;
		while(i<j){
			t = ca[i];
			ca[i] = ca[j];
			ca[j] = t;
			i++;
			j--;
		}
		return new String(ca);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.out.println( reverse("123456"));
	}

}
