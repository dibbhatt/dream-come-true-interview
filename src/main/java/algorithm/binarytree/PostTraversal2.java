package algorithm.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/** 
 * Description :
 * Source : 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-10-15 
 * Time : 下午12:00:15
 */
public class PostTraversal2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        TreeNode pre = null;
        
        while (s.size() != 0) {
            TreeNode curr = s.peek();
            
            if (pre != null && (pre == curr.left || pre == curr.right)){
                TreeNode temp = s.pop();
                result.add(temp.val);
            } else {
                if (curr.left == null && curr.right == null) {
                    TreeNode temp = s.pop();
                    result.add(temp.val);
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
		return result;
    }
}
