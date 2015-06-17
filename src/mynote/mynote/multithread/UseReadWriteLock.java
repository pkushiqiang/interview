package mynote.multithread;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


	class UseReadWriteLock {  
	    /* �������ݣ�ֻ��һ���߳�д���ݣ����Զ���̶߳����� */  
	    private Object data = null;  
	    /* ����һ����д�� */  
	    ReadWriteLock rwlock = new ReentrantReadWriteLock();  
	  
	    /** 
	     * �����ݣ����Զ���߳�ͬʱ���� �����϶������� 
	     */  
	    public void get() {  
	        /* �϶��� */  
	        rwlock.readLock().lock();  
	  
	        try {  
	            System.out.println(Thread.currentThread().getName() + " ׼��������!");  
	            /* ���� */  
	            Thread.sleep((long) (Math.random() * 1000));  
	            System.out.println(Thread.currentThread().getName() + "����������Ϊ :" + data);  
	        } catch (InterruptedException e) {  
	            e.printStackTrace();  
	        } finally {  
	            rwlock.readLock().unlock();  
	        }  
	  
	    }  
	  
	    /** 
	     * д���ݣ�����̲߳���ͬʱ д ���Ա�����д�� 
	     *  
	     * @param data 
	     */  
	    public void put(Object data) {  
	  
	        /* ��д�� */  
	        rwlock.writeLock().lock();  
	  
	        try {  
	            System.out.println(Thread.currentThread().getName() + " ׼��д����!");  
	            /* ���� */  
	            Thread.sleep((long) (Math.random() * 1000));  
	            this.data = data;  
	            System.out.println(Thread.currentThread().getName() + " д�������: " + data);  
	  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        } finally {  
	            rwlock.writeLock().unlock();  
	        }  
	    }  
	  
	/** 
	 * ������ 
	 *  
	 * @author Liao 
	 *  
	 */  
	 
	  
	    public static void main(String[] args) {  
	  
	        /* ����ReadWrite���� */  
	        final UseReadWriteLock readWrite = new UseReadWriteLock();  
	  
	        /* ����������3�����߳� */  
	        for (int i = 0; i < 3; i++) {  
	            new Thread(new Runnable() {  
	  
	                @Override  
	                public void run() {  
	                    readWrite.get();  
	  
	                }  
	            }).start();  
	              
	            /*����3��д�߳�*/  
	            new Thread(new Runnable() {  
	                  
	                @Override  
	                public void run() {  
	                    /*���д��һ����*/  
					readWrite.put(new Random().nextInt(8));  
	                      
	                }  
	            }).start();  
	        }  
	          
	    }  
	  
	
}
