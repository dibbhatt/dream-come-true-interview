package algorithm.search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-7-30 
 * Time : 下午5:11:30
 */
public class Permutations {
    public List<List<Integer>> permute(int[] num) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(num, new ArrayList<Integer>(), result);
        return result;
    }
    
    public void dfs(int[] num, List<Integer> path, List<List<Integer>> result){
    	if(path.size() == num.length){
    		result.add(new ArrayList<Integer>(path));
    		return;
    	}
    	
    	for (int n : num){
    		if(! path.contains(n)){
    			path.add(n);
    			dfs(num, path, result);
    			path.remove(path.size() - 1);
    		}
    	}
    }
    
}
