package algorithm.array;

import org.junit.Test;

public class EnumeratePairsInSpiralOrderTest {

	@Test
	public void testEnumerate() {
		EnumeratePairsInSpiralOrder e = new EnumeratePairsInSpiralOrder();
		System.out.println(e.enumerate(10));
		//[[0, 0], [1, 0], [1, -1], [0, -1], [-1, -1], [-1, 0], [-1, 1], [0, 1], [1, 1], [2, 1]]

	}
}
