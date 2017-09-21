package demo.lexicographical;

/**
 * Created by leicheng on 17-1-19.
 */
public class Solution {
	public int findKthNumber(int n, int k) {
		String s = String.valueOf(n);
		int length = s.length();
		int step = 0;
		int[] numChar = new int[length];
		int i = 0;
		numChar[i] = 1;
		step++;

		do {
			if (i < length - 1) {
				i++;
				numChar[i] = 0;
			} else {
				if (numChar[i] < 9) {
					numChar[i]++;
				} else {
					i = leftShift(i, numChar);
				}
			}
			if (toInt(numChar, i) <= n) {
				step++;
				if (step != k) {
					return toInt(numChar, i);
				}
			}
		} while (numChar[0] <= s.charAt(0));

		int[] newNum = new int[length - 1];
		newNum[0] = numChar[1];

		while (true) {
			if (i < length - 1) {
				i++;
				newNum[i] = 0;
			} else {
				if (newNum[i] < 9) {
					newNum[i]++;
				} else {
					i = leftShift(i, newNum);
				}
			}
			if (toInt(newNum, i) <= n) {
				step++;
				if (step != k) {
					return toInt(newNum, i);
				}
			}
		}
	}


	private int leftShift(int i, int[] numChar) {
		i = i-1;
		if (i >= 0) {

			if (numChar[i] == 9) {
				i = leftShift(i, numChar);
			} else {
				numChar[i]++;
			}
		}
		return i;
	}

	private int toInt(int[] numChar, int i) {
		String rs = "";
		for (int j = 0; j <= i; j++) {
			rs += numChar[j];
		}
		return Integer.parseInt(rs);
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int kthNumber = solution.findKthNumber(1692778, 1545580);
		System.out.println(kthNumber);
	}
}