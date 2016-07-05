package algorithm.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/** 
 * Description :
 * Source : 
 * Created_By : zhaoxm (xmpy) 
 * Date : Apr 7, 2016 
 * Time : 11:51:28 PM
 */
public class LengthOfLongestSubstringKDistinct {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
    	if (k == 0) {
    		return 0;
    	}
        Map<Character, Integer> countMap = new HashMap<Character, Integer>();
        int distinctCount = 0;
        int maxLen = 0;
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            Character c = s.charAt(j);
            if (!countMap.containsKey(c)) {
                if (distinctCount == k) {
                    maxLen = Math.max(maxLen, j - i );
                    int beforeI = i;
                    for (int ii = beforeI; ii < j; ii++) {
                        Character cc = s.charAt(ii);
                        countMap.put(cc, countMap.get(cc) - 1);
                        if (countMap.get(cc) == 0) {
                            countMap.remove(cc);
                            i = ii + 1;
                            break;
                        }
                    }
                    countMap.put(c, 1);
                    
                } else {
                    countMap.put(c, 1);
                    distinctCount++;
                }
            } else {
                countMap.put(c, countMap.get(c) + 1);
            }
        }
        
        maxLen = Math.max(maxLen, (s.length() - i));
        return maxLen;
    }
    
    public static void main(String[] args) {
    	
    }
}
