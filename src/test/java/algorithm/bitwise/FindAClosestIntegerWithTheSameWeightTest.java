package algorithm.bitwise;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FindAClosestIntegerWithTheSameWeightTest {

	@Test
	public void testClosestLongSameBitCount() {
		FindAClosestIntegerWithTheSameWeight f = new FindAClosestIntegerWithTheSameWeight();
        assertEquals(5, f.closestLongSameBitCount(6));
	}
}
