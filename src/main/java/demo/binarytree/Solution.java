package demo.binarytree;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by leicheng on 16-9-27.
 */
public class Solution {

	public static void main(String[] args) {
		TreeNode head = TreeFactory.getTreeRoot();
		Solution solution = new Solution();
		List<List<Integer>> lists = solution.pathSum(head, 22);
		System.out.println(JSON.toJSONString(lists));
	}

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<List<Integer>> resultList = new ArrayList<List<Integer>>();
		next(sum, root, 0, new Stack<Integer>(), resultList);
		return resultList;
	}

	private void next(int sum, TreeNode root, int previousSum, Stack<Integer> stack, List<List<Integer>> list) {
		if (root != null) {
			stack.push(root.val);
			int currentSum = previousSum;
			int val = root.val;
			TreeNode left = root.left;
			TreeNode right = root.right;
			currentSum += val;
			if (left == null && right == null && currentSum == sum) {
				list.add(new ArrayList<Integer>(stack));
			}
			next(sum, left, currentSum, stack, list);
			next(sum, right, currentSum, stack, list);
			stack.pop();
		}
	}
}
