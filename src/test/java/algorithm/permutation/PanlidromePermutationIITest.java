package algorithm.permutation;

import org.junit.Test;

public class PanlidromePermutationIITest {
	@Test
	public void testgeneratePalindromes() {
		PanlidromePermutationII p = new PanlidromePermutationII();
		System.out.println(p.generatePalindromes("abc"));
		System.out.println(p.generatePalindromes("aabb"));
	}
}
