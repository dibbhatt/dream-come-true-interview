package algorithm.binarytree;
/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-8-20 
 * Time : 下午5:23:46
 */
public class ConstructBinaryTreeFromPreorderAndInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	if (preorder.length == 0){
    		return null;
    	}
    	
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        
    }
    
    public TreeNode build(int [] preorder, int[] inorder, int startPre, int endPre, int startIn, int endIn){
        
        if (startPre > endPre || startIn > endIn){
            return null;
        }
        TreeNode root = new TreeNode(preorder[startPre]);
        if (startPre == endPre){
            return root;
        }
        int midInd = startIn;
        
        for (int i = startIn; i <= endIn; i++){
            if (inorder[i] == preorder[startPre]){
                midInd = i;
                break;
            }
        }
        
        int leftCount = midInd - startIn;
        int rightCount = endIn - midInd;
        if (leftCount != 0){
            root.left = build(preorder, inorder, startPre + 1, startPre + leftCount ,startIn, midInd - 1);
        }
        if (rightCount != 0){
            root.right = build(preorder, inorder, startPre + leftCount + 1, endPre, midInd + 1, endIn);
        }
        return root;
    }
}
