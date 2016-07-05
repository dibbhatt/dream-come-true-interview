package algorithm.other;

import org.junit.Test;

/** 
 * Description :
 * Source : https://leetcode.com/problems/counting-bits/
 * Created_By : zhaoxm (xmpy) 
 * Date : Mar 21, 2016 
 * Time : 9:18:19 PM
 */
public class CountingBits {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        result[0] = 0;
        if (num == 0) {
            return result;
        }
        
        int target = 1;
        int j = 0;
        for (int i = 1; i <= num; i++) {
            if (i == target) {
                target *= 2;
                j = 0;
            }
            result[i] = 1 + result[j];
            j++;
        } 
        return result;
    }
    
    @Test
    public void test() {
    	CountingBits cb = new CountingBits();
    	int[] result = cb.countBits(5);
    	for (int r : result) {
    		System.out.println(r);
    	}
    }
}
