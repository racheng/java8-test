package demo.concurrent;

/**
 * Created by leicheng on 17-7-14.
 */
public class MyWaitNotify {

	MonitorObject myMonitorObject = new MonitorObject();

	public void doWait() {
		synchronized (myMonitorObject) {
			try {
				myMonitorObject.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void doNotify() {
		synchronized (myMonitorObject) {
			myMonitorObject.notify();
		}
	}

}
