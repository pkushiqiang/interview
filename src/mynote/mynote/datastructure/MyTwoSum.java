package mynote.datastructure;

/*
 * create a data structure that when check if exsting two numbers
 *  sum is target value in O(1)
 * 
 */
import java.util.*;

 
public class MyTwoSum {
	Set<Integer> sumset = new HashSet<>();
	Map<Integer,Integer> map = new HashMap<>();
	public void add(int v){
		
		if ( map.get(v) == null || map.get(v)== 1){
			for (int key : map.keySet()) {
				sumset.add(v+key);
			}
			if (map.get(v)==null)
				map.put(v, 1);
			else 
				map.put(v, 2);
		}
	}
	
	public boolean find(int target){
		return sumset.contains(target);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyTwoSum solution = new MyTwoSum();
		solution.add(2); 
		solution.add(3); 
		solution.add(5);
		System.out.println(solution.find(4));  
		System.out.println(solution.find(7));  
		System.out.println(solution.find(6)); 
		solution.add(3); 
		System.out.println(solution.find(6)); 
		System.out.println(solution.find(0)); 
	}

}
