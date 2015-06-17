package mynote.algorithm.number;
import java.util.*;
public class Factorization {
	
	public static List<Integer> factorization2(int N){
		List<Integer> list = new ArrayList<Integer>();
		while (N%2==0) {
			list.add(2);
			N /=2;
		}
		int i =3;
		while(i<=Math.sqrt(N)) {
			if ( N%i ==0 ) {
				list.add(i);
				N/=i;
			} else {
				i+=2;
			}			
		}
		list.add(N);
		return list;
		
	}
	
	public static List<Integer> factorization(int N){
		int i =2;
		List<Integer> list = new ArrayList<Integer>();
		while(i<=Math.sqrt(N)) {
			if ( N%i ==0 ) {
				list.add(i);
				N/=i;
			} else {
				i++;
			}			
		}
		list.add(N);
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N= 345234;
		List<Integer> list = Factorization.factorization2(N);
		for (int i : list) {
			System.out.print(i+ "  ");
		}
	}

}
