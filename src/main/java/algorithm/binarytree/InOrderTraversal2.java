package algorithm.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class InOrderTraversal2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        List<Integer> result = new ArrayList<Integer>();
        TreeNode curr = root;
        while ( curr != null) {
            // We always push the current node's each left child in the stack.
            TreeNode left = curr; 
            while (left != null) {
                stack.addFirst(left);
                left = left.left;
            }
            //Assertion: When an element is popped out from the stack, its left children have been traversed.
            //The top of this stack is the leftmost element
            TreeNode next = null;
            while(!stack.isEmpty()) {
                curr = stack.removeFirst();
                result.add(curr.val);
                if (curr.right != null) {
                	next = curr.right;
                    break;
                }
            }
            curr = next;
        }
        
        return result;
    }
}
