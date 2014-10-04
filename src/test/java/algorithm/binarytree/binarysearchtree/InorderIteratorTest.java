package algorithm.binarytree.binarysearchtree;

import org.junit.Test;

import algorithm.binarytree.TreeNode;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-7-17 
 * Time : 下午3:09:46
 */
public class InorderIteratorTest {

	@Test
	public void testNext(){
		TreeNode root = new TreeNode(1);
		TreeNode root2 = new TreeNode(2);
		TreeNode root3 = new TreeNode(3);
		root.left = root2;
		root.right = root3;
		InorderIterator it = new InorderIterator(root);
		
		while(it.hasNext()){
			System.out.println(it.next().val);
		}
		
		/*
		System.out.println("**********************");

		root = new TreeNode(-1);
		root2 = new TreeNode(5);
		root3 = new TreeNode(4);
		TreeNode root4 = new TreeNode(2);
		TreeNode root5 = new TreeNode(-4);
		root.left = root2;
		root2.right = root3;
		root.right = root4;
		root4.left = root5;
		
		it = new InorderIterator(root);	
		temp = it.next();

		while(temp!= null){
			System.out.println(temp.val);
			temp = it.next();
		}
		*/
	}
}
