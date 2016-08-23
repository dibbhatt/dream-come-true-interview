package algorithm.array;

import org.junit.Test;

public class FindKthElementInSpiralFormOfMatrixTest {

	@Test
	public void testFindK(){
		FindKthElementInSpiralFormOfMatrix f = new FindKthElementInSpiralFormOfMatrix();
		int[][] input = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		System.out.println(f.findK(input, 3, 3, 9));
	}
}
