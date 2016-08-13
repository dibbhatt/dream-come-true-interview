package algorithm.permutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description :
 * Source : https://leetcode.com/problems/permutations-ii/
 * Created_By : xmpy
 * Time : Aug 11, 2016 10:06:11 PM  
 */
public class PermutationII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        for (int num : nums){
            if (! countMap.containsKey(num)) {
                countMap.put(num, 0);
            }
            countMap.put(num, countMap.get(num) + 1);
        }
        dfs(nums.length, countMap, new ArrayList<Integer>(), result);
        return result;
    }
    
    public void dfs(int n, Map<Integer, Integer> countMap, List<Integer> curr, List<List<Integer>> result) {
        if (curr.size() == n) {
           List<Integer> copy = new ArrayList<Integer>();
           copy.addAll(curr);
           result.add(copy);
           return;
        }
        
        for (int num : countMap.keySet()) {
            if (countMap.get(num) != 0) {
                curr.add(num);
                countMap.put(num, countMap.get(num) - 1);
                dfs(n, countMap, curr, result);
                countMap.put(num, countMap.get(num) + 1);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
