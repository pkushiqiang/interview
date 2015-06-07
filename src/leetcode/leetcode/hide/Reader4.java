package leetcode.hide;

/*
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
   The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
   By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
   Note:
   The read function will only be called once for each test case.
 */

public class Reader4 {
	char[] file;
	int p = 0; 
	public Reader4(String str){
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

	public int read(char[] buf, int n) {
		char[] buffer = new char[4];
		int p = 0;
		int cur = 0;
		while ( p < n ){
			cur = read4(buffer);
			for (int i=0; i<cur && p<n; i++){
				buf[p++] = buffer[i];
			}
			if ( cur < 4)
				break;
		}
		return p;		
	}

	public static void test1(){
		String file = "12345678";
		Reader4 solution = new Reader4(file);
		char[] buf = new char[4];
		int n = solution.read4(buf);
		while ( n > 0 ){			
			System.out.println(n +"---" +  new String(buf).substring(0, n));
			n = solution.read4(buf);
		}
	}
	
	public static void test2(){
		String file = "123456789";
		Reader4 solution = new Reader4(file);
		int n = 5;
		char[] buf = new char[n];
		int r = solution.read(buf,n);
		System.out.println(r + " -- " + new String(buf));
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test2();
	}

}
