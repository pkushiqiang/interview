package ctci.mysolution.chapter5;

public class Question5_3 {
	
	public int getPre(int n){
		int i = 0;
		int mask = 0;
		while ( i<31  && (n&mask) !=0 ){			
				i++;			
		}
		int j = i;
		i--;
		if (i == 31)
			return Integer.MAX_VALUE;
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
