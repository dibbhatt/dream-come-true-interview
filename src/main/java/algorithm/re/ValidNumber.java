package algorithm.re;

import org.junit.Test;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-9-13 
 * Time : 下午8:24:20
 */
public class ValidNumber {
    public boolean isNumber(String s) {
        int start = 0; int end = s.length() - 1;
        while (start <= end && Character.isWhitespace(s.charAt(start))) start++;
        
        if (start > end) {
            return false;
        }
        
        while (end >= start && Character.isWhitespace(s.charAt(end))) end--;
        
        if (s.charAt(start) == '+' || s.charAt(start) == '-' ) start++;
        String input = s.substring(start, end + 1);
        if (input.charAt(0) <= '9' && input.charAt(0) >= '0') {
            return state1(input, 1);
        }
        if (input.charAt(0) == '.' ){
            return state2(input, 1);
        }
        return false;
    }
    
    public boolean state1(String s, int n) {
        if (n == s.length()) {
            return true;
        }
        
        if (s.charAt(n) <= '9' && s.charAt(n) >= '0') {
            return state1(s, n + 1);
        }
        
        if (s.charAt(n) == 'e' || s.charAt(n) == 'E') {
            return state4(s, n + 1);
        }
        
        if (s.charAt(n) == '.') {
            return state5(s, n + 1);
        }
        
        return false;
    }
    
    public boolean state2(String s, int n) {
        if (n == s.length()) {
            return false;
        }
        
        if (s.charAt(n) <= '9' && s.charAt(n) >= '0') {
            return state3(s, n + 1);
        }
        
        return false;
    }
    
    public boolean state3(String s, int n) {
        if (n == s.length()) {
            return true;
        }
        
        if (s.charAt(n) <= '9' && s.charAt(n) >= '0') {
            return state3(s, n + 1);
        }
        
        if (s.charAt(n) == 'e' || s.charAt(n) == 'E') {
            return state4(s, n + 1);
        }
        
        return false;
    }
    
    public boolean state4(String s, int n) {
        if (n == s.length()) {
            return false;
        }
        
        if (s.charAt(n) == '+' || s.charAt(n) == '-') {
        	n = n + 1;
        }
        if (n == s.length()) {
        	return false;
        }
        
        if (s.charAt(n) <= '9' && s.charAt(n) >= '0') {
            return state7(s, n + 1);
        }
        
        return false;
    }
    
    public boolean state5(String s, int n) {
        if (n == s.length()) {
            return true;
        }
        if (s.charAt(n) <= '9' && s.charAt(n) >= '0') {
            return state6(s, n + 1);
        }
        
        if (s.charAt(n) == 'e' || s.charAt(n) == 'E') {
            return state4(s, n + 1);
        }
        return false;
    }
    
    public boolean state6(String s, int n) {
        if (n == s.length()) {
            return true;
        }
        if (s.charAt(n) <= '9' && s.charAt(n) >= '0') {
            return state6(s, n + 1);
        }
        if (s.charAt(n) == 'e' || s.charAt(n) == 'E') {
            return state4(s, n + 1);
        }
        return false;
    }
    
    
    public boolean state7(String s, int n) {
    	if (n == s.length()) {
    		return true;
    	}
    	
    	if (s.charAt(n) <= '9' && s.charAt(n) >= '0') {
    		return state7(s, n + 1);
    	}
    	return false;
    }
    
    @Test
    public void test(){
    	String input =  "005047e+6";
    	boolean r = isNumber(input);
    	System.out.println(r);
    }
}
