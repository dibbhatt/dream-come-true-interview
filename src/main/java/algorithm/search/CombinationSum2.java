package algorithm.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-8-2 
 * Time : 下午12:25:08
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        Arrays.sort(num);
        boolean[] visited = new boolean[num.length];
        dfs(result, new ArrayList<Integer>(), visited, num, 0, target);
        return result;
    }
    public void dfs(List<List<Integer>> result, List<Integer> path, boolean[] visited, int[] num, int start, int target){
    	if(target == 0){
    		result.add(new ArrayList<Integer>(path));
    		return;
    	}
    	
    	for(int i = start; i < num.length; i++){
    		if (visited[i] == true){
    			continue;
    		}
    		if (i != 0 && num[i] == num[i-1] && visited[i-1] == false){
    			continue;
    		}
    		
    		if (num[i] > target){
    			continue;
    		}
    		
    		path.add(num[i]);
    		visited[i] = true;
    		
    		dfs(result, path, visited, num, i + 1, target - num[i]);
    		
    		path.remove(path.size() - 1);
    		visited[i] = false;
    	}
    }
}
