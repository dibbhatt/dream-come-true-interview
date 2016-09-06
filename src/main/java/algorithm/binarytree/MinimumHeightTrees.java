package algorithm.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumHeightTrees {
    public int dfs(Map<Integer, List<Integer>> edges, boolean[] visited, int curr, int currHeight) {
        int height = currHeight;
        visited[curr] = true;
        for (int neighbor : edges.get(curr)) {
            if (!visited[neighbor]) {
                height = Math.max(height, dfs(edges, visited, neighbor, currHeight + 1));
            }
        }
        return height;
    }
    
    
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, List<Integer>> edgeMap = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < n; i++) {
        	edgeMap.put(i, new ArrayList<Integer>());
        }
        for (int i = 0; i < edges.length; i++) {
        	edgeMap.get(edges[i][0]).add(edges[i][1]);
        	edgeMap.get(edges[i][1]).add(edges[i][0]);
        }
        int minHeight = Integer.MAX_VALUE;
         List<Integer>  res = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            Arrays.fill(visited, false);
            int height = dfs(edgeMap, visited, i, 0 );
            if (height < minHeight) {
                res.clear();
                minHeight = height;
                res.add(i);
            } else if (height == minHeight) {
                res.add(i);
            }
        }
        return res;
    } 
}
