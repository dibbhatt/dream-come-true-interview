package algorithm.binarytree;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-7-23 
 * Time : 下午8:58:04
 */
public class SerializeBinaryTreeTest {
	
	private static SerializeBinaryTree sb;
	 @BeforeClass  
	    public static void beforeClass(){ //静态方法  
		 sb = new SerializeBinaryTree();	
		 }  
	@Test
	public void testSerialize(){
		TreeNode root = new TreeNode(1);
		TreeNode root2 = new TreeNode(2);
		TreeNode root3 = new TreeNode(3);
		root.left = root2;
		root.right = root3;
		List<Integer> r = sb.serialize(root);
		System.out.print(r);
		
		root = new TreeNode(-1);
		root2 = new TreeNode(5);
		root3 = new TreeNode(4);
		TreeNode root4 = new TreeNode(2);

		TreeNode root5 = new TreeNode(-4);
		root.left = root2;
		root2.right = root3;
		root.right = root4;
		root4.left = root5;
		
		r = sb.serialize(root);
		System.out.print(r);

	}
	
	//测试解序列化
	@Test
	public void testDeserialize(){
		TreeNode root = new TreeNode(1);
		TreeNode root2 = new TreeNode(2);
		TreeNode root3 = new TreeNode(3);
		root.left = root2;
		root.right = root3;
		List<Integer> r = sb.serialize(root);
		//System.out.print(r);
		
		root = new TreeNode(-1);
		root2 = new TreeNode(5);
		root3 = new TreeNode(4);
		TreeNode root4 = new TreeNode(2);

		TreeNode root5 = new TreeNode(-4);
		root.left = root2;
		root2.right = root3;
		root.right = root4;
		root4.left = root5;
		
		List<Integer> r2 = sb.serialize(root);
		//System.out.print(r);
		
		
		TreeNode rootR = sb.deserialize(r);
		TreeNode rootR2 = sb.deserialize(r2);
		
		System.out.println(sb.serialize(rootR));
		System.out.println(sb.serialize(rootR2));
        assertEquals(sb.serialize(rootR), r);
        assertEquals(sb.serialize(rootR2), r2);


	}
	
	
}
