package demo;

import java.util.TreeSet;

/**
 * Created by leicheng on 17-1-4.
 */
public class Find123Pattern {

	public boolean find132pattern(int[] nums) {

		for (int i = 0; i < nums.length; i++) {
			for (int j = i; j < nums.length; j++) {
				if (nums[j] - nums[i] > 1) {
					for (int k = j; k < nums.length; k++) {
						if (nums[i] < nums[k] && nums[k] < nums[j]) {
							return true;
						}
					}
				}
			}
		}

		return false;
	}

	public boolean findPattern(int[] nums) {
		int n = nums.length;
		if (n < 3) {
			return false;
		}

		int[] left = new int[n];
		left[0] = nums[0];
		for (int i = 1; i < n; i++) {
			left[i] = left[i-1] > nums[i] ? nums[i] : left[i-1];
		}

		TreeSet<Integer> set = new TreeSet<>();
		for (int i = n - 1; i >= 0; i--) {
			set.add(nums[i]);
			if (!set.headSet(nums[i], false).tailSet(left[i], false).isEmpty()) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Find123Pattern find123Pattern = new Find123Pattern();
//		boolean pattern = find123Pattern.find132pattern(new int[] { 3, 1, 4, 2 });
		boolean pattern = find123Pattern.find132pattern(new int[] {});

		System.out.println(pattern);
	}
}
