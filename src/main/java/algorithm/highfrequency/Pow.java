package algorithm.highfrequency;

import org.junit.Test;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-8-15 
 * Time : 下午9:40:03
 */
public class Pow {
    public double pow(double x, int n) {
        if (n == 0){
            return 1;
        }
        
        if (n == 1){
            return x;
        }
        
        if (n == -1){
        	return 1/x;
        }
        
        
        double temp = pow(x, n/2);
        
        return temp*temp*pow(x, n - (n/2)*2);
    }
    
    
    @Test
    public void test(){
    	double r = pow(34.00515, -3);
    	System.out.println(r);
    	
    }
}
