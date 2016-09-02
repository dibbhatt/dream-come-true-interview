package algorithm.array;

import org.junit.Test;

public class LargestDivisibleSubsetTest {
	@Test
	public void testLargestDivisibleSubsetTest() {
		LargestDivisibleSubset lds = new LargestDivisibleSubset();
		int[] input = {1, 2, 4, 8, 9 };
		System.out.println(lds.largestDivisibleSubset(input));
		int[] input2 = {2, 2, 4, 8, 9, 23, 2132, 2131, 22, 321,43};
		System.out.println(lds.largestDivisibleSubset(input2));
		int[] input3 = {2, 2, 4, 8, 9, 23, 220, 2200, 22,321,4400};
		System.out.println(lds.largestDivisibleSubset(input3));
	}
}
