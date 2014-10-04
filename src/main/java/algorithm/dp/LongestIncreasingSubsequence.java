package algorithm.dp;
/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-7-27 
 * Time : 下午3:11:16
 */
public class LongestIncreasingSubsequence {
    /**
     * Given a sequence of integers, find the longest increasing subsequence (LIS).
     * For [5, 4, 1, 2, 3], the LIS  is [1, 2, 3], return 3
       For [4, 2, 4, 5, 3, 7], the LIS is [4, 4, 5, 7], return 4
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        // state: 以i为结尾的最长增长序列的长度
        // state function: f[i] = max(f[j]) + 1 if j < i and a[j] <= a[i] 
        // initial: f[i] = 1
        
        int[] state = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++){
            state[i] = 1;
        }
        
        for (int i = 1; i < nums.length; i++){
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++){
                if (nums[j] <= nums[i])
                    max = Math.max(max, state[j]);
            }
            max = max < 0 ? 0 : max;
            state[i] = max + 1;
        }
        
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < state.length; i++){
            maxLen = Math.max(maxLen, state[i]);
        }
        return maxLen;
    }
}
