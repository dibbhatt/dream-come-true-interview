package algorithm.string;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StrStrTest {
	@Test
	public void testStrStr() {
		StrStr ss = new StrStr();
        assertEquals(4, ss.strStr("mississippi", "issip"));
	} 
	

}
