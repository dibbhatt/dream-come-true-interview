package algorithm.binarytree;


public class SizeOfLargestCompleteSubtree {
	public static class ResultType {
		public int height = 0; 
		public boolean isComplete = false;
		public boolean isFull = false;
		public int largestSubtreeSize = 0;
		
	}
	
	public ResultType largestCompleteSubtreeSize(TreeNode root){
		ResultType r = new ResultType();
		if (root == null) {
			r.isComplete = true;
			r.isFull = true;
			return r;
		}
		// Is leaf.
		if (root.left == null && root.right == null) {
			r.height = 1;
			r.isComplete = true;
			r.isFull = true;
			r.largestSubtreeSize = 1;
			return r;
		}
		ResultType leftr = largestCompleteSubtreeSize(root.left);
		ResultType rightr = largestCompleteSubtreeSize(root.right);
		r.height = Math.max(leftr.height, rightr.height) + 1;
		if (leftr.height == rightr.height && leftr.isFull && rightr.isComplete) {
			if (rightr.isFull) {
				r.isFull = true;
			} else {
				r.isComplete = true;
			}
			r.largestSubtreeSize = leftr.largestSubtreeSize + rightr.largestSubtreeSize + 1;
		} else if (leftr.height == (rightr.height + 1) && leftr.isComplete && rightr.isFull) {
			r.isComplete = true;
			r.largestSubtreeSize = leftr.largestSubtreeSize + rightr.largestSubtreeSize + 1;
		} else {
			r.largestSubtreeSize = Math.max(leftr.largestSubtreeSize, rightr.largestSubtreeSize);
		}
		return r;
	}
}
