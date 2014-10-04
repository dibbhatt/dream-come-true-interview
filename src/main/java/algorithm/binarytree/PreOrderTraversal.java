package algorithm.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/** 
 * 树的前序遍历
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-7-14 
 * Time : 下午4:41:41
 */
public class PreOrderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null)
            return null;
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        while(s.size() != 0){
            TreeNode p = s.pop();
            s.add(p);
            if(p.right != null){
                s.push(p.right);
            }
            if(p.left != null){
                s.push(p.left);
            }
        }
        
        return result;
    }
}
