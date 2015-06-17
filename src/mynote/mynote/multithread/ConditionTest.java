package mynote.multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					new Test1().sub1();

				}
			}).start();

			new Thread(new Runnable() {

				@Override
				public void run() {
					new Test1().sub2();

				}
			}).start();

			new Thread(new Runnable() {

				@Override
				public void run() {
					new Test1().sub3();

				}
			}).start();
		}
	}

}

class Test1 {
	public static int i = 0;
	public static int conNum = 1;
	// �˴�ע������conditionҲҪ����ɾ�̬�ģ���Ȼ���ж������condition��,�൱��û��һ����
	public static Lock lock = new ReentrantLock(false);
	public static Condition con1 = lock.newCondition();
	public static Condition con2 = lock.newCondition();
	public static Condition con3 = lock.newCondition();

	// ����1��i���м�1
	public void sub1() {
		lock.lock();
		try {
			while (conNum != 1) {
				try {
					con1.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			i++;
			System.out.print(i + ",");
			conNum = 2;
			con2.signal();
		} finally {
			lock.unlock();
		}

	}

	// ����2��i��2
	public void sub2() {
		lock.lock();

		try {
			while (conNum != 2) {
				try {
					con2.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			i = i + 2;
			System.out.print(i + ",");
			conNum = 3;
			con3.signal();
		} finally {
			lock.unlock();
		}

	}

	// ����3��i��3;
	public void sub3() {
		lock.lock();
		try {
			while (conNum != 3) {
				try {
					con3.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			i = i + 3;
			System.out.print(i + ",");
			conNum = 1;
			con1.signal();
		} finally {
			lock.unlock();
		}
	}
}