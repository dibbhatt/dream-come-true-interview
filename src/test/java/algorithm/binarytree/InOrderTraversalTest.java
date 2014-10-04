package algorithm.binarytree;
import java.util.ArrayList;

import org.junit.Test;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-7-14 
 * Time : 下午5:32:05
 */
public class InOrderTraversalTest {
	InOrderTraversal it = new InOrderTraversal();
	
	@Test
	public void testInorderTraversal(){
		TreeNode root = new TreeNode(1);
		TreeNode root2 = new TreeNode(2);
		TreeNode root3 = new TreeNode(3);
		
		root.left = root2;
		root.right = root3;
		ArrayList<Integer> result = it.inorderTraversal(root);
		System.out.println(result);
		
		
	}
}
