package lintcode;

public class HashFunction {
	
	public static int hashCode2(char[] key,int HASH_SIZE) {
        // write your code here
        long sum = 0;
        int magic = 1;
        for (int i=key.length-1; i>=0; i--) {            
             sum += (key[i]*magic);
             sum %= HASH_SIZE;
             magic = (magic*33)%HASH_SIZE;
        }
        return (int)sum;
    }
	
	public static long hashCode1(char[] key,int HASH_SIZE) {
        // write your code here
        long sum = 0;
        int magic = 1;
        for (int i=key.length-1; i>=0; i--) {
             int c =  (int)key[i] ;
         //    System.out.println(key[i] + " " + c);
             sum += (key[i]*magic);              
             magic =  magic*33 ;
        }
        return sum%HASH_SIZE;
    }
	
	public static int hashCode3(char[] key,int HASH_SIZE) {  
	    int result = 0;  
	    for (int i = 0; i < key.length; i++) {  
	        result = helper(result, 33, HASH_SIZE);  
	        result += key[i];  
	        result %= HASH_SIZE;  
	    }  
	    return result;  
	}  
	  
	static int helper(int num, int base, int mod) {  
	    int result = 0;  
	    int temp = num - mod;  
	    for (int i = 0; i < base; i++) {  
	        if (result + temp > 0) {  
	            result += temp;  
	        } else {  
	            result += num;  
	        }  
	    }  
	    return result;  
	}  

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] key = "Wrong answer or accepted?".toCharArray();
		int size = 1000000007;
		System.out.println(hashCode1(key,size));
		System.out.println(hashCode2(key,size));
		System.out.println(hashCode3(key,size));
	}

}
