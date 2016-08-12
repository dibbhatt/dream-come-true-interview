package algorithm.permutation;

import java.util.List;

import org.junit.Test;

public class PermutationIITest {
	@Test
	public void testPermuteUnique() {
		PermutationII p = new PermutationII();
		List<List<Integer>> r = p.permuteUnique(new int[]{1,3,3,4});
		System.out.println(r);
	}
}
