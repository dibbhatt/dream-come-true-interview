package algorithm.bitwise;

import java.util.Scanner;

public class ComputeParity {
	public short parityLong(long x) {
		int width = Long.SIZE;
		
		while (width != 1) {
			x  ^=  x >>> (width / 2);
			width /= 2;
		}
		
		return (short)(x & 1);
	}
    public static short parityInt(int x) {
		int width = Integer.SIZE;
		
		while (width != 1) {
			x  ^=  x >>> (width / 2);
			width /= 2;
		}
		
		return (short)(x & 1);
	}
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
 
        // One by one run for all input test cases
        while (t > 0)
        {
            // Input the size of the array
            int n = sc.nextInt();
            int p = parityInt(n);
            if (p == 0) {
                System.out.println("even");
            } else {
                System.out.println("odd");
            }
            t--;
        }
	}
}
