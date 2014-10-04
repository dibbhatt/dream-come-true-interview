package algorithm.search;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-7-30 
 * Time : 下午5:51:28
 */
public class Permutations2 {
    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        boolean[] visited = new boolean[num.length];
        
        for (int i = 0; i < visited.length; i++){
        	visited[i] = false;
        }
        
        Arrays.sort(num);
        dfs(num, visited, new ArrayList<Integer>(), result);
        
        return result;
    }
    
    public void dfs(int[] num, boolean[] visited, List<Integer> path, List<List<Integer>> result){
    	if(path.size() == num.length){
    		result.add(new ArrayList<Integer>(path));
    		return;
    	}
    	
    	for (int i = 0; i < num.length; i++){
    		if( i!=0 && num[i-1] == num[i] && visited[i-1] == false){
    			continue; //Prune away
    		}
    		if(!visited[i]){
    			path.add(num[i]);
    			visited[i] = true;
    			dfs(num, visited, path, result);
    			path.remove(path.size() - 1);
    			visited[i] = false;
    		}
    	}
    }
}
