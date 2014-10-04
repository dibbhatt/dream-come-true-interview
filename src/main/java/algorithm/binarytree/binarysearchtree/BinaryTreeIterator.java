package algorithm.binarytree.binarysearchtree;

import algorithm.binarytree.TreeNode;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-7-18 
 * Time : 下午12:58:37
 */
	public interface BinaryTreeIterator {
		// Are there other nodes to see in this traversal? 
		boolean hasNext();
		// Return the value of the key in the next node in the 
		// traversal, and advance the position of the iterator.
		TreeNode next();
	}
