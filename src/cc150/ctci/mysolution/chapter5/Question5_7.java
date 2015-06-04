package ctci.mysolution.chapter5;

// the solution in the book is terrible to understand and remember
public class Question5_7 {
	
	public static int getJthBit(int[] A, int i, int j){
		 int x = A[i];
		 int mask = 1<<j;
		 return  ( x & mask ) == 0? 0:1;
	}
	
	public static int findMissing(int[] A ){
		int x = 0;
		int n = A.length+1;
		for (int i=0; i<A.length;i++){
			int y = 0;
			for (int j=0; j<31; j++){
				y|=( getJthBit(A, i,j) << j);
			}
			x^=y;
		}
		for (int i=0; i<n; i++)
			x^=i;
		return x;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {3,2,1,0};
		System.out.println(findMissing(A));
	}
}
