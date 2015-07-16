package mynote.multithread;

public class SynchronizedKeyword1 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Thread(new Thread1()).start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(new Thread2()).start();
	}

	private static class Thread1 implements Runnable {
		@Override
		public void run() {
			/*
			 * 由于这里的Thread1 和下面的Thread2 内部run 方法要用同一对象作为监视器，我们这里
			 * 不能用this，因为在Thread2 里面的this 和这个Thread1 的this 不是同一个对象。我们
			 * 用MultiThread.class 这个字节码对象，当前虚拟机里引用这个变量时，指向的都是同一个 对象。
			 */
			synchronized (SynchronizedKeyword1.class) {
				System.out.println("enter thread1...");
				System.out.println("thread1 is waiting");
				try {
					/*
					 * 释放锁有两种方式，第一种方式是程序自然离开监视器的范围，也就是离开了 synchronized
					 * 关键字管辖的代码范围，另一种方式就是在synchronized 关键字管辖的代 码内部调用监视器对象的wait
					 * 方法。这里，使用wait 方法释放锁。
					 */
					SynchronizedKeyword1.class.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println("thread1 has be waked up!!");
					e.printStackTrace();
				}
				System.out.println("thread1 is going on...");
				System.out.println("thread1 is being over!");
			}
		}
	}

	private static class Thread2 implements Runnable {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			synchronized (SynchronizedKeyword1.class) {
				System.out.println("enter thread2...");
				System.out
						.println("thread2 notify other thread can release wait status..");
				/*
				 * 由于notify 方法并不释放锁， 即使 thread2 调用下面的sleep 方法休息了10 毫秒，但 thread1
				 * 仍然不会执行，因为thread2 没有释放锁，所以Thread1 无法得不到锁。
				 */
				SynchronizedKeyword1.class.notify();
				System.out.println("thread2 is sleeping ten millisecond...");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("thread2 is going on...");
				System.out.println("thread2 is being over!");
			}
		}
	}
}
