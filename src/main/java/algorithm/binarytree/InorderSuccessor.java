package algorithm.binarytree;

import java.util.ArrayList;
import java.util.List;

public class InorderSuccessor {
    public TreeNode helper(TreeNode root, List<TreeNode> path, TreeNode p) {
    	if (root == null) {
    		return null;
    	}
    	if (root == p) {
    		if (path.size() == 0) {
    			return null;
    		}
    		TreeNode curr = root;
    		for (int i = path.size() - 1; i >= 0; i--) {
    			TreeNode parent = path.get(i);
    			if (parent.left == curr) {
    				return parent;
    			}
    			curr = parent;
    		}
    		return null;
    	}
    	path.add(root);
    	TreeNode r = helper(root.left, path, p );
    	if (r != null) {
    		return r;
    	}
    	r = helper(root.right, path, p );
    	if (r != null) {
    		return r;
    	}
    	path.remove(path.size() - 1);
    	return null;
    }
	
	
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p.right != null) {
        	TreeNode curr = p.right;
        	while (curr.left != null) {
        		curr = curr.left;
        	}
        	return curr;
        }
        TreeNode r = helper(root, new ArrayList<TreeNode>(), p);
        return r;
    }
}
