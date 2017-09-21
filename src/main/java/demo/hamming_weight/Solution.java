package demo.hamming_weight;

/**
 * Created by leicheng on 16-12-29.
 */
public class Solution {
	// you need to treat n as an unsigned value
	public int hammingWeight(int n) {
		long startTime = System.nanoTime();
		int count = 0;
		while (n != 0) {
			int i = n & 1;
			count += i;
			n = n >> 1;
		}
		long endTime = System.nanoTime();
		System.out.println(startTime);
		System.out.println(endTime);
		long offset = endTime - startTime;
		System.out.println(offset);
		return count;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
//		2147483648 (10000000000000000000000000000000)
//		int i = solution.hammingWeight((int) 2147483648L);
//		System.out.println(i);
		int i = (int) 2147483649L;
		long l = 2147483649L;
		System.out.println(l);
		System.out.println(i);
		String s = Integer.toBinaryString(i);
		int i1 = i >>> 1;
		int i2 = i >> 1;

		System.out.println(s);
		System.out.println(i1);
		System.out.println(Integer.toBinaryString(i1));
		System.out.println(i2);
		System.out.println(Integer.toBinaryString(i2));

	}
}