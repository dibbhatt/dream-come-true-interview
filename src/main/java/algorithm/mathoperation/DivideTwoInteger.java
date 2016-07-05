package algorithm.mathoperation;

import org.junit.Test;

/** 
 * Description : Divide two integers without using multiplication, division and mod operator.
 * Source : Leetcode https://oj.leetcode.com/problems/divide-two-integers/
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-10-5 
 * Time : 下午3:13:50
 */
public class DivideTwoInteger {
	
    public int divide(int dividend, int divisor) {
        boolean negative = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
        long divd = Math.abs((long)dividend);
        long divs = Math.abs((long)divisor);
        int r = 0;
        
        int shift = 0;
        while ((divs << shift) <= divd) {
        	shift++;
        }
        
        while (divd >= divs && shift > 0) {
        	shift--;
        	// judge whether the shift-th bit is one 每次求一位
        	if ((divs << shift) <= divd) {
        		r += 1 << shift;
        		divd -= divs << shift;
        	}
        }
        
        return negative ? - r : r;
    }
    
    @Test
    public void test() {
    	System.out.println(divide(0, 1));
    }
}
