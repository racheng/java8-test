package demo.concurrent;

/**
 * Created by leicheng on 17-7-14.
 */
public class Lock {

	public synchronized void take() throws InterruptedException {
		int a = 1;
		this.wait();
		Thread.sleep(2000L);

		System.out.println(a);
	}

	public synchronized void put() {
		int b = 2;
		System.out.println(b);
		this.notify();

	}
}
