package algorithm.linkedlist;

import org.junit.BeforeClass;
import org.junit.Test;

import algorithm.binarytree.SerializeBinaryTree;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-7-26 
 * Time : 下午5:29:08
 */
public class CopyListWithRandomPointerTest {
	private static CopyListWithRandomPointer c;

	 @BeforeClass  
	public static void beforeClass(){ //静态方法  
	    c = new CopyListWithRandomPointer();	
	}  
	@Test
	public void testCopyRandomList(){
		RandomListNode head = new RandomListNode(-1);
		head.random = null;
		head.next = null;
		RandomListNode r = c.copyRandomList(head);
		System.out.println(r.label);
	}
}
