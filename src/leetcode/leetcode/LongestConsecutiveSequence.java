package leetcode;
import java.util.*;
public class LongestConsecutiveSequence {
	
	public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i: nums)
            set.add(i);
        int max =0;    
        for (int i:nums) {
            int count =1 ;
            int left = i-1;
            int right = i+1;
            while ( set.contains(left) ){
                set.remove(left);
                left--;
                count++;
            }
            while ( set.contains(right) ){
                set.remove(right);
                right++;
                count++;
            }
            max = Math.max(max, count);
        }
        return max;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 8, 2, 4, 7, 1, 0, 3, 6 };
		longestConsecutive(A);
	}

}
