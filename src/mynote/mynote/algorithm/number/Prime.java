package mynote.algorithm.number;
import java.util.*;
public class Prime {
	
	public static List<Long> generate(long N) {
		List<Long> list = new ArrayList<Long> ();
		list.add((long)2);
		list.add((long)3);
		Long i = (long) 5;
		while(true) {			 
			int j = 1;
			boolean f = true;
			while ( f &&  (j < list.size()) && (list.get(j) <= Math.sqrt(i))) {
				if ( i%list.get(j) == 0) {
					f = false;
				}
				j++;
			}
			if (f) {
				list.add(i);
				System.out.println(i+ " --> "+ list.size());
			}
			if (i>N) {
				return list;
			}
			i+=2;
		}
		
	}
	
	public static long nextPrime2(long N) {
		long next = (N%2==0) ?  N+1 :  N+2;
		while(true) {	
			boolean f = true;
			for (long i=3; i< Math.sqrt(next); i++) {
			  if ( next % i == 0 ) {
				  f =false;
				  break;
			  }
			}
			if (f)
				return next;
			else 
				next +=2;
		}		
	}
	
	public static long nextPrime(long N) {
		List<Long> list = new ArrayList<Long> ();
		list.add((long)2);
		list.add((long)3);
		Long i = (long) 5;
		while(true) {			 
			int j = 1;
			boolean f = true;
			while ( f &&  (j < list.size()) && (list.get(j) <= Math.sqrt(i))) {
				if ( i%list.get(j) == 0) {
					f = false;
				}
				j++;
			}
			if (f) {
				list.add(i);		
				if (i>N)
					return i;
			}
			
			i+=2;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 // List<Long> list = Prime.generate(Long.MAX_VALUE);
		/*
		for (long i : list ) {
			System.out.print(i+ "  ");
		}
		*/
		long k=Long.MAX_VALUE>>>12;
	//	System.out.println(Prime.nextPrime(k)); 
		System.out.println(Prime.nextPrime2(k)); 
	//	System.out.println(Prime.nextPrime(k)); 
	}

}
