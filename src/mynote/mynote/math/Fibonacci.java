package mynote.math;

public class Fibonacci {
	
	public static int formula(int n){	
		n++;
        double sqrt5 = Math.sqrt(5);
        double numer =  Math.pow( (1+sqrt5)/2, n ) -  Math.pow( (1-sqrt5)/2, n ) ;
        double deno = sqrt5 ;
     //   System.out.println(n+">"+ numer+ ">" + deno) ;
        return (int ) ( numer/deno  );		
	}
	
	public static int inter(int n){
		if ( n < 4 )
			return n;
		int l2 =2;
		int l1 = 3;
		int cur = 0;
		for (int i=4; i<=n; i++){
			cur = l1+l2;
			l2 = l1;
			l1 =cur;
		}
		return cur;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i=0; i<40; i++){
			System.out.println(i+":"+ inter(i)+ ":" + formula(i)) ;
		}
	}

}
