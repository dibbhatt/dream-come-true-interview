package algorithm.bitwise;

public class PowerOfThree {
	
    public boolean isPowerOfThreeBruteForce(int n) {
        if ( n <= 0) {
        	return false;
        }
        
        // Think the base 3 representation of number
        while ( n >= 3) {
        	if ((n % 3) != 0) {
        		return false;
        	}
        	n = n / 3; 
        }
        return n == 1;
    }
	
    public boolean isPowerOfThree(int n) {
        if ( n <= 0) {
        	return false;
        }
        //int maxN = (int)(Math.log(Integer.MAX_VALUE) / Math.log(3));
        //int maxPower = (int) Math.pow(3, maxN);
        int maxPower = 1162261467;
        return maxPower % n == 0;
    }
}
