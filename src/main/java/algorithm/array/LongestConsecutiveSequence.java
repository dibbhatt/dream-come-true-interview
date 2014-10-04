package algorithm.array;

import java.util.HashSet;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-8-5 
 * Time : 下午9:49:40
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
    	int result = 1;
    	HashSet<Integer> set = new HashSet<Integer>();
    	
    	for (int i = 0; i < num.length; i++){
    		set.add(num[i]);
    	}
    	
    	for (int i = 0; i < num.length; i++){
    		int maxL = 1;
    		if(set.contains(num[i])){
    			int mid = num[i];
    			set.remove(mid);
    			for (int j = 1; set.contains(mid+j);j++){
    				set.remove(mid+j);
    				maxL += 1;
    			}
    			for (int j = 1; set.contains(mid -j); j++){
    				set.remove(mid-j);
    				maxL += 1;
    			}
    			if(maxL > result){
    				result = maxL;
    			}
    		}
    	}
    	
    	return result;
    }
}
