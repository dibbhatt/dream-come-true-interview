package algorithm.binarytree;
/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : Jul 15, 2014 
 * Time : 9:19:06 PM
 */
public class MaximumPathSum {
	
	class Result{
		int simplePath = 0;
		int maxPath = 0;
		
		public Result(int s, int a){
			this.simplePath = s;
			this.maxPath = a;
		}
	}
	public Result maxPath(TreeNode root) {
		//注意到最大和不可以不取，如果为负数，也要取。
		if(root.left == null && root.right == null){
			int r = root.val;
			return new Result(r, r);
		}
		//初始化为负数，方便后面编程序
		Result leftResult = new Result(Integer.MIN_VALUE, Integer.MIN_VALUE);
		Result rightResult  = new Result(Integer.MIN_VALUE, Integer.MIN_VALUE);
		
		if(root.left != null){
			leftResult = maxPath(root.left);
		}
		if(root.right != null){
			rightResult =  maxPath(root.right);
		}
		
		int all = Math.max(leftResult.maxPath, rightResult.maxPath);
		
		int ls = Math.max(leftResult.simplePath, 0);
		int rs = Math.max(rightResult.simplePath, 0);

		all = Math.max(ls + rs + root.val, all);
		
		return new Result(Math.max(ls, rs)+root.val, 
					all);
	}
	public int maxPathSum(TreeNode root) {
		return maxPath(root).maxPath;
	}
}
