package algorithm.bitwise;

import java.util.Scanner;

public class SwapBits {
	public static long swap1Bit(long x, int i, int j) {
		if (( x >>> i & 1 ) != ( x >>> j & 1)) {
			x ^=  (1L << i) | (1L << j); 
		}
		return x;
	}
	
	public static long swapBits(long x, int i, int j, int n) {
		for (int inc = 0; inc < n; inc++) {
			int curri = i + inc;
			int currj = j + inc;
			if (( x >>> curri & 1 ) != ( x >>> currj & 1)) {
				x ^=  (1L << curri) | (1L << currj); 
			}
		}
		return x;
	}
	
	public static long swapBitsBest(long x, int i, int j, int n) {
		/* Move all bits of first set to rightmost side */
		long set1 = ( x >>> i) & ((1L << n) - 1);
		/* Moce all bits of second set to rightmost side */
		long set2 = ( x >>> j) & ((1L << n) - 1);
		/* XOR the two sets */
		long xor  = set1 ^ set2;
		/* Put the xor bits back to their original positions */
		long mask = (xor << i) | (xor << j);
		/* XOR the 'xor' with the original number so that the 
	       two sets are swapped */
		return x ^ mask;
	}
	
	
	/*
	 *  Example 1
		Input:
		x = 47 (00101111)
		p1 = 1 (Start from second bit from right side)
		p2 = 5 (Start from 6th bit from right side)
		n = 3 (No of bits to be swapped)
		Output:
		227 (11100011)
		The 3 bits starting from the second bit (from right side) are 
		swapped with 3 bits starting from 6th position (from right side) 

	 * 
	 */
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
 
        // One by one run for all input test cases
        while (t > 0)
        {
            // Input the size of the array
            int x = sc.nextInt();
            int i = sc.nextInt();
            int j = sc.nextInt();
            int n = sc.nextInt();
            int p = (int)(swapBitsBest(x, i, j, n));
            System.out.println(p);
            t--;
        }
	}
	
}
