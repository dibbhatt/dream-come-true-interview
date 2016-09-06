package algorithm.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumHeightTrees2 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, List<Integer>> edgeMap = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < n; i++) {
        	edgeMap.put(i, new ArrayList<Integer>());
        }
        int[] inDegrees = new int[n]; 
        Arrays.fill(inDegrees, 0);
    
        for (int i = 0; i < edges.length; i++) {
        	edgeMap.get(edges[i][0]).add(edges[i][1]);
        	edgeMap.get(edges[i][1]).add(edges[i][0]);
        	inDegrees[edges[i][0]] += 1;
        	inDegrees[edges[i][1]] += 1;
        }
        
        boolean[] removed = new boolean[n];
        Arrays.fill(removed, false);
        
        int count = n;
        while (count > 2) {
            List<Integer> leafs = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                if (!removed[i] &&  inDegrees[i] <= 1) {
                    removed[i] = true;
                    count--;
                    leafs.add(i);
                }
            }
            
            for (int leaf : leafs) {
                for (int other : edgeMap.get(leaf)) {
                    if(!removed[other]) {
                       inDegrees[other]--;
                    }
                }
            }
        }
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (!removed[i]) {
                res.add(i);
            }   
        }
        return res;
    } 
}
