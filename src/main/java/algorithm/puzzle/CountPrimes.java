package algorithm.puzzle;

import java.util.ArrayList;
import java.util.List;

/**
 * Description :
 * Source : EPI chapter 4.2 p 37 
 * Created_By : xmpy
 * Time : Jul 15, 2016 15:20:19 AM  
 */
public class CountPrimes {
    
    // Time limit exceeded 499979
    public int countPrimesBruteForce(int n) {
        if ( n <= 2) {
            return 0;
        }
        List<Integer> primes = new ArrayList<Integer>();
        boolean isPrime = true;
        for (int i = 2; i < n; i++) {
        	isPrime = true;
        	for (int prime : primes) {
                if ( i % prime == 0) {
                	isPrime = false;
                	break;
                } 
            }
            if (isPrime) {
                primes.add(i);
            }
        }
        return primes.size();
    }
    
    // This solution is accepted in Leetcode.
    public int countPrimesBruteForce2(int n) {
        if ( n <= 2) {
            return 0;
        }
        List<Integer> primes = new ArrayList<Integer>();
        boolean isPrime = true;
        for (int i = 2; i < n; i++) {
        	isPrime = true;
        	for (int j = 0; j < primes.size() && primes.get(j) <= Math.sqrt(i); j++) {
                int prime = primes.get(j);
        		if ( i % prime == 0) {
                	isPrime = false;
                	break;
                } 
            }
            if (isPrime) {
                primes.add(i);
            }
        }
        return primes.size();
    }
    
    // Accepted solution
    public int countPrimes(int n) {
        if ( n <= 2) {
            return 0;
        } 
        
        boolean[] state = new boolean[n];
        
        for (int i = 2; i<= n - 1; i++) {
            state[i] =  true;
        }
        
        for (int i = 2; i <= Math.sqrt(n - 1); i++) {
            if (state[i]) {
                for (int j = i; j <= ((n - 1)/i); j++) {
                    state[i * j] = false;
                }                
            }       
        }
        int count = 0; 
        for (int i = 2; i < n; i++) {
            if (state[i]) {
                count++;
            }
        }
        return count;
    }
    
    // Accepted solution
    public int countPrimesSaveSpace(int n) {
        if ( n <= 2) {
            return 0;
        } 
        int count = 1; 
        boolean[] state = new boolean[n/2 - 1];
        
        for (int i = 0; i< (n/2 - 1); i++) {
            state[i] =  true;
        }
        
        for (int i = 3; i <= Math.sqrt(n - 1); i = i + 2) {
            if (state[i/2 - 1]) {
                for (int j = i; j <= ((n - 1)/i); j++) {
                	if (i * j % 2 != 0) {
                		state[(i * j) / 2 - 1] = false;
                	}
                }
            }       
        }
        for (int i = 0; i < (n/2 - 1); i++) {
            if (state[i]) {
                count++;
            }
        }
        return count;
    }
}
