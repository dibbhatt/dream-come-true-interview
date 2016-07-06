package algorithm.puzzle;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PatchingArrayTest {
	@Test
	public void testMinPatches() {
		PatchingArray pa = new PatchingArray();
		int[] nums = new int[] {1,2,2,6,34,38,41,44,47,47,56,59,62,73,77,83,87,89,94};
		
		System.out.println(pa.minPatches(nums, 20 ));
//        assertEquals(1, pa.minPatches(nums, 6));
//        nums = new int[] {1 , 5, 10};
//        assertEquals(2, pa.minPatches(nums, 20));
//        nums = new int[] {1 , 2, 2};
//        assertEquals(0, pa.minPatches(nums, 5));
	}
}
