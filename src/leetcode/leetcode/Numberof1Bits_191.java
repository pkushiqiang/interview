package leetcode;


public class Numberof1Bits_191 {
	
	public int hammingWeight(int n) {
        int res = 0;
        while ( n!= 0){ // not bigger or less, just equal  
            if ( (n & 1) > 0 )
                res++;
            n>>>=1; // unsigned shift
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
