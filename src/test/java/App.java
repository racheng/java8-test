import org.junit.Test;

/**
 * Created by leicheng on 16-11-14.
 */
public class App {

	public static void main(String[] args) {
		String ip = "123.123.123.123";
		String[] ipSplit = ip.split("\\.");
		int ipInt = 9999999;
		if (ipSplit.length == 4) {
			ipInt = Integer.parseInt(ipSplit[0]) * 255 * 255 * 255 + Integer.parseInt(ipSplit[1]) * 255 * 255
					+ Integer.parseInt(ipSplit[2]) * 255 + Integer.parseInt(ipSplit[3]);
		}
		System.out.println(ipInt);
	}

	@Test
	public void testInt() throws Exception {
		int a = 128 * 256 * 256 * 256;
		System.out.println(a);
	}
}
