package lintcode;

import java.util.ArrayList;

public class KthLargestElement {
	
	public static int kthLargestElement(int k, ArrayList<Integer> nums) {
        // write your code here
        if (nums == null || k> nums.size()) 
            return -1;
        return getKth(  k,  nums,  0, nums.size()-1 ); 
    }
    
    private static int getKth( int k, ArrayList<Integer> nums, int low, int high ) {
        
        int p = nums.get(high);
        int i= low ;
        int j = high-1;
        
        while ( i<=j) {
            while ( i<high && nums.get(i) > p )
                i++;
            while ( j>=low && nums.get(j) <= p )
                j--;
                
            if ( i<high && j>=low ) {
                int t = nums.get(i);
                nums.set(i,nums.get(j));
                nums.set(j,t);
                i++;
                j--;
            }
        }
        nums.set(low,nums.get(i));
        nums.set(i,p);
        
        if ( i-low+1 == k)
            return p;
        else if ( i-low+1 > k) {
            return getKth(  k,  nums,  low, i-1 ); 
        } else {
            return getKth(  k-(i-low+1),  nums,  i+1, high ); 
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,2,3,4,5,6,8,9,10,7};
		ArrayList<Integer> list = new ArrayList<>();
		for (int i: A) 
			list.add(i);
		System.out.println(kthLargestElement(10,list));
	}

}
