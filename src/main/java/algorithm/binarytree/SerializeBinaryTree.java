package algorithm.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : Jul 15, 2014 
 * Time : 9:17:38 PM
 */
public class SerializeBinaryTree {
	public List<Integer> serialize(TreeNode root){
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		if (root == null){
			return result;
		}
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		
		while(!q.isEmpty()){
			int size = q.size();
			for (int i = 0; i < size; i++){
				TreeNode temp = q.poll();
				if (temp == null){
					result.add(Integer.MIN_VALUE);
					continue;
				}
				result.add(temp.val);
				q.add(temp.left);
				q.add(temp.right);
			}
		}
		return result;
	}
	
	
	public TreeNode deserialize(List<Integer> input){
		if(input.size() == 0){
			return null;
		}
	
		TreeNode root = new TreeNode(input.get(0));
		ArrayList<TreeNode> parents = new ArrayList<TreeNode>();
		parents.add(root);
		int curr = 1;
		
		while(!parents.isEmpty()){
			ArrayList<TreeNode> nextParents = new ArrayList<TreeNode>();
			
			for (int i = 0; i < parents.size() * 2 ; i++){
				int val = input.get(curr);
				TreeNode p = parents.get(i/2);
				TreeNode current = (val ==Integer.MIN_VALUE) ? null : new TreeNode(val);
				if (i % 2 == 0){
					p.left = current;
				}else{
					p.right = current;
				}
				if (current != null){
					nextParents.add(current);
				}
				curr++;
			}
			parents = nextParents;
		}
		return root;
	}
	
}
