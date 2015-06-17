package mynote.java.basic;

public class LearnString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = ".";
		s = "1.";
		
		String[] strs =s.split("\\.");
		System.out.println(strs.length);
		System.out.println(strs[0]);
		System.out.println(strs[1]);

	}

}
