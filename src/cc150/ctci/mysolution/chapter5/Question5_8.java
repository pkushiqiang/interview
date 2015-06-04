package ctci.mysolution.chapter5;

public class Question5_8 {
	// more bitmap operation see my note codes
	public static void drawHLine(byte[] screen, int width,  int x1, int x2, int y){
		
		int byofrow = width/8;
		int startByte = byofrow*y+x1/8;
		int startBit = x1 % 8;
		int endByte = byofrow*y+x2/8;
		int endBit = x2%8;		
	
		screen[startByte] = (byte)  (0xFF>>>startBit);
		for (int i=startByte+1; i<endByte; i++)
			screen[i] = (byte)0b1111_1111;				
		screen[endByte] = (byte) ~( 0xFF>>> (endBit+1));
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
