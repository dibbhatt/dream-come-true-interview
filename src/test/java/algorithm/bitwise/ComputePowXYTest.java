package algorithm.bitwise;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ComputePowXYTest {
	@Test
	public void testPower() {
		ComputePowXY c = new ComputePowXY();
	    assertEquals(9292937.39471223, c.power(4.3, 11), 0.01);
	}
}
