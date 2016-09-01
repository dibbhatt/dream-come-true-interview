package algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description :
 * Source : https://leetcode.com/problems/largest-divisible-subset/
 *  https://mp.weixin.qq.com/s?__biz=MzA5MzE4MjgyMw==&mid=2649455439&idx=1&sn=a51f9ce961d1c9ce429b3dfa7b8595fc&scene=1&srcid=0901JRzhCq5qBCDiR1nzJpXL&key=7b81aac53bd2393d91112d93c63597a678710a0651771b37085691bee4bcb9e293b71869b25069b5231595d166c31b0d&ascene=0&uin=MjM2NjQzODM2Mg%3D%3D&devicetype=iMac+MacBookPro10%2C1+OSX+OSX+10.10.5+build(14F27)&version=11020201&pass_ticket=m0i56ONaU0ck3hDrSmXI94oiDiUkLb%2B%2FULzohpsEgfklCUdtCWFYgJSHhoYkhw7U
 * Created_By : xmpy
 * Time : Sep 1, 2016 10:23:22 PM  
 */
public class LargestDivisibleSubset {
	public List<Integer> largestDivisibleSubset(int[] nums) {
		List<Integer> result = new ArrayList<Integer>();
		if (nums == null || nums.length == 0) {
			return result;
		}
		int[] steps = new int[nums.length];
		Arrays.fill(steps, 1);
		int[] pres = new int[nums.length];
		Arrays.fill(pres, -1);
		
		Arrays.sort(nums);
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] % nums[j] == 0) {
					if (steps[j] + 1 > steps[i]) {
						pres[i] = j;
						steps[i] = steps[j] + 1;
					}
				}
			}
		}
		int maxSteps = 0;
		int maxIdx = 0;
		for (int i = 0; i < nums.length; i++) {
			if (steps[i] > maxSteps) {
				maxSteps = steps[i];
				maxIdx = i;
			}
		}
		while(maxIdx != -1) {
			result.add(nums[maxIdx]);
			maxIdx = pres[maxIdx];
		}
		return result;
	}
}
