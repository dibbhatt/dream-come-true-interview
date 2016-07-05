package algorithm.dp;
/** 
 * Description :
 * Source : 
 * Created_By : zhaoxm (xmpy) 
 * Date : Apr 7, 2016 
 * Time : 12:01:06 AM
 */
public class HouseRobber2 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        
        if (len == 1) {
            return nums[0];
        } else if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        
        int[] status = new int[len];
        status[0] = nums[0];
        status[1] = nums[0];
        
        // Rob nums[0]
        for (int i = 2; i < len - 1; i++) {
            status[i] = Math.max(status[i - 1], status[i-2] + nums[i]);
        }
        
        int robFirstHouse = status[len - 2];
        
        status[0] = 0;
        status[1] = nums[1];
        for (int i = 2; i < len; i++) {
            status[i] = Math.max(status[i - 1], status[i-2] + nums[i]);
        }
        return Math.max(robFirstHouse, status[len - 1]);
    }
}
