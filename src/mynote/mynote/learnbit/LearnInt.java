package mynote.learnbit;

public class LearnInt {

	public static void studyMin(){
		int min = Integer.MIN_VALUE;
		System.out.println(min);
		System.out.println(Math.abs(min));
		System.out.println( Integer.toBinaryString(min) + " : " + min);
		System.out.println( Integer.toBinaryString(-1) + " : " + -1);
	}
	
	public static void highestBit(){
		int i = 1<<31;
		System.out.println( Integer.toBinaryString(i) + " : " + i);
		System.out.println( Integer.toBinaryString(i-1) + " : " + (i-1));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		highestBit();
	}

}
