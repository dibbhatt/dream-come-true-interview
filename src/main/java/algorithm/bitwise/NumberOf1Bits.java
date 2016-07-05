package algorithm.bitwise;


/**
 * Description : rite a function that takes an unsigned integer and returns the number of ’1' bits it has (lso known as the Hamming weight)
 * Source : leetocode https://leetcode.com/problems/number-of-1-bits/
 * Created_By : xmpy
 * Time : Jul 5, 2016 10:57:22 PM  
 */
public class NumberOf1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeightBruteForce(int n) {
    	int ret = 0;
    	while (n != 0) {
    		if ( (n % 2) != 0) {
    			ret++;
    		}
    		n = n >> 1;
    	}
    	
    	return ret;
    }
    public int hammingWeight(int n) {
    	int ret = 0;
    	int y = n & ~ (n - 1);
    	while (y != 0) {
    		ret++;
    		n = n ^ y;  // Remove 1 at this bit.
    		y = n & ~ (n - 1); 
    	}
    	
    	return ret;
    }
}
