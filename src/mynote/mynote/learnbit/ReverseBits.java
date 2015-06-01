package mynote.learnbit;

public class ReverseBits {

	public static int swapIntBits(int x, int i, int j) {
		int lo = ((x >> i) & 1);
		int hi = ((x >> j) & 1);
		if (lo != hi) {
			x ^= ((1 << i) | (1 << j));
		}
		return x;
	}

	public static int reverseInt(int x) {
		for (int i = 0; i < 16; i++) {
			x = swapIntBits(x, i, 31 - i);
		}
		return x;
	}

	public static int reverseInt2(int x) {
		x = ((x & 0x55555555) << 1) | ((x & 0xAAAAAAAA) >> 1);
		x = ((x & 0x33333333) << 2) | ((x & 0xCCCCCCCC) >> 2);
		x = ((x & 0x0F0F0F0F) << 4) | ((x & 0xF0F0F0F0) >> 4);
		x = ((x & 0x00FF00FF) << 8) | ((x & 0xFF00FF00) >> 8);
		x = ((x & 0x0000FFFF) << 16) | ((x & 0xFFFF0000) >> 16);
		return x;
	}
	
	public static byte reverseByte(byte x) {
		int xi=x;
		for (int i = 0; i < 4; i++) {
			xi = swapIntBits( xi, i, 7 - i);
		//	System.out.println(i+":"+Integer.toBinaryString(xi));
		}
		return (byte)xi;
	}
	
	public static byte reverseByte2(byte x) {		
		x = (byte)( ((x & 0x55) << 1) | ((x & 0xAA) >> 1) );
		x = (byte)( ((x & 0x33) << 2) | ((x & 0xCC) >> 2) );  
		x = (byte)( ((x & 0x0F) << 4) | ((x & 0xF0) >> 4) );		 
		return x;
	}
	
	public static void printBits(byte a){
		String as2 = Integer.toBinaryString(a & 255 | 256);
		System.out.println(as2.substring(1));
	}

	public static void testReverseInt() {
		int x = 0xffff;
		System.out.println(Integer.toBinaryString(x));
		System.out.println(Integer.toBinaryString(reverseInt(x)));
		System.out.println(Integer.toBinaryString(reverseInt2(x)));

		System.out.println("-----------------------------");

		int x2 = 0xffff << 16;
		System.out.println(Integer.toBinaryString(x2));
		System.out.println(Integer.toBinaryString(reverseInt(x2)));
		System.out.println(Integer.toBinaryString(reverseInt2(x)));

	}
	
	public static void testReverseByte() {
		byte x = 0xf;
		printBits(x);
		printBits(reverseByte(x));
		printBits(reverseByte2(x));

		System.out.println("-----------------------------");

		byte x2 = (byte)(0xf << 4);
		printBits(x2);
		printBits(reverseByte(x2));
		printBits(reverseByte2(x2));
		
		System.out.println("-----------------------------");
		
		byte x3 = -5;
		printBits(x3);
		printBits(reverseByte(x3));
		printBits(reverseByte2(x3));


	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testReverseByte();
	}

}
