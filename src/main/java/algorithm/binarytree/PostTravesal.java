package algorithm.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 树的中序遍历 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-6-14 
 * Time : 下午10:31:20
 */

public class PostTravesal {
    public List<Integer> postorderTraversal(TreeNode root) {
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        TreeNode pre = null;
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        
        
        while(s.size() != 0){
            TreeNode curr = s.peek();
            //从上往下
            if( pre == null || curr == pre.left || curr == pre.right ){
                if(curr.left != null){
                    s.push(curr.left);
                }else if (curr.right != null){
                    s.push(curr.right);
                }
            } else if (curr.left == pre) { //从下往上
                if(curr.right != null){
                    s.push(curr.right);
                }
            } else {
                TreeNode temp = s.pop();
                result.add(temp.val);
            }
            pre = curr; //记录前序节点
        }
        return result;
    }
}
