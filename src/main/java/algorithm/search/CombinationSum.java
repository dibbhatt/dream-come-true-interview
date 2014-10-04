package algorithm.search;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 
	For example, given candidate set 2,3,6,7 and target 7, 
	A solution set is: 
	[7] 
	[2, 2, 3] 
 * 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-8-2 
 * Time : 下午12:11:37
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        dfs(result, new ArrayList<Integer> (), candidates, 0, 0, target);
        return result;
    }
    
    public void dfs(List<List<Integer>> result, List<Integer> path, int[] candidates, int start, int sum, int target){
        
        if (sum > target){
            return;
        }
        
        if (sum == target){
            result.add(new ArrayList<Integer>(path));
            return;
        }
        
        for (int i = start; i < candidates.length; i++){
            path.add(candidates[i]);
            sum += candidates[i];
            
            dfs(result, path, candidates, i, sum, target);
            
            path.remove(path.size() - 1);
            sum -= candidates[i];
        }
        
    }
}
