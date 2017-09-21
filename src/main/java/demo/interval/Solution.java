package demo.interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leicheng on 17-1-20.
 */
public class Solution {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		ArrayList<Interval> leftInter = new ArrayList<>();
		ArrayList<Interval> rightInter = new ArrayList<>();
		int start = newInterval.start;
		int end = newInterval.end;
		for (Interval interval : intervals) {
			if (interval.end < start) {
				leftInter.add(interval);
			}
		}
		for (Interval interval : intervals) {
			if (interval.start > end) {
				rightInter.add(interval);
			}
		}

		intervals.removeAll(leftInter);
		intervals.removeAll(rightInter);
		for (Interval interval : intervals) {
			if (interval.start < start) {
				start = interval.start;
			}
			if (interval.end > end) {
				end = interval.end;
			}
		}
		leftInter.add(new Interval(start, end));
		leftInter.addAll(rightInter);

		return leftInter;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		ArrayList<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 2));
		intervals.add(new Interval(3, 5));
		intervals.add(new Interval(6, 7));
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(12, 16));

		List<Interval> result = solution.insert(intervals, new Interval(4, 9));
		for (Interval interval : result) {
			System.out.println(interval.start + "-" + interval.end);
		}

	}
}
