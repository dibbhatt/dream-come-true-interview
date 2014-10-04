package algorithm.binarytree;

import java.util.ArrayList;
import java.util.Stack;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-7-14 
 * Time : 下午5:28:18
 */
public class InOrderTraversal {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null){
            return result;
        }
        Stack<TreeNode> s = new Stack<TreeNode>();
    	TreeNode curr = root;
    	s.push(root);
    	
        while (s.size() != 0 ){
        	
        	while(curr != null){
        		if(curr.left != null ){
        			s.push(curr.left);
        		}
        		curr = curr.left;
        	}
        	curr = s.pop();
        	result.add(curr.val);
        	curr = curr.right;
        	if(curr != null){
        		s.push(curr);
        	}
        }
        
        return result;
    }
}
