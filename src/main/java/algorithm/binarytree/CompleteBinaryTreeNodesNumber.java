package algorithm.binarytree;
/** 
 * Description : 给定一棵完全二叉树（查看定义）的根结点，统计该树的结点总数。
 * 树结点类型名为TreeNode，您没必要知道该类型的定义，
 * 请使用下面的方法得到某个结点的左，右儿子结点，以及判断某结点是否为NULL。
 * 
 * Source : http://www.itint5.com/oj/#4
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-9-21 
 * Time : 下午5:26:44
 */
public class CompleteBinaryTreeNodesNumber {
	
	public int getHeight(TreeNode root){
		if (root == null) {
			return 0;
		}
		
		int r = 0;
		while (root != null) {
			r++;
			root = root.left;
		}
		
		return r;
	}
	
	public int countCompleteBinary(int height){
		
		return (int)(Math.pow(2, height)) - 1;
	}
	
	public int getNum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		int count = 0;
		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);
		if (leftHeight == rightHeight) {
			count += countCompleteBinary(leftHeight);
			count += getNum(root.right);
		} else {
			count += countCompleteBinary(rightHeight);
			count += getNum(root.left);
		}
		
		return count;	
	}
	
}
