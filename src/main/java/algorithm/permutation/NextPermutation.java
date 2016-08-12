package algorithm.permutation;

import java.util.Arrays;
import java.util.Collections;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return;
        }
        
        int start = nums.length - 2;
        for ( ; start >= 0; start--) {
            if (nums[start] < nums[start + 1]) {
                break;
            }
        }
        // The last permutation
        if (start == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        
        for (int i = nums.length - 1; i > start; i--) {
            if (nums[i] > nums[start]) {
                int temp = nums[start];
                nums[start] = nums[i];
                nums[i] = temp;
                break;
            }
        }
        //reverse(nums, start + 1, nums.length - 1);
        Collections.reverse(Arrays.asList(nums).subList(start + 1, nums.length));
    }
    
    public void reverse(int[] nums, int start, int end) {
        while(start < end) {
            if (nums[start] != nums[end]) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }
            start++;
            end--;
        }
    }
}
