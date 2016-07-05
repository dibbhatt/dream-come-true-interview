package algorithm.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

/** 
 * Description : 递归把一个节点的右子树放在一个节点的左子树的右子树上，要求实现非递归。其实就是后序遍历嘛~
 * Source : Google 电面
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-10-15 
 * Time : 下午12:42:41
 */
public class RightChildToLeftRightChild {
	public void solve (TreeNode root) {
		
        if (root == null) {
            return ;
        }
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        TreeNode pre = null;
        
        while (s.size() != 0) {
            TreeNode curr = s.peek();
            
            if (pre != null && (pre == curr.left || pre == curr.right)){
                TreeNode temp = s.pop();
                //result.add(temp.val);
                if (temp.left != null) {
                	temp.left.right = temp.right;
                } else {
                	temp.left = temp.right;
                }                          
                temp.right = null;
            } else {
                if (curr.left == null && curr.right == null) {
                    TreeNode temp = s.pop();
                   // result.add(temp.val);
                    if (temp.left != null) {
                    	temp.left.right = temp.right;
                    } else {
                    	temp.left = temp.right;
                    }
                    temp.right = null;
                }
                if (curr.right != null){
                    s.push(curr.right);
                }
                if (curr.left != null) {
                    s.push(curr.left);
                }
            }
         
            pre = curr;
        }
		return;
	}
	
	
	@Test
	public void test(){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		root.right.right = new TreeNode(6);
		root.left.left.left = new TreeNode(7);
		
		LevelTraversal lt = new LevelTraversal();
		System.out.println(lt.levelOrder(root));
		
		solve(root);
		System.out.println(lt.levelOrder(root));
		
		
		
	}
	
	
}
