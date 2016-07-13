package algorithm.search;

import org.junit.Test;


public class KthLargestELementInArrayTest {
	@Test
	public void testMinPatches() {
		KthLargestELementInArray kle = new KthLargestELementInArray();
		int[] nums = new int[] {2, 1};
		
		System.out.println(kle.findKthLargest(nums, 2));
//        assertEquals(1, pa.minPatches(nums, 6));
//        nums = new int[] {1 , 5, 10};
//        assertEquals(2, pa.minPatches(nums, 20));
//        nums = new int[] {1 , 2, 2};
//        assertEquals(0, pa.minPatches(nums, 5));
	}
}
