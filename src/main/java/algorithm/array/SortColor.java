package algorithm.array;

/**
 * Description :
 * Source : This problem is in **EPI chapter 6 section 6.1 page 62. Similar problem is in the Leetcode https://leetcode.com/problems/sort-colors/
 * Created_By : xmpy
 * Time : Aug 1, 2016 9:53:54 PM  
 */
public class SortColor {
	public void swap(int[] nums, int i, int j) {
	    if ( i == j ) {
	        return;
	    }
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
		
	}
	
	public void dutchFlagPartition(int nums[], int start, int end, int pivot) {
        if (nums == null || start >= end) {
            return;
        }
        
        int smaller = start;
        int larger = end;
        int equals = start;
        
        /* Loop invariants are:
         * [0, smaller) : less than 1
         * (smaller, equals) : equal to 1
         * [equals, larger) : unclassified
         * (larger, nums.length) : larger than 1
         */
        while (equals <= larger) {
        	int val = nums[equals];
        	if (nums[equals] < pivot) {
                swap(nums, smaller, equals);
                smaller++;
                equals++;
        	} else if (val == pivot) {
        		equals++;
        	} else {
        		swap(nums, larger, equals);
        		larger--;
        	}
        }	
	}
	
    public void sortColors(int[] nums) {
    	dutchFlagPartition(nums, 0, nums.length - 1, 1);
    }
}
