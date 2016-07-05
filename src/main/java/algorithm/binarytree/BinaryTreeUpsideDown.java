package algorithm.binarytree;
/** 
 * Description :
 * Source : 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-11-22 
 * Time : 上午12:07:40
 */
public class BinaryTreeUpsideDown {
    public TreeNode UpsideDownBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode parent = root;
        TreeNode parentRight = root.right;
        TreeNode curr = root.left;
        
        while (curr != null) {
        	System.out.println(curr.val);
            TreeNode left = curr.left;
            curr.left = parentRight;
            parentRight = curr.right;
            curr.right = parent;
            parent = curr;
            curr = left;
        }
        return parent;
    }
    
    public static void main(String[] args) {
    	BinaryTreeUpsideDown b = new BinaryTreeUpsideDown();
    	TreeNode root = new TreeNode(1);
    	TreeNode left = new TreeNode(2);
    	root.left = left;
    	
    	TreeNode r = b.UpsideDownBinaryTree(root);
    	System.out.println(r.val);
    	System.out.println(r.right.val);
    	
    }
}
