package algorithm.binarytree;
import org.junit.Test;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-7-16 
 * Time : 上午12:20:25
 */
public class MaximumPathSumTest {
	
	@Test
	public void testMaxPath(){
		MaximumPathSum mps = new MaximumPathSum();
		TreeNode root = new TreeNode(1);
		TreeNode root2 = new TreeNode(2);
		TreeNode root3 = new TreeNode(3);
		root.left = root2;
		root.right = root3;
		int r = mps.maxPathSum(root);
		System.out.println(r);
		
		root = new TreeNode(-1);
		root2 = new TreeNode(5);
		root3 = new TreeNode(4);
		TreeNode root4 = new TreeNode(2);

		TreeNode root5 = new TreeNode(-4);
		root.left = root2;
		root2.right = root3;
		root.right = root4;
		root4.left = root5;
		

		root.left = root2;
		r = mps.maxPathSum(root);
		System.out.println(r);
	}
	
}
