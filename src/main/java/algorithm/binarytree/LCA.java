package algorithm.binarytree;
/** 
 * Description :返回结点node1和node2的最近公共祖先
 * Source : ITin5.com
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-9-28 
 * Time : 下午9:54:35
 */

class ResultType {
    public TreeNode p = null;
    public TreeNode q = null;
    public TreeNode result = null;
}

public class LCA {
    
    public ResultType find(TreeNode root, TreeNode p, TreeNode q) {
        ResultType r = new ResultType();
        if (root == null) {
            return r; 
        }
        
        if (root == p) {
            r.p = p;
        }
        if (root == q) {
            r.q = q;
        }
        
        ResultType leftR = find(root, p, q);
        ResultType rightR = find(root, p, q);
        if (leftR.result != null || rightR.result != null) {
            return leftR.result == null ? rightR : leftR;
        }
        
        if (leftR.p != null) {
            r.p = leftR.p;
        }
        
        if  (leftR.q != null) {
            r.q = leftR.q;
        }
        
       if (rightR.p != null) {
            r.p = rightR.p;
        }
        
        if  (rightR.q != null) {
            r.q = rightR.q;
        }        
        
        if (r.q != null && r.p != null) {
            r.result = root;
        }
        
        return r;
    } 
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ResultType r = find(root, p, q);
        return r.result;
    }
}

/*
 * 
 public TreeNode getLCA(TreeNode node, TreeNode node1, TreeNode node2) {
    	if (node == null) {
    		return null;
    	}
    	TreeNode left = getLCA(node.left, node1, node2);
    	TreeNode right = getLCA(node.right, node1, node2);
    	if (left == node1 && right == node2){
    		return node;
    	}
    	if (left == node1) {
    		return node1;
    	}
    	if (right == node2) {
    		return node2;
    	}
    	
    	if (left != null) {
    		return left;
    	}
    	
    	if (right != null) {
    		return right;
    	}
    	return null;
    }
 */
