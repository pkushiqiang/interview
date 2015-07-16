package mynote.java.basic;

public class Finally1 {

	public static void main(String args[]) {
		Finally1 t = new Finally1();
		int b = t.get();
		System.out.println(b);
	}

	public int get() {
		try {
			System.out.println("intry");
			return 1;
			
		} finally {
			System.out.println("infinally");
			return 2;
		}
	}

}
