package amazon;
import java.util.*;
public class RotateMatrix {
	
	static int[][] clockwise = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int[][] anticlockwise = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	static int i,j,di;
	
	public static void rotateMatrix(int[][] A, int k, boolean isClockwise) {
		int[][] dire = isClockwise ? clockwise:anticlockwise;
		
		int m = A.length;
		int n = A[0].length;
		int t = (m > n) ? n / 2 : m / 2;
		
		Queue<Integer> queue = new LinkedList<>();
		
		
		for (int a=0; a<t; a++) {
			int total = (m - 2 * a) * 2 + (n - 2 * a - 2) * 2;
			int k1 = k%total;
			i=j=a;
			di = 0;
			queue.clear();
			for (int b=0; b<k1; b++) {
				queue.add(A[i][j]);
				nextStep( dire,  m,  n,  a);
			}
			
			for (int b=0; b<total;b++) {
				queue.add(A[i][j]);
				A[i][j] = queue.remove();
				nextStep( dire,  m,  n,  a);
			}
			
		}
	}
	
	private static void nextStep( int[][] dire, int m, int n, int a){
		i += dire[di][0];
		j += dire[di][1];
		if (j == n - a || i == m - a || j == a - 1 || i == a-1) {
			if (j == n - a)
				j--;
			else if (j == a - 1)
				j++;
			else if (i == m - a)
				i--;
			else if (i == a-1)
				i++;
			
			di = (di+1) % 4;
			i += dire[di][0];
			j += dire[di][1];
		}
	}

	public static void rotateMatrix(int[][] A, boolean isClockwise) {
		int[][] dire = isClockwise ? clockwise:anticlockwise;
		
		int m = A.length;
		int n = A[0].length;
		int k = (m > n) ? n / 2 : m / 2;
		int di = 0;
		for (int a = 0; a < k; a++) {
			int last = A[a][a];			
			int i = a, j = a;		
			int total = (m - 2 * a) * 2 + (n - 2 * a - 2) * 2;
		
			for (int c = 0; c < total; c++) {				
				i += dire[di][0];
				j += dire[di][1];
				if (j == n - a || i == m - a || j == a - 1 || i == a-1) {
					if (j == n - a)
						j--;
					else if (j == a - 1)
						j++;
					else if (i == m - a)
						i--;
					else if (i == a-1)
						i++;
					
					di = (di+1) % 4;
					i += dire[di][0];
					j += dire[di][1];
				}
				
				int p = A[i][j];
				A[i][j] = last;
				last = p;
			}
		}
	}
	
	public static int[][] generateMatrix(int m, int n) {
		int c=1;
		int[][] A = new int[m][n];
		for (int i=0; i<m; i++)
			for (int j=0;j<n; j++) {
				A[i][j] = c++;
			}
		return A;
	}
	
	public static void printMatrix(int[][] A) {
		int m = A.length;
		int n = A[0].length;
		StringBuilder sb = new StringBuilder();
		for ( int i =0; i<m; i++){
			for (int j=0;j<n; j++) {
				int a = A[i][j];
				String str = "   "+ Integer.toString(a);
				str = str.substring(str.length()-3, str.length());
				 sb.append(str);
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static boolean isEqual(int[][] A, int[][] B) {
		if (A.length != B.length || A[0].length != B[0].length)
			return false;
		
		int m = A.length;
		int n = A[0].length;		 
		for ( int i =0; i<m; i++) 
			for (int j=0;j<n; j++)  
				 if (A[i][j] != B[i][j])
					 return false;
		return true;			 
	}
	
	public static void testRotate(){
		int[][] A = generateMatrix(2,2);
		printMatrix(A);
		System.out.println("--------------------");
		rotateMatrix(A,false);
		printMatrix(A);
	}
	
	public static void testRotateK() {
		int k = 9;
		boolean clockwise = false;
		int[][] A = generateMatrix(2,2);
		int[][] B = generateMatrix(2,2);
		
		for (int i=0; i<k; i++) {
			rotateMatrix(A, clockwise);
		}
		rotateMatrix(B, k, clockwise);
		System.out.println(isEqual(A,B));
		printMatrix(A);
		System.out.println("--------------------");
		printMatrix(B);
	}
		
	 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testRotateK();
	}

}
