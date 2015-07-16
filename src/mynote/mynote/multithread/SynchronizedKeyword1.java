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
			 * ���������Thread1 �������Thread2 �ڲ�run ����Ҫ��ͬһ������Ϊ����������������
			 * ������this����Ϊ��Thread2 �����this �����Thread1 ��this ����ͬһ����������
			 * ��MultiThread.class ����ֽ�����󣬵�ǰ������������������ʱ��ָ��Ķ���ͬһ�� ����
			 */
			synchronized (SynchronizedKeyword1.class) {
				System.out.println("enter thread1...");
				System.out.println("thread1 is waiting");
				try {
					/*
					 * �ͷ��������ַ�ʽ����һ�ַ�ʽ�ǳ�����Ȼ�뿪�������ķ�Χ��Ҳ�����뿪�� synchronized
					 * �ؼ��ֹ�Ͻ�Ĵ��뷶Χ����һ�ַ�ʽ������synchronized �ؼ��ֹ�Ͻ�Ĵ� ���ڲ����ü����������wait
					 * ���������ʹ��wait �����ͷ�����
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
				 * ����notify ���������ͷ����� ��ʹ thread2 ���������sleep ������Ϣ��10 ���룬�� thread1
				 * ��Ȼ����ִ�У���Ϊthread2 û���ͷ���������Thread1 �޷��ò�������
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
