package algorithm.highfrequency;
/** 
 * Description :
 * Source : 
 * Created_By : zhaoxm (xmpy) 
 * Date : Jun 9, 2015 
 * Time : 12:20:58 AM
 */
public class RangeBitwiseAnd {
    public int rangeBitwiseAnd(int m, int n) {
        
        int result = 0;
        int i = 31;
        for (; i >= 0; i--) {
            int temp = 1 << i;
            if (((m & temp) == 0) && ((n & temp) == 0)) {
                continue;
            }
            
            if (((m & temp) != 0) && ((n & temp) != 0)) {
                result += temp;
                break;
            }
            
            return 0;
            
        }
        i--;
        for (; i >= 0; i--) {
        	int temp = 1 << i;
        	if(((m & temp) ^ (n & temp)) == 0) {
        		result += m & temp;
        	} else {
        		return result;
        	}
        	
        }
        
        
        
        return result;
    }
}
