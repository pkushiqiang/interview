package ctci.mysolution.chapter1;

public class Question1_4 {
	
	public static void addstr(char[] array, int len){
		int n = 0;
		for (int i=0; i<len; i++) {
			if (array[i] == ' ')
				n++;
		}
		
		int j = len-1;
		int i = len+2*n-1;
		for ( ; j>=0 ;j--) {
			if ( array[j] == ' ') {
				array[i--] = '0';
				array[i--] = '2';
				array[i--] = '%';
			} else {
				array[i--] = array[j];
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 char [] ca = new char[200];
		 String str = "  a bc d e d   df  ";
		 for (int i=0; i<str.length(); i++) {
			 ca[i] = str.charAt(i);
		 }
		 addstr(ca, str.length());
		 String res = new String(ca);
		 System.out.println(res);
	}

}
