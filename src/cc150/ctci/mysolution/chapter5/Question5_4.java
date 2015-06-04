package ctci.mysolution.chapter5;

import ctci.CtCILibrary.AssortedMethods;

public class Question5_4 {
	
	// we can find i & (i-1) remove the last 1
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for ( int i=0 ; i<68; i++){
			System.out.println( i + ":" + ( i & (i-1)));
			System.out.println( AssortedMethods.toFullBinaryString(i));
			System.out.println( AssortedMethods.toFullBinaryString(i & (i-1)));
		}		
	}
}
