package mynote.multithread;

public class VolatileTest {
	
	volatile boolean mFlag = false;

	public static void main(String[] args) {
		final VolatileTest mVolTest = new VolatileTest();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				while (!mVolTest.mFlag) {
					System.out.println("Working ...");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException ie) {
						//
					}
				}
			}
		}, "t1");
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(3000); // 3√Î∫ÛÕ£÷πœﬂ≥Ãt1
					mVolTest.mFlag = true;
					System.out.println("set flag to true");
				} catch (InterruptedException ie) {
					//
				}
			}
		}, "t2");
		
		t1.start();
		t2.start();
		
		
	}
}