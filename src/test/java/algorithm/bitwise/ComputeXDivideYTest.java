package algorithm.bitwise;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ComputeXDivideYTest {
	@Test
	public void testDivide() {
		ComputeXDivideY c = new ComputeXDivideY();
		 assertEquals(21, c.divide(231, 11));
		 assertEquals(4, c.divide(44, 11));
		 assertEquals(11, c.divide(22, 2));
	}
}
