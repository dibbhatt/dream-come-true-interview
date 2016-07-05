package algorithm.string;

import java.util.Arrays;

/** 
 * Description :
 * Source : 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-12-7 
 * Time : 下午9:45:43
 */
public class Reader4 {
		public int read4(char[] buf){
			return 0;
			
		}
	    
	    /**
	     * @param buf Destination buffer
	     * @param n   Maximum number of characters to read
	     * @return    The number of characters read
	     */
	    public int read(char[] buf, int n) {
	        
	        int ind = 0;
	        char[] temp = new char[4];
	        while (true) {
	            int k = read4(temp);
	            for (int i = 0; i < k; i++) {
	                if (ind == n) {
	                    return n;
	                }
	                buf[ind++] = temp[i];
	            }
	            if (k < 4) {
	                return ind;
	            }
	        }
	    }
}
