package algorithm.queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/** 
 * Description : 
 * Source : 
 * Created_By : zhaoxm (xmpy) 
 * Date : Aug 4, 2015 
 * Time : 11:54:31 PM
 */
public class SlidingWindowMaximum {
	
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> maxQueue = new LinkedList<Integer>();
                if (nums.length == 0) {
        	return new int[]{};
        }
        int n = nums.length;
        int[] result = new int[n-k+1];

        for (int i = 0; i < k; i++) {
        	Integer peek = maxQueue.peek();
        	if (peek == null || nums[i] <= peek) {
        		while (maxQueue.peekLast() != null && nums[i] > maxQueue.peekLast() ) {
        			maxQueue.pollLast(); // Remove it, it has no chance!
        		}
        		maxQueue.add(nums[i]);
        	}
        	else{
        		maxQueue.clear();
        		maxQueue.add(nums[i]);
        	} 
        }
        
        result[0] = maxQueue.peek();
        int nn = 1;
        
        for (int i = k; i < n; i++) {
        	Integer peek = maxQueue.peek();
        	// Remove
        	if (peek == nums[i - k]) {
        		maxQueue.poll();
        	}
        	peek = maxQueue.peek();
        	if (peek == null || nums[i] <= peek) {
        		while (maxQueue.peekLast() != null && nums[i] > maxQueue.peekLast() ) {
        			maxQueue.pollLast(); // Remove it, it has no chance!
        		}
        		maxQueue.add(nums[i]);
        	}
        	else{
        		maxQueue.clear();
        		maxQueue.add(nums[i]);
        	} 
        	peek = maxQueue.peek();

        	result[nn] = peek;
        	nn++;
        }
        return result;
    }
    
    public static void main(String[] args) {
    	int[] input = new int[]{1,3,-1,-3,5,3,6,7};
    	int k = 3;
        int[] r = maxSlidingWindow(input, k);
        for (int i = 0; i < r.length; i++) {
        	System.out.println(r[i]);
        }
    }
}
