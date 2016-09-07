package algorithm.binarytree;

import org.junit.Test;

public class SizeOfLargestCompleteSubtreeTest {

	@Test
	public void testLargestCompleteSubtreeSize() {
		SizeOfLargestCompleteSubtree s = new SizeOfLargestCompleteSubtree();
		/*
		 *      1
		 *    /  \
		 *   2    3
		 *  /    /
		 *  4    5
		 */
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		root.left = left; root.right = right;
		left.left = new TreeNode(4);
		right.left = new TreeNode(5);
		SizeOfLargestCompleteSubtree.ResultType r = s.largestCompleteSubtreeSize(root);
		System.out.print(r.largestSubtreeSize);
	}
}
