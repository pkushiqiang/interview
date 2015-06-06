package mynote.learnbit;
// this bitmap is not multiple of 8
public class LearnBitmap2 {
	
	public static byte[] createBitmap ( int width, int height){
		int nb = width*height/8 + width*height%8 == 0 ? 0:1;
		return new byte[nb];
	}
	
	public static int getByteIn( int w, int x, int y){
		return (y*w+x)/8;
	}
	
	public static String  drawBitmap(byte[] A, int width){
		String newline = System.getProperty("line.separator");
		StringBuilder sb = new StringBuilder();		 
		int height = A.length*8 / width;
		int rbn = width/8;
		for (int i=0; i<height; i++){
			for (int j=0; j<rbn; j++) {
				sb.append(getBits(A[i*rows+j]));
			}
			sb.append(newline);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
