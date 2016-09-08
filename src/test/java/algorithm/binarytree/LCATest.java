package algorithm.binarytree;

import org.junit.Test;

public class LCATest {
	@Test
	public void testLowestCommonAncestor(){
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		root.left = left;
		LCA2 lca = new LCA2();
		lca.lowestCommonAncestor(root, left, root);
	}
}
