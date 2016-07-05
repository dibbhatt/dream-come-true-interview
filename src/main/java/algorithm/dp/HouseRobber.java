package algorithm.dp;
/** 
 * Description :
 * Source : 
 * Created_By : zhaoxm (xmpy) 
 * Date : Apr 5, 2016 
 * Time : 11:50:46 PM
 */
public class HouseRobber {
    public int rob(int[] nums) {
    	if (nums.length == 0) {
    		return 0;
    	}
    	
    	int[] notRobArr = new int[nums.length];
    	int[] robArr = new int[nums.length];

    	notRobArr[0]  = 0;
    	robArr[0] = nums[0];
    	
    	for (int i = 1; i < nums.length; i++) {
    		notRobArr[i] = Math.max(notRobArr[i- 1], robArr[i-1]);
    		robArr[i] = notRobArr[i - 1 ] + nums[i];
    	}
    	
    	
        return Math.max(notRobArr[nums.length - 1], robArr[nums.length - 1]);
    }
    public static void main(String[] args) {
    	HouseRobber hr = new HouseRobber();
    	int[] nums = new int[]{104,209,137};
    	int r = hr.rob(nums);
    	System.out.println(r);
    }
}
