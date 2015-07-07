package ctci.mysolution.chapter10;

public class BitSet {
	
	int[] bitset;
	
	public BitSet(int size) {
		bitset = new int[size>>5];
	}
	
	public boolean get(int pos) {
		int wordNumber = (pos>>5);
		int bitNumber = pos & 0x1F;
		return (bitset[wordNumber] & ( 1<< bitNumber)) != 0;
	}
	
	
	public void set (int pos) {
		int wordNumber = (pos>>5);
		int bitNumber = pos & 0x1F;
		bitset[wordNumber] |=  1<< bitNumber ;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
