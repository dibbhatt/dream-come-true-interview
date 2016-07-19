package algorithm.bitwise;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Test;

public class ComputeParityTest {
	@Test
	public void testParity() {
		ComputeParity cp = new ComputeParity();
		assertEquals(0, cp.parity(0x1111));
	}
    public static short parity(int x) {
		int width = Integer.SIZE;
		
		while (width != 0) {
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
            int p = parity(n);
            if (p == 1) {
                System.out.println("odd");
            } else {
                System.out.println("even");
            }
            t--;
        }
	}
}
