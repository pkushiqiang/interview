package amazon;

public class RotateMatrix {

	public static void rotateMatrix(int[][] A) {

	//	int[][] dire = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		int[][] dire = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

		int m = A.length;
		int n = A[0].length;
		int k = (m > n) ? n / 2 : m / 2;
		int di = 0;
		for (int a = 0; a < k; a++) {
			int last = A[a][a];
			// int i = a;
			// int j = a + 1;
			int i=a+1;
			int j = a;
			int total = (m - 2 * a) * 2 + (n - 2 * a - 2) * 2;
		
			for (int c = 0; c < total; c++) {
				int p = A[i][j];
				A[i][j] = last;
				last = p;
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] A = generateMatrix(5,4);
		printMatrix(A);
		System.out.println("--------------------");
		rotateMatrix(A);
		printMatrix(A);
	}

}
