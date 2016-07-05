package algorithm.slidingwindow;

import org.junit.Test;

/** 
 * Description :
 * Source : 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-11-29 
 * Time : 下午10:46:53
 */
public class LengthOfLongestSubstringTwoDistinct {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
    	if (s == null || s.length() == 0) {
    		return 0;
    	}
    	
    	
        // start
        int begin = 0;
        int already = 1;
        int maxLen = 1;
        
        char pre = s.charAt(0);
        char[] chars = new char[2];
        
        chars[0] = pre;
        
        int j = 1;
        for (; j < s.length(); j++) {
            if (s.charAt(j) != pre) {
                break;
            }
        }

        if (j == s.length()){
            return s.length();
        }
    
        chars[1] = s.charAt(j);
        pre = chars[1];
        already = 1;
        for (int end = j + 1; end < s.length(); end++) {
            if (s.charAt(end) == pre) {
                already++;
                continue;
            }
            if (s.charAt(end) != chars[0] && s.charAt(end) != chars[1])
            {
                maxLen = Math.max(maxLen, end - begin);
                begin = end - already;
                pre = s.charAt(end);
                already = 1;
            }  else {
                pre = s.charAt(end);
                already = 1;
            }
            
        }
        return Math.max(maxLen, s.length() - begin);
    }
    
    @Test
    public void test() {
    	String s = "eceba";
    	int len = lengthOfLongestSubstringTwoDistinct(s);
    	System.out.println(len);
    }
}
