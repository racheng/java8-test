package demo.trapping_rain;

/**
 * Created by leicheng on 17-6-21.
 */
public class Solution {

	public int trap(int[] height){
		int a=0;
		int b=height.length-1;
		int max=0;
		int leftmax=0;
		int rightmax=0;
		while(a<=b){
			leftmax=Math.max(leftmax,height[a]);
			rightmax=Math.max(rightmax,height[b]);
			if(leftmax<rightmax){
				max+=(leftmax-height[a]);       // leftmax is smaller than rightmax, so the (leftmax-height[a]) water can be stored
				a++;
			}
			else{
				max+=(rightmax-height[b]);
				b--;
			}
		}
		return max;
	}

	public int trap2(int[] a){
		int max = 0;
		int maxIndex;

		for (int i = 0; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
				maxIndex = i;
			}
		}





		return 0;
	}

	public int getLeftMaxIndex(int[] a, int start, int area) {

		int max = -1;
		int maxIndex = 0;
		for (int i = start - 1; i >= 0; i--) {
			if (a[i] > max) {
				max = a[i];
				maxIndex = i;
			}
		}
		area += maxIndex;
		return 0;
	}
}
