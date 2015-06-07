package leetcode.hide;

/*
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
 */

import java.util.*;
public class Reader4II {
	
	char[] file;
	int p = 0; 
	public Reader4II(String str){
		file = str.toCharArray();
	}

	public int read4(char[] buf) {
		int len = 0;
		int i=0;
		for ( ; i<4 && p<file.length ; i++){
			buf[i]= file[p++];
		}
		return i;
	}
	
	List<Character> list  = new LinkedList<>();
	int limit = Integer.MAX_VALUE;
	int pc = 0;
	
	private int copy(char[] buf, int n ){
		for (int i=0; i<n; i++){
			buf[i] = list.get(i);
		}
		return n;
	}
	
	public int read(char[] buf, int n) {
		
		if (list.size() >= n){
			return copy(buf , n);
		}
		
		if ( n>limit){
			return copy(buf , limit);
		}
		
		char[] buffer = new char[4];
		
		int cur = 0;
		while ( pc < n ){
			cur = read4(buffer);
			for (int i=0; i<cur ;  i++){
				list.add( buffer[i]);
				pc++;
			}
			if ( cur < 4){
				limit = pc;
				break;
			}
				
		}
		return read( buf,  n);		
	}

	public static void test1(){
		String file = "12345678";
		Reader4II solution = new Reader4II(file);
		char[] buf = new char[4];
		int n = solution.read4(buf);
		while ( n > 0 ){			
			System.out.println(n +"---" +  new String(buf).substring(0, n));
			n = solution.read4(buf);
		}
	}
	
	public static void test2(){
		String file = "123456789abc";
		Reader4II solution = new Reader4II(file);
		int n = 5;
		
		for (int i=0; i<15; i++) {
			char[] buf = new char[i];
			int r = solution.read(buf,i);
			System.out.println(r + " -- " + new String(buf));
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test2();
	}

}
