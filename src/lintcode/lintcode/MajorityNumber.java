package lintcode;
import java.util.*;
public class MajorityNumber {
	
	public static int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        if (nums == null || nums.size() == 0)
            return -1;
        int count = 1;
        int p = nums.get(0);
        for (int i=1; i<nums.size(); i++) {
            int a = nums.get(i);
            if (a==p) {
                count++;
            } else if ( count > 0  ){
                count--;
            } else {
                count = 1;
                p = a;
            }
        }
        return p;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1, 1, 1, 1, 2, 2, 2};
		ArrayList<Integer> list = new ArrayList<>();
		for (int i: A) 
			list.add(i);
		System.out.println(majorityNumber(list));
	}

}
