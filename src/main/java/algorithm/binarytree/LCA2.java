package algorithm.binarytree;

public class LCA2 {
    private static class ResultType {
        public int count = 0;
        public TreeNode lca = null;
    }
    
    public ResultType helper(TreeNode root, TreeNode p, TreeNode q) {
        ResultType  r = new ResultType();
        if (root == null) {
            return r;
        }
        ResultType lr = helper(root.left, p, q);
        if (lr.count == 2){
            return lr;
        }
        ResultType rr = helper(root.right, p, q);
        if (rr.count == 2){
            return rr;
        }
        if (lr.count == 1 && rr.count == 1) {
            r.count = 2;
            r.lca = root;
            return r;
        }
        if (root == q || root == p) {
            if (lr.count == 1 || rr.count == 1) {
                r.count = 2;
                r.lca = root;
                return r;
            }
            r.count = 1;
            return r;
        }
        
        if (lr.count == 1) {
        	return lr;
        } else if (rr.count == 1) {
        	return rr;
        }
        return r;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ResultType r = helper(root, p, q);
        return r.lca;
    }
}
