package demo.duplicate;

/**
 * Created by leicheng on 16-10-9.
 */
public class Solution {
	public int removeDuplicates(int[] nums) {
		int pointer = 0;
		int next = 0;
		while (next< nums.length) {
			nums[pointer] = nums[next];
			if (pointer >= 2 && nums[pointer] == nums[pointer - 2]) {
				next++;
			} else {
				next++;
				pointer++;
			}
		}

		return pointer;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = new int[] { 1, 1, 1, 2, 2, 2, 2, 2, 3 };

		int i = solution.removeDuplicates(nums);
		System.out.println(i);

	}
}
