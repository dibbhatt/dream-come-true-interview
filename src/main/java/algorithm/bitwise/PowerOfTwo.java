package algorithm.bitwise;

/**
 * Description : Given an integer, write a function to determine if it is a power of two.
 * Source : https://leetcode.com/problems/power-of-two/
 * Created_By : xmpy
 * Time : July 22, 2016 4:57:22 PM  
 */
public class PowerOfTwo {
	// O(n)
    public boolean isPowerOfTwoBruteForce(int n) {
        if ( n <= 0) {
            return false;
        }
        for (int i = 0; i < Integer.SIZE - 1; i++) {
            if ((n  ^ (1 << i)) == 0) {
                return true;
            }
        }
        return false;
    }
    // Could you do it without using any loop / recursion?
    // O(1)
    public boolean isPowerOfTwo(int n) {
        if ( n <= 0) {
            return false;
        }
        // If only one 1.
        return (n & (n - 1)) == 0;
    }
}
