package lintcode;

public class SubmatrixSum {

	public static int[][] submatrixSum(int[][] matrix) {
		// Write your code here
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			int[][] res = { {} };
			return res;
		}
		int[][] res = new int[2][2];
		int m = matrix.length, n = matrix[0].length;

		int[][][][] dp = new int[m][n][m][n];
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++) {
				dp[i][j][i][j] = matrix[i][j];
				if (matrix[i][j] == 0) {
					res[0][0] = i;
					res[0][1] = j;
					res[1][0] = i;
					res[1][1] = j;
					return res;
				}
			}

		for (int col = 1; col < n; col++)
			for (int i = 0; i < m; i++)
				for (int j = 0; j < n - col; j++) {
					int j1 = j + col;
					dp[i][j][i][j1] = dp[i][j][i][j1 - 1] + dp[i][j1][i][j1];
					if (dp[i][j][i][j1] == 0) {
						res[0][0] = i;
						res[0][1] = j;
						res[1][0] = i;
						res[1][1] = j1;
						return res;
					}
				}

		for (int col = 0; col < n; col++)
			for (int row = 1; row < m; row++)
				for (int i = 0; i < m - row; i++)
					for (int j = 0; j < n - col; j++) {
						int j1 = j + col;
						int i1 = i + row;
						dp[i][j][i1][j1] = dp[i][j][i1 - 1][j1]
								+ dp[i1][j][i1][j1];
						if (dp[i][j][i1][j1] == 0) {
							res[0][0] = i;
							res[0][1] = j;
							res[1][0] = i1;
							res[1][1] = j1;
							return res;
						}
					}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {  { 1, 5, 7 }, 
							{ 3, 7, -8 }, 
							{ 4, -8, 9 } };
		int[][] res = submatrixSum(matrix);
		System.out.println("("   + res[0][0] + "," + res[0][0] + "),  \n(" +res[1][0] + "," +res[1][0] + ")");
	}

}
