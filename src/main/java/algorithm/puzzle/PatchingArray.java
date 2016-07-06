package algorithm.puzzle;

/**
 * Description :
 * Source : Leetcode https://leetcode.com/problems/patching-array/
 * Created_By : xmpy
 * Time : Jul 6, 2016 11:30:19 PM  
 */
public class PatchingArray {
    public int minPatches(int[] nums, int n) {
        if ( nums == null ) {
            return -1;
        }
        long canReach = 0;
        int ret = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if ( nums[i] > (canReach + 1)) {
                while ((canReach + 1) < nums[i]) {
                    ret += 1; // Add canReach + 1;
                   // System.out.println("Add " + (canReach + 1));
                    canReach += canReach + 1;
                    if (canReach >= n) {
                    	return ret;
                    }
                }   
            } 
            canReach += nums[i];
           // System.out.println(canReach);

            if (canReach >= n) {
                return ret;
            }
        } 
        
        // If add all elements still can not reach n;
        while (canReach < n) {
            ret += 1; // Add canReach + 1;
            canReach += canReach + 1;

        }
        return ret;
    }
}
