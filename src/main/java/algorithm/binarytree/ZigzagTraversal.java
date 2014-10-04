package algorithm.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-7-17 
 * Time : 下午1:54:05
 */
public class ZigzagTraversal {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null){
            return result;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        boolean sign = true;
        
        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> r = new ArrayList<Integer>(size);
            for(int i = 0; i < size; i++){
            	r.add(0);
            }
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                if(sign){
                    r.set(i, node.val);
                }else{
                    r.set(size - 1 - i, node.val);
                } 
                if(node.left != null){
                	q.add(node.left);
                }
                if(node.right != null){
                	q.add(node.right);
                }
            }
            sign = !sign;
            result.add(r);
        }
        return result;
    }
}
