package ctci.mysolution.chapter5;

import ctci.CtCILibrary.AssortedMethods;

public class Question5_6 {
	
	public static int swapOddEven(int x){
		int x1 = x & 0x55555555;
		int x2 = x & 0xAAAAAAAA;
		return (x1<<1)|(x2>>>1);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 0b010101;
		System.out.println(AssortedMethods.toFullBinaryString(x)  );
		System.out.println(AssortedMethods.toFullBinaryString(swapOddEven(x))  );
		
	}
}
