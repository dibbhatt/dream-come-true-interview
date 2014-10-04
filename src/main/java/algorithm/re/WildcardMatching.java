package algorithm.re;

import org.junit.Test;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : Aug 22, 2014 
 * Time : 4:43:45 PM
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
    	return isMatch(s, p, 0, 0);
    }
    
    public boolean isMatch(String s, String p, int start1, int start2){
        
        if (start2 == p.length()){
            if (s.length() != start1){
                return false;
            } else {
                return true;
            }
        }
        
        if (start1 == s.length()){
            if (p.charAt(start2) != '*'){
                return false;
            } else {
                int i = start2;
                for (; i < p.length(); i++){
                    if (p.charAt(i) != '*'){
                        break;
                    }
                }
                if (i == p.length()){
                    return true;
                } else {
                    return false;
                }
            }
        }
        
        
        if (p.charAt(start2) == '?') {
            return isMatch(s, p, start1 + 1, start2 + 1);
        }
        
        if (p.charAt(start2) == '*') {
            int i = start2;
            for (; i < p.length(); i++){
                if (p.charAt(i) != '*'){
                    break;
                }
            }
            for (int j = start1; j <= s.length(); j++){
                if (isMatch(s, p, j, i)){
                    return true;
                }
            }
            return false;
        }
        
        if (s.charAt(start1) == p.charAt(start2)){
            return isMatch(s, p, start1 + 1, start2 + 1);
        } else {
            return false;
        }     
    }
    
    @Test
    public void test(){
    	boolean r = isMatch("aa", "a*");
    	System.out.println(r);
    	
    	 r = isMatch("aa", "aa");
    	System.out.println(r);
    	
    	 r = isMatch("aa", "*");
    	System.out.println(r);
    	
    	r = isMatch("aab", "c*a*b");
    	System.out.println(r);
    	
    	r = isMatch("a", "*a*");
    	System.out.println(r);
    }
}
