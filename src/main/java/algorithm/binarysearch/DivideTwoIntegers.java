package algorithm.binarysearch;

import org.junit.Test;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-9-2 
 * Time : 下午3:56:10
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        
        int sign = 1;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)){
        	sign  = -1;
        }
        
        
        long dividend2 = Math.abs((long)dividend);
        long divisor2 = Math.abs((long)divisor);
       
        
        System.out.println(dividend2);
    	System.out.println(divisor2);

        
        if (dividend2 < divisor2) {
            return 0;
        }
        long start = 0;
        long end = dividend2;
  
        
        while (start + 1 < end) {
        	
            long mid = start + ((end - start) >> 1);

        	System.out.println("mid: " + mid);
        	System.out.println(start);
        	System.out.println(end);
            
            if (mid * divisor2 == dividend2) {
                return (int) (sign*mid);
            }
            
            if (mid * divisor2 > dividend2) {
                end = mid - 1;
            } else {
                start = mid;
            }
        }
        
        if (start * divisor2 == dividend2){
        	return (int)(sign * start);
        }
        
        if (end * divisor2 <= dividend2){
            return (int)(sign * end);
        }
        return (int)(sign * start);
    }
    
    @Test
    public void test(){
    	int r = divide(-2147483648, 1);
    	System.out.println(r);
    	
    	System.out.println( 2 + (4 - 2) >> 1);
    } 
}
