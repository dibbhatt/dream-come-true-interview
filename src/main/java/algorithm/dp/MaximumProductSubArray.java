package algorithm.dp;

import org.junit.Test;

/** 
 * Description :
 * Source : 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-9-28 
 * Time : 下午12:12:54
 */
public class MaximumProductSubArray {
    public int maxProduct(int[] A) {
        if (A.length == 0) {
            return 0;
        } 
        if (A.length == 1) {
            return A[0];
        }
        
        int maxProduct, minProduct, max;
        minProduct = maxProduct = max = A[0];
        
        for (int i = 1; i < A.length; i++) {
        	
        	System.out.println("max product: " + maxProduct);
        	System.out.println("min product:" + minProduct);
        	
            if (A[i] < 0) {
                int n_minProduct = Math.min(maxProduct * A[i], A[i]);
                int n_maxProduct = Math.max(minProduct * A[i], A[i]);
                
                minProduct = n_minProduct;
                maxProduct = n_maxProduct;
                
            } else {
                int n_minProduct = Math.min(minProduct * A[i], A[i]);
                int n_maxProduct = Math.max(maxProduct * A[i], A[i]);
                
                minProduct = n_minProduct;
                maxProduct = n_maxProduct;
            }
            max = Math.max(max, maxProduct);
        }
        return max;
    }
    
    @Test
    public void test() {
    	int[] input = {2, 3, -2, 4};
    	int max = maxProduct(input);
    	System.out.println(max);
    }
    
}
