package algorithm.array;
/** 
 * Description :
 * Source : https://leetcode.com/problems/increasing-triplet-subsequence/
 * Created_By : zhaoxm (xmpy) 
 * Date : Mar 21, 2016 
 * Time : 10:48:11 PM
 */
public class IncreasingTripetSubsequence {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null) {
            return false;
        }
        int len = nums.length;
        if (len < 3) {
            return false;
        }
        
        int[] minArr = new int[len];
        int[] maxArr = new int[len];
        
        int min = nums[0];
        for (int i = 1; i < len; i++) {
            minArr[i] = min;
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        int max = nums[len -1];
        for (int i = len - 2; i >=0; i--) {
            maxArr[i] = max;
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        
        for (int i = 1; i < len - 1; i++) {
            if (minArr[i] < nums[i] && maxArr[i] > nums[i]) {
                return true;
            }
        }
    
        return false;
    }
}
