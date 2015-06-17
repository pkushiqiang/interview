package mynote.algorithm.sort;

public class FindKth {

	public static int  findKth(int[] A, int k) {
		 int p = partition(A, 0, A.length-1);
		 int left = 0, right = A.length-1;
		 while ( k-1 !=  p) {
			 System.out.println("p="+p);
			 if ( k-1 < p) {
				 right = p-1;
				 p = partition(A, left, right);
			 } else {
			//	 k = k - p-1; 
				 left =  p+1;
				 p = partition(A, p+1, right);
			 }			 
		 }		 
		 return A[p];
	}
	
	static int partition(int arr[], int left, int right) {     
		  int pivot = arr[left];
	      int i = left+1, j = right;
	      int tmp;	      
	     
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
	      arr[left] = arr[j]; 
          arr[j] = pivot;           
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
		int[] A = { 3, 9, 18, 7, 5, 8, 10, 12, 11 };
	//	QuickSort.qsort(A);
		for (Integer i: A) {
			System.out.print(i+"  ");
		}
		System.out.println();
		System.out.print(FindKth.findKth(A, 8));
	}

}
