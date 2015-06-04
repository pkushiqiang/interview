package ctci.mysolution.chapter5;

import ctci.CtCILibrary.AssortedMethods;

public class Question5_5 {
	
	public static int getDistance(int a, int b){
		int c = 0;
		for( int i=0; i<32; i++){
			if ( (a&1) != (b&1))
				c++;
			a>>>=1;
			b>>>=1;
		}		
		return c;
	}
	
	public static int bitSwapRequired(int a, int b) {
		int count = 0;
		for (int c = a ^ b; c != 0; c = c >> 1) { 
			count += c & 1;
		}
		return count;
	}
	
	public static int bitSwapRequired2(int a, int b){
		int count = 0;
		for (int c = a ^ b; c != 0; c = c & (c-1)) {
			count++;
		}
		return count;
	}
	
	
	public static void main(String[] args) {
		int a = 23432;
		int b = 512132;
		System.out.println(a + " : " + AssortedMethods.toFullBinaryString(a));
		System.out.println(b + ": " + AssortedMethods.toFullBinaryString(b));
		int nbits = getDistance(a, b);
		int nbits2 = bitSwapRequired(a, b);
		System.out.println("Required number of bits: " + nbits + " " + nbits2);
	}
}
