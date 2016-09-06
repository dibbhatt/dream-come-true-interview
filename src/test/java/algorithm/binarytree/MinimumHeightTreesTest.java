package algorithm.binarytree;

import org.junit.Test;

public class MinimumHeightTreesTest {

	@Test
	public void testFindMinHeightTrees(){
		int n = 8;
		int[][] edges = {{0,1},{1,2},{2,3},{0,4},{4,5},{4,6},{6,7}};
		MinimumHeightTrees m = new MinimumHeightTrees();
		System.out.println(m.findMinHeightTrees(n, edges));
		
		MinimumHeightTrees2 m2 = new MinimumHeightTrees2();
		System.out.println(m2.findMinHeightTrees(n, edges));

	}
}
