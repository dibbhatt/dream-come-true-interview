package algorithm.binarytree.binarysearchtree;

import java.util.Stack;

import algorithm.binarytree.TreeNode;


/** 
 * 实现二叉搜索数的迭代器
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-7-17 
 * Time : 下午2:49:29
 */
	public class InorderIterator implements BinaryTreeIterator{
		Stack<TreeNode> s = new Stack<TreeNode>();
		public InorderIterator(TreeNode root){
			s.push(root);
			TreeNode temp = root;
			while(temp != null){
				if(temp.left != null){
					s.push(temp.left);
				}
				temp = temp.left;
			}
		}
		
		public boolean hasNext() {
			if(s.isEmpty()){
				return false;
			}
			return true;
		}
		
		public TreeNode next(){
			TreeNode r = s.pop();
			if(r.right == null){
				return r;
			}
			//如果右节点不为空
			s.push(r.right);
			TreeNode temp = r.right;
			while(temp != null){
				if(temp.left != null){
					s.push(temp.left);
				}
				temp = temp.left;
			}
			return r;
		}
	}
