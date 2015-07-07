package amazon;
import java.util.*;
public class FindSameInKLength {
	 Map<Integer, int[]> map = new HashMap<>();
	public static boolean findSameInK(int[] A, int k) {
		if (A ==null || A.length <2)
				return false;
		Set<Integer> set = new HashSet<>();
		
		int i=0;
		k= Math.min(k, A.length);
		for ( ;i<k; i++) {
			if ( set.contains(A[i])){
				return true;
			} else {
				set.add(A[i]);
			}
		}
		
		for ( ;i<A.length; i++) {
			set.remove(A[i-k]);
			if ( set.contains(A[i])){
				return true;
			} else {
				set.add(A[i]);
			}
		}
		return false;		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,2,3,4,5,6,7,8,9,10};
		System.out.println(findSameInK(A, 12));
	}

}
