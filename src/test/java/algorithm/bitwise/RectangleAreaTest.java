package algorithm.bitwise;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RectangleAreaTest {
	@Test
	public void testComputeArea() {
		RectangleArea ra = new RectangleArea();
		assertEquals( 24, ra.computeArea(-2, -2, 2, 2, -4, -2, -2, 2));
		assertEquals( 19, ra.computeArea(-2, -2, 2, 2, -3, -3, -1, -1));
	}
}
