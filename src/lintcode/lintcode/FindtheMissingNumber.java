package lintcode;

public class FindtheMissingNumber {
	
	public static int findMissing(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        int in = -1;
        for ( int i=0; i<n; i++ ) {
            while ( nums[i] != i ) {
                if ( nums[i] == n){
                    in=i;
                    break;
                } else {
                	int p = nums[i];
                    nums[i] = nums[p];
                    nums[p] = p;
                }
            }
        }
        
        if (in == -1)
            return n;
        else 
            return in;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {9,8,7,6,2,0,1,5,4};
		System.out.println(findMissing(num));
	}

}
