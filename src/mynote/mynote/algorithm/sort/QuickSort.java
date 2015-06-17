package mynote.algorithm.sort;

public class QuickSort {
	
	static int partition(int arr[], int left, int right)
	{
	      int i = left+1, j = right;
	      int tmp;
	      int pivot = arr[left];
	     
	      while (i <= j) {
	            while (i <= j && arr[i] <= pivot)
	                  i++;
	            while (i <= j && arr[j] > pivot)
	                  j--;
	            if (i <= j) {
	                  tmp = arr[i];
	                  arr[i] = arr[j];
	                  arr[j] = tmp;
	                  i++;
	                  j--;
	            }
	      };
	      tmp = arr[j];
          arr[j] = pivot;
          arr[left] = tmp;
	      return j;
	}
	 
	static void  quickSort(int arr[], int left, int right) {
	      int index = partition(arr, left, right);
	      if (left < index - 1)
	            quickSort(arr, left, index - 1);
	      if (index+1 < right)
	            quickSort(arr, index+1, right);
	}
	
	public static void qsort(int[] attr ) {
		quickSort(attr, 0, attr.length-1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 3, 9, 18, 7, 7, 5, 8,7, 10, 12, 11 };
		QuickSort.qsort(A);
		for (Integer i: A) {
			System.out.print(i+"  ");
		}
	}

}
