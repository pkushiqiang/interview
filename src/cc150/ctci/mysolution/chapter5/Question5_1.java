package ctci.mysolution.chapter5;


import ctci.CtCILibrary.AssortedMethods;
public class Question5_1 {
	
	public static void testMask(){
		int j =12, i=4;
		int mask1 = (1<<(j+1))-1 ;
		int mask2 = ( 1<< (i+1) ) -1;
		int mask = mask1 - mask2;
		System.out.println(AssortedMethods.toFullBinaryString(mask1) + " mask1");
		System.out.println(AssortedMethods.toFullBinaryString(mask2) + " mask2");
		System.out.println(AssortedMethods.toFullBinaryString(mask) + " mask");
	}
	
	public static int updateBits(int n, int m, int i, int j) {
		int mask = (1<<j+1)-1 - ( (1<< i+1) -1);
		System.out.println(AssortedMethods.toFullBinaryString(mask) + " mask");
		return n & (~mask) | (m<<i);
	}
	
	public static void test1(){
		int a = 103217;
		System.out.println(AssortedMethods.toFullBinaryString(a));
		int b = 13;
		System.out.println(AssortedMethods.toFullBinaryString(b));		
		int c = updateBits(a, b, 4, 12);
		System.out.println(AssortedMethods.toFullBinaryString(c));
	}
	
	public static void test2(){
		int a = 0b00000000_11111111_00000000_11111111;
		System.out.println(AssortedMethods.toFullBinaryString(a));
		int b = 0b11001100_00110011;
		System.out.println(AssortedMethods.toFullBinaryString(b));		
		int c = updateBits(a, b, 16, 31);
		System.out.println(AssortedMethods.toFullBinaryString(c));

	}
	
	public static void main(String[] args) {
		test2();
			}

}
