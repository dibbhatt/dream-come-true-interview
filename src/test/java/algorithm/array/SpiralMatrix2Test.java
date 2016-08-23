package algorithm.array;

import org.junit.Test;

public class SpiralMatrix2Test {

	@Test
	public void testSpiralOrder() {
		SpiralMatrix2 sm = new SpiralMatrix2();
		int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		
		System.out.println(sm.spiralOrder(matrix));
	}
}
