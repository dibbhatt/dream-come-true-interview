package algorithm.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-7-17 
 * Time : 下午1:24:38
 */
public class LevelTraversal {
    public  List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null){
            return result;
        }
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        
        while(!q.isEmpty()){
            //每次遍历一层
            int size = q.size();
            ArrayList<Integer> r = new ArrayList<Integer>();
            for(int i = 0; i < size; i++){
                TreeNode temp = q.poll();
                r.add(temp.val);
                if(temp.left != null){
                    q.add(temp.left);
                }
                if(temp.right != null){
                    q.add(temp.right);
                }
            }
            result.add(r);
        }
        return result;    
    }
}
