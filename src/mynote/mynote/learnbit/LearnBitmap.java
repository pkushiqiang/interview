package mynote.learnbit;

public class LearnBitmap {
	
	public static String getBits(byte b){
		String as2 = Integer.toBinaryString(b & 255 | 256);		 
		return as2.substring(1);		
	}
	
	public static byte swapByte(byte x){
		x = (byte) ( ( (x & 0b01010101) <<1 ) | ( (x & 0b10101010) >>> 1) );
		x = (byte) ( ( (x & 0b00110011) <<2 ) | ( (x & 0b11001100) >>> 2) );
		x = (byte) ( ( (x & 0b00001111) <<4 ) | ( (x & 0b11110000) >>> 4) );		
		return x;
	}
	
	public static byte[] createBitmap ( int width, int height){
		int bofr = width/8;
		return new byte[bofr*height];
	}
	
	public static String  drawBitmap(byte[] A, int width){
		String newline = System.getProperty("line.separator");
		StringBuilder sb = new StringBuilder();
		int rows = width/8;
		int height = A.length / rows;
		for (int i=0; i<height; i++){
			for (int j=0; j<rows; j++) {
				sb.append(getBits(A[i*rows+j]));
			}
			sb.append(newline);
		}
		return sb.toString();
	}
	
	public static void drawHLine(byte[] screen, int width,  int x1, int x2, int y){
		int height = screen.length*8/width;
		int byofrow = width/8;
		int startByte = byofrow*y+x1/8;
		int startBit = x1 % 8;
		int endByte = byofrow*y+x2/8;
		int endBit = x2%8;
			
		screen[startByte] |= (byte)  (0xFF>>>startBit);
		screen[endByte] |= (byte) ~( 0xFF>>> (endBit+1));
		
		for (int i=startByte+1; i<endByte; i++)
			screen[i] = (byte)0b1111_1111;		
	}
	
	public static void drawVLine(byte[] screen, int width,  int x, int y1, int y2){
		int height = screen.length*8/width;
		if ( y2>=height)
			return;
		int byofrow = width/8;
		int startByte = x/8;
		int mask =  1<<(7 - x % 8);
		 
		for (int i=y1; i<=y2; i++)
			screen[i*byofrow+startByte] |= mask;			 
	}
	
	public static void hReverse (byte[] A, int width){
		int height = A.length * 8 /width;
		int lr = width/8;
		for (int i=0; i<height ; i++){
			 int s = i*lr;
			 int e = i*lr + lr-1;
			 while ( s<=e){
				 byte tmp = A[s];
				 A[s] = swapByte(A[e]);
				 A[e] = swapByte(tmp);
				 s++;
				 e--;
			 }			 
		}
	}
	
	public static void vReverse (byte[] A, int width){
		int height = A.length * 8 /width;
		int lr = width/8;
		
		int i = 0;
		int j = height-1;
		while ( i < j) {
			for ( int k=0; k<lr; k++){
				byte tmp = A[i*lr+k];
				A[i*lr+k] = A[j*lr+k];
				A[j*lr+k] = tmp;
			}
			i++;
			j--;
		}
	}
	
	public static void setPoint(byte[] A, int w, int x, int y, int v){
		int lr = w/8;
		int bi = lr*y+x/8;
		int pos = 7-(x%8);
		int mask = ~(1 <<  pos);
		A[bi] = (byte) ( (A[bi]&mask) | ( v << pos)) ;
	}
	
	public static int  getPoint(byte[] A, int w, int x, int y){
		int lr = w/8;
		int bi = lr*y+x/8;
		int pos = 7 - (x%8);
		int mask = 1 <<  pos;
		return  (A[bi] & mask) == 0 ? 0:1;
	}
	
	public static void drawRect(byte[] A, int width, int x1, int y1, int x2, int y2){
		for (int i=y1 ; i<=y2; i++){
			drawHLine(A,width,x1,x2,i);
		}
	}
	
	public static byte[] rotateClockwise(byte[] A, int wa){
		byte[] B = new byte[A.length];
		int lra = wa/8;
		int ha = A.length/lra;	
		int wb = ha;
		
		for (int i=0; i<ha; i++) 
			for (int j=0; j<wa; j++) {				
				int v = getPoint(A, wa, j, i);
				setPoint(B, wb,  ha-1-i, j, v );
			}
		
		return B;
	}
	
	public static void test1(){
		byte[] A = createBitmap(16,8);
		String str = drawBitmap(A,16);
		System.out.print(str);
		
		System.out.println(" -----Draw a horizontal line ---");
		drawHLine(A, 16, 0,15,0);
		drawHLine(A, 16, 1,14,2);
		drawHLine(A, 16, 8,15,4);
		System.out.println(drawBitmap(A,16));
	}
	
	public static void test2(){
		int width = 24;
		byte[] A = createBitmap(width,6);	 
		
		System.out.println(" -----Draw a horizontal line ---");
		drawVLine(A, width, 0,0,5);
		drawVLine(A, width, 15,0,5);
		drawVLine(A, width, 23,3,5);
		drawVLine(A, width, 21,1,2);
		drawVLine(A, width, 21,4,5);
		drawHLine(A, width, 0,15,0);
		drawHLine(A, width, 1,14,2);
		
		for (int j=2; j<=5; j++)
			setPoint(A, width, j, 5, 1);		
		System.out.println(drawBitmap(A,width));
		for (int j=0; j<=5; j++)
			System.out.println(  "23:"+j +" is " + getPoint(A, width, 23, j));
	}
	
	public static void test3(){
		int width = 24;
		byte[] A = createBitmap(width,9); 

		drawVLine(A, width, 2,2,6);
		drawVLine(A, width, 4,4,8);		
		
		drawHLine(A, width, 3,12,2);
	//	drawHLine(A, width, 3,12,6);
		
		System.out.println(drawBitmap(A,width));
		hReverse(A,width);
		System.out.println(" -----  horizontal flip ---");
		System.out.println(drawBitmap(A,width));
		
		vReverse(A,width);
		System.out.println(" -----  vertical flip ---");
		System.out.println(drawBitmap(A,width));
		
		System.out.println(" -----  clockwise rotate  ---");
		byte[] B = rotateClockwise(A,width);
		System.out.println(drawBitmap(B, A.length*8/width));
	}
	
	public static void test4(){
		int width = 16;
		byte[] A = createBitmap(width,16); 

		drawRect(A, width, 0,0,12,12);		
		System.out.println(drawBitmap(A,width));
		
		System.out.println(" -----  clockwise rotate  ---");
		byte[] B = rotateClockwise(A,width);
		System.out.println(drawBitmap(B, A.length*8/width));
		
		System.out.println(" -----  clockwise rotate  ---");
		byte[] C = rotateClockwise(B,A.length*8/width);
		System.out.println(drawBitmap(C, width));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test4();
	}

}
