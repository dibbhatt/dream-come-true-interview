package algorithm.dfs;

import static org.junit.Assert.*;

import org.junit.Test;

public class StrobogrammaticNumberIIITest {
    @Test 
    public void testFindIdx() {
    	StrobogrammaticNumberIII s = new StrobogrammaticNumberIII();
    	assertEquals(0, s.findIdx("0"));
    	assertEquals(2, s.findIdx("88"));
    }
    
    @Test
    public void testStrobogrammaticInRange() {
    	StrobogrammaticNumberIII s = new StrobogrammaticNumberIII();
    	assertEquals(3, s.strobogrammaticInRange("50","100"));
    	assertEquals(0, s.strobogrammaticInRange("100", "50"));
    }
}
