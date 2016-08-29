package algorithm.string;

import org.junit.Test;

public class IntegerToRomanTest {
	@Test
	public void testGetNormalString() {
		IntegerToRoman itr = new IntegerToRoman();
		System.out.println(itr.intToRoman(99));
		
		IntegerToRoman2 itr2 = new IntegerToRoman2();
		System.out.println(itr2.intToRoman(99));

	}
	
}
