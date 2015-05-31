package mynote.learnbit;

public class BasicBitOps {
	
	public static int getBit(int num, int pos){
		return ( num & (1<<pos) ) > 0 ? 1:0 ;
	}
	
	public static boolean isOne(int num, int pos){
		return ( (num & (1<<pos)) != 0 );
	}
	
	public static int setBitAsOne(int num, int pos){
		 return  ( num | (1<<pos) )  ;
	}
	
	public static int clearBit (int num, int pos){
		 int mask = ~(1<<pos);
		 return num & mask;
	}
	
	public static int flipBits(int num){
		return ~num;
	}
	
	public static int clearBitsMSBthrougthI(int num, int i){
		// 00000111 255, 3
		// inclusive i
		int mask = ( 1 << i) -1;
		return num & mask;
	}
	
	public static int clearBitIBthrougth0(int num, int i){
		// 11110000     255, 3
		// inclusive i
		int mask = ~(  (1 << ( i + 1 )) -1 );
		return num & mask;
	}
	
	public static int updateBit(int num, int pos, int v){
		// 11110000
		int mask = ~(1 << pos );
		return (num & mask) | ( v << pos );
	}
	
	public static void testFlipBits(){
		int x = 4+2+1;
		System.out.println(Integer.toBinaryString(x));
		System.out.println(Integer.toBinaryString(flipBits(x)));
	}
	
	public static void testClearBits(){
		int x = ~0;
		System.out.println(Integer.toBinaryString(x));
		System.out.println(Integer.toBinaryString(clearBitsMSBthrougthI(x,5)));
		System.out.println(Integer.toBinaryString(clearBitIBthrougth0(x,5)));
		System.out.println("--------------------");
		x = 255;
		System.out.println(Integer.toBinaryString(x));
		System.out.println(Integer.toBinaryString(clearBitsMSBthrougthI(x,3)));
		System.out.println(Integer.toBinaryString(clearBitIBthrougth0(x,3)));
	}
	
	public static void testUpdateBit(){
		int i = 16+8+4+2+1;
		System.out.println(Integer.toBinaryString(i));
		i = updateBit(i, 0,0);
		i = updateBit(i, 3,0);
		i = updateBit(i, 4,0);
		i = updateBit(i, 4,1);
		i = updateBit(i, 6,1);
		System.out.println(Integer.toBinaryString(i));
	}
	
	public static void testGetBit(){
		int i= 16+4 + 2 + 1 ;
		System.out.println(Integer.toBinaryString(i));	
		for (int j=0; j<16; j++){
			System.out.println(j + ":" + getBit(i,j));	
		}
	}
	
	public static void testSetBitOne(){
		int i= 0 ;
		i = setBitAsOne(i,0); 
		i = setBitAsOne(i,1); 
		i = setBitAsOne(i,5); 
		System.out.println(Integer.toBinaryString(i));	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testFlipBits();
	}

}
