package mynote.containers;
import java.util.*;
public class LearnHashmap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer,Integer> map = new HashMap<>();
		map.put(1,null);
		
		for(int i=0; i<6;i++) {
			map.put(i,i);
		}
		
		for (int i : map.keySet()) {
			map.remove(i);
		}
	}

}
