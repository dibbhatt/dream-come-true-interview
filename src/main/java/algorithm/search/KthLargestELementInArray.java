package algorithm.search;
/**
 * Description :
 * Source : Leetcode https://leetcode.com/problems/kth-largest-element-in-an-array/
 * Created_By : xmpy
 * Time : Jul 8, 2016 10:30:19 AM  
 */
public class KthLargestELementInArray {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1; // Invalid input
        }
        if ( k < 0 || k > nums.length ) {
            return -1; // Invalid input
        }
       
        int start = 0; 
        int end = nums.length - 1;
        
        while ( start <= end) {
        	// Get the pivot index. 
        	// Now, in the left part of nums[start .. end], these elements are bigger or equal than pivot.
            int pivotIdx = partition(nums, start, end);
            if ((pivotIdx - start  + 1) == k) {
            	return nums[pivotIdx];
            }
            
            if ((pivotIdx - start  + 1) < k) {
            	k = k - (pivotIdx - start  + 1);
            	start = pivotIdx + 1;
            } else {
            	end = pivotIdx - 1;
            }
        } 
        return -1; //Never happen!
    }
    
    public int findKthLargest(int[] nums, int k, int start, int end) {
        if (nums == null || end < start) {
            return -1; // Some erros happen.
        }
        int pivotIdx = partition(nums, start, end);
        int pivotTh = pivotIdx - start;

        if ( k == (pivotTh + 1)) {
            return nums[pivotIdx];
        }
        if ( k > (pivotTh + 1)) {
            return  findKthLargest(nums, (k - pivotTh - 1), pivotIdx + 1, end);
        } 
        return  findKthLargest(nums, k, start, pivotIdx - 1);
    }
    
    
    public int partition(int[] nums, int start, int end) {
        int pivot = nums[start];
        assert(end >= start);
        if (start == end) {
            return start;
        }
        int s = start;
        int e = end;
        
        while (s < e) {
            while ( s < e && nums[e] < pivot) {
                e--;
            }   
            nums[s] = nums[e];
            
            while ( s < e && nums[s] >= pivot ) {
                s++;
            }
            nums[e] = nums[s];
        } // When s == e, break this loop.
        nums[s] = pivot;
        return s;
    }
}
