package algorithm.array;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class JumpGameTest {
	@Test
    public void testJumpBfs() {
		JumpGame jp = new JumpGame();
	    assertEquals(2, jp.jumpBfs(new int[]{2, 3, 1, 1, 4}));
    }
}
