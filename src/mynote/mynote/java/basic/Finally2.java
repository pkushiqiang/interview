package mynote.java.basic;

public class Finally2 {
	

	static int test() {
		int x = 1;
		try {
			return x;
		} finally {
			++x;
		}
	}
	
	 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Finally2().test());
		;
	}
}
