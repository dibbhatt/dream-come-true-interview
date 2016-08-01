package algorithm.array;

import org.junit.Test;

public class BasicOperationsTest {
	@Test
	public void test() {
		int[][] arr = new int[3][];
		arr[0] = new int[3];
		arr[0][1] = 0;
		System.out.println(arr[0][1]);
	}
}
