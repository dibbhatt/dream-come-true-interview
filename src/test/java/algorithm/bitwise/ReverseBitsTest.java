package algorithm.bitwise;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ReverseBitsTest {
	@Test
	public void testReverseBits() {
		ReverseBits rb = new ReverseBits();
        assertEquals(0, rb.reverseBits(0));
        assertEquals(Integer.MIN_VALUE, rb.reverseBits(1));

	}
}


