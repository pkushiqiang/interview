package mynote.learnbit;

public class LearnByte {
	
	public void operation(){
		 byte x;
		 x = 1;
		  //  x = 255; error 
		//  x = x + 1;  is promoted to int
		 x = (byte) (x + 1);
	}
	
	public int toUnsignedInt(byte x){
		return   x & 0xff; 
	}
	
	public static void printBits(byte a){
		String as2 = Integer.toBinaryString(a & 255 | 256);
		System.out.println(as2.substring(1));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
