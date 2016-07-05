package algorithm.array;

import java.util.ArrayList;
import java.util.List;

/** 
 * Description :
 * Source : 
 * Created_By : zhaoxm (xmpy) 
 * Date : Jul 30, 2015 
 * Time : 11:57:45 PM
 */
public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<String>();
        if (lower > upper) {
        	return result;
        }
        
        if (nums.length == 0) {
        	if (lower == upper) {
        		result.add("" + lower);
        	} else {
        		result.add(lower + "->" + upper);
        	}
        	return result;
        }
        
        if (nums[0] == lower) {
        	//do nothing
        } else if (nums[0] == (lower + 1)){
        	result.add(""+(lower));
        } else {
        	result.add(lower + "->" + (nums[0]-1));
        }
        
        int pre = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - pre;
            if (diff == 0 || diff == 1) {
                // do nothing
            } else if (diff == 2) {
                result.add("" + (pre + 1));
            } else {
                result.add( (pre+1) + "->" + (nums[i] - 1));
            }
            pre = nums[i];
        }
        int diff = upper - pre;
        if (diff == 0) {
            // do nothing
        } else if (diff == 1) {
            result.add(""+ (upper));
        }else {
                result.add( (pre+1) + "->" + (upper ));
        }
        
        return result;
    }
}
