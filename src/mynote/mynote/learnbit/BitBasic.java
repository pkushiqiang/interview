package mynote.learnbit;

public class BitBasic {
	
	public static void signedShift(){
		int i1 = 16;
		System.out.println(Integer.toBinaryString(i1));	
		System.out.println(Integer.toBinaryString(i1>>2));	
		System.out.println(Integer.toBinaryString(i1>>>2));	
		
		int i2 = -16;
		System.out.println(Integer.toBinaryString(i2));
		System.out.println(Integer.toBinaryString(i2>>2));	
		System.out.println(Integer.toBinaryString(i2>>>2));	
	}
	
	public static void printBits(){
		byte a = 7;
		String as = Integer.toBinaryString(a );  // 111
		String as2 = Integer.toBinaryString(a & 255 | 256);
		System.out.println(as);
		System.out.println(as2);
		System.out.println(as2.substring(1));		
	}
	
	public static String getBits(byte b){
		String as2 = Integer.toBinaryString(b & 255 | 256);		 
		return as2.substring(1);		
	}
	
	public static void learnChar(){
		char c = 0;
		while( c<=Integer.MAX_VALUE){
			System.out.println((int)c + " "+ c);
			c++;
		}
	}
	
	public static void learnByte(){
		byte b = 100;
		b+=100;
		System.out.println(b);	
		
		byte b2 = ~0;
		System.out.println(b2); // -1
		System.out.println(getBits(b2)); // 11111111
	 
	}
	
	public static void unsignedInt(){
		System.out.println(Integer.toBinaryString(0xf));
		int a = -16;
		System.out.println(Integer.toBinaryString(a));
		long mask =  0xffffffffL;
		long al = a & mask;
		System.out.println(Long.toBinaryString(al) + "=" + al);
		long n = ~0;
		System.out.println(Long.toBinaryString(n));
	}
	
	public static void learnInt(){
		int a = ~0;
		System.out.println(Integer.toBinaryString(a));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		signedShift();
	}

}
