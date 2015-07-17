package mynote.algorithm.sort;

public class SortMatrix {
	
	public static void descending(int[][] A) {
		if (A == null || A.length == 0 || A[0].length == 0)
			return;
		int m = A.length, n = A[0].length;
		
		sort(A);
		int[] lt = null;
		int i=0, j=m-1;
		while ( i<j) {
			lt = A[i];
			A[i] = A[j];
			A[j] = lt;
			i++;
			j--;
		}
	}

	public static void sort(int[][] A) {
		int m = A.length, n = A[0].length;
		quickSort(A, 0, m * n - 1, m);
	}

	public static void quickSort(int[][] A, int low, int high, int m) {
		if (low >= high)
			return;
		int p = getValue(A, low, m);
		int i = low + 1;
		int j = high;

		while (i <= j) {
			while (i <= j && getValue(A, i, m) <= p)
				i++;
			while (i <= j && getValue(A, j, m) > p)
				j--;
			if (i <= j) {
				swap(A, i, j, m);
				i++;
				j--;
			}
		}
		swap(A, low, j, m);
		quickSort(A, low, j - 1, m);
		quickSort(A, j + 1, high, m);
	}

	public static int getValue(int[][] A, int k, int m) {
		int i = k / m;
		int j = k % m;
		return A[i][j];
	}

	public static void setValue(int[][] A, int k, int v, int m) {
		int i = k / m;
		int j = k % m;
		A[i][j] = v;
	}

	public static void swap(int[][] A, int a, int b, int m) {
		int ai = a / m, aj = a % m;
		int bi = b / m, bj = b % m;
		int t = A[ai][aj];
		A[ai][aj] = A[bi][bj];
		A[bi][bj] = t;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] A = { { 4, 8, 9 }, { 1, 5, 6 }, { 3, 2, 7 } };
		descending(A);
		for (int[] line : A) {
			for (int i : line) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

}
