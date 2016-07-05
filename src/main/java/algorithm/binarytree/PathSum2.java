package algorithm.binarytree;

import java.util.ArrayList;
import java.util.List;

/** 
 * Description :
 * Source : 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-10-14 
 * Time : 下午4:11:10
 */
public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(result, new ArrayList<Integer>(), root, sum);
        return result;
        
    }
    
    public void dfs (List<List<Integer>> result, List<Integer> path, TreeNode root, int sum) {
        
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                result.add(new ArrayList<Integer>(path));
            }
            path.remove(path.size() - 1);
            return;
        }
        
        if (root.left != null) {
            path.add(root.val);
            dfs(result, path, root.left, sum - root.val);
            path.remove(path.size() - 1);
        }
        
        if (root.right != null) {
            path.add(root.val);
            dfs(result, path, root.left, sum - root.val);
            path.remove(path.size() - 1);
        }
    }
}
