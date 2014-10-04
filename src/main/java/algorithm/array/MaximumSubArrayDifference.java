package algorithm.array;

import java.util.ArrayList;

import org.junit.Test;

/** 
 * Given an array with integers.
 * Find two non-overlapping subarrays A and B, which |SUM(A) - SUM(B)| is the largest.
 * 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-8-15 
 * Time : 上午11:09:36
 */

//还是前缀和给力！！！！

public class MaximumSubArrayDifference {
	
    public int maxDiffSubArrays(ArrayList<Integer> nums) {
        // write your code
    	int maxDiff = 0;
    	
    	for (int i = 1; i < nums.size(); i++){
    		int max1 = maximumSubArray(nums, 0, i - 1);
    		int min1 = minimumSubArray(nums, 0, i - 1);
    		
    		int max2 = maximumSubArray(nums, i, nums.size() - 1);
    		int min2 = minimumSubArray(nums, i, nums.size() - 1);
    		
    		int temp = Math.max(max1 - min2, min1 - max2);
    		maxDiff = Math.max(maxDiff, temp);
    	}
    	
    	return maxDiff;
    }
	
    
    public int maximumSubArray(ArrayList<Integer> nums, int start, int end){
    	int concateSum = 0;
    	int maxSum = 0;
    	
    	for (int i = start; i <= end; i++){
    		concateSum = Math.max(concateSum + nums.get(i),nums.get(i));
    		maxSum = Math.max(concateSum, maxSum);
    	}
    	return maxSum;
    }
	
    public int minimumSubArray(ArrayList<Integer> nums, int start, int end){
    	int concateSum = 0;
    	int minSum = Integer.MAX_VALUE;
    	
    	for (int i = start; i <= end; i++){

    		concateSum = Math.min(concateSum + nums.get(i),nums.get(i));
    		minSum = Math.min(concateSum, minSum);
    	}
    	
    	return minSum;
    }
    
    @Test
    public void test(){
    	MaximumSubArrayDifference msd = new MaximumSubArrayDifference();
    	ArrayList<Integer> input = new ArrayList<Integer>();
    	input.add(-2); input.add(1); input.add(-3);
    	input.add(4); input.add(-1); input.add(2); input.add(1);
    	input.add(-5); input.add(4);
    	
    	int max = msd.maximumSubArray(input, 0, input.size() -1);
    	int min = msd.minimumSubArray(input, 0, input.size()-1);
    	
    	System.out.println(max); //6
    	System.out.println(min); //-5
    	
    	ArrayList<Integer> input2 = new ArrayList<Integer>();
    	input2.add(1); input2.add(2); input2.add(-3); input2.add(1);
    	
    	int r = msd.maxDiffSubArrays(input2);
    	System.out.println(r);
    	
    }

}
