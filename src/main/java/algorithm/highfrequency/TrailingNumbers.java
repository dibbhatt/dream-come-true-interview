package algorithm.highfrequency;

import org.junit.Test;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-8-16 
 * Time : 下午2:39:27
 */
public class TrailingNumbers {
	  class ResultType {
	        public long twoCount = 0;
	        public long fiveCount = 0;
	    }
	    //param n : description of n
	    //return: description of return
	    public long trailingZeros(long n) {
	    	long count2 = 0;
	    	long count5 = 0;
	        long r = 0;
	        
	        for (long i = 1; i <= n; i++){
	            ResultType rt = getCount(i);
	            count2 += rt.twoCount;
	            count5 += rt.fiveCount;
	        }
	        
	        while (count2 != 0 && count5 != 0){
	            count2 --;
	            count5 --;
	            r++;    
	                
	        }
	        return r;
	    }
	    public ResultType getCount(long n){
	        ResultType rt =  new ResultType();
	        long temp = n;
	        
	        while (temp != 0 && temp % 2 == 0){
	            rt.twoCount++;
	            temp = temp / 2;
	        }
	        
	        temp = n;
	        while (temp != 0 && temp % 5 == 0){
	            rt.fiveCount++;
	            temp = temp / 5;
	        }
	        return rt;
	    }
	    
	    @Test
	    public void test(){
	    	long r = trailingZeros(19);
	    	System.out.println(r);
	    	
	    }
}
