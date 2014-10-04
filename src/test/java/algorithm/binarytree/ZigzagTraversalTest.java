package algorithm.binarytree;

import java.util.ArrayList;

import org.junit.Test;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-7-17 
 * Time : 下午2:11:58
 */
public class ZigzagTraversalTest {
	
	@Test
	public void testZigzagLevelOrder(){
		ZigzagTraversal zt = new ZigzagTraversal();
		TreeNode root = new TreeNode(1);
		TreeNode root2 = new TreeNode(2);
		TreeNode root3 = new TreeNode(3);
		root.left = root2;
		root.right = root3;
		ArrayList<ArrayList<Integer>> r = zt.zigzagLevelOrder(root);
		
		System.out.println(r);
	}
}
