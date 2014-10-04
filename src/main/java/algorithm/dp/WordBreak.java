package algorithm.dp;

import java.util.Set;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-7-27 
 * Time : 下午5:05:48
 */
public class WordBreak {
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] state = new boolean[s.length() + 1]; //长度为i的字符串能不能被cut
        state[0] = true; 
        
        
        for (int i = 1; i <= s.length(); i++){
            state[i] = false;
            for (int j = 0; j < i; j++){
                if (state[j] && dict.contains(s.substring(j, i))) {
                    state[i] = true;
                    break;
                }
            }
        }
        
        return state[s.length()];
    }
    
    /*
     * 下面是九章算法中讲的优化版本
     * 我们假设：单词的长度比字符串的长度比字符串的长度小很多
     */
    
    public int getMaxWordLen(Set<String> dict){
    	if(dict.size() == 0)
    		return 0;
    	
    	int maxLen = Integer.MIN_VALUE;
    	
    	for (String s: dict){
    		maxLen = Math.max(maxLen, s.length());
    	}
    	return maxLen;
    }
    
    public boolean wordBreakImproved(String s, Set<String> dict) {
        boolean[] state = new boolean[s.length() + 1]; //长度为i的字符串能不能被cut
        state[0] = true; 
        int maxLen = getMaxWordLen(dict);
        
        for (int i = 1; i <= s.length(); i++){
            state[i] = false;
            int startIndex = i - maxLen < 0 ? 0 : i - maxLen;
            for (int j = startIndex; j < i; j++){
                if (state[j] && dict.contains(s.substring(j, i))) {
                    state[i] = true;
                    break;
                }
            }
        }
        
        return state[s.length()];
    }
}
