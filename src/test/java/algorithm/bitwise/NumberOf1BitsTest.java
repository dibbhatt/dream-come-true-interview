package algorithm.bitwise;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Description :
 * Source : 
 * Created_By : xmpy
 * Time : Jul 5, 2016 11:16:27 PM  
 */
public class NumberOf1BitsTest {

	@Test
	public void testHammingWeight() {
		NumberOf1Bits nob = new NumberOf1Bits();
        assertEquals(1, nob.hammingWeight(2));
        assertEquals(2, nob.hammingWeight(3));
        assertEquals(0, nob.hammingWeight(0));
        assertEquals(1, nob.hammingWeight(8));
	}
}
