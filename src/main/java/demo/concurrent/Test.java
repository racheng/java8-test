package demo.concurrent;

/**
 * Created by leicheng on 17-7-14.
 */
public class Test {

	public static void main(String[] args) {
		Lock lock = new Lock();

		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					lock.take();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				lock.put();
			}
		});

		thread1.start();
		thread2.start();
	}
}
