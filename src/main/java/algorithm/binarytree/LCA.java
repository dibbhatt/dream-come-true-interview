package algorithm.binarytree;
/** 
 * Description :返回结点node1和node2的最近公共祖先
 * Source : ITin5.com
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-9-28 
 * Time : 下午9:54:35
 */
public class LCA {
    
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
}
