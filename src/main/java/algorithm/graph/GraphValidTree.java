package algorithm.graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author zhaxi22
 * 
 *
 */
public class GraphValidTree {
    /*
     * According to the definition of tree on Wikipedia: 
     * “a tree is an undirected graph in which any two vertices 
     * are connected by exactly one path. In other words, 
     * any connected graph without simple cycles is a tree.”
     */
	public boolean dfs(List<List<Integer>> edges, boolean[] visited, int parent, int curr) {
        visited[curr] = true;
        for (int out : edges.get(curr)) {
        	if (out == parent) {
        		continue;
        	}
            if (visited[out]) {
                return false;
            }
            boolean r = dfs(edges, visited, curr, out);
            if (!r) {
                return false;
            }
        }
        return true;
    }
    
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != (n - 1)) {
            return false;
        }
        
        List<List<Integer>> edgeList = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            edgeList.add(new ArrayList<Integer>());
        }
        
        for (int[] edge : edges) {
            edgeList.get(edge[0]).add(edge[1]);
            edgeList.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        if (!dfs(edgeList, visited, -1, 0)) {
            return false; // It is cyclic.
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false; //It is not connected.
            }
        }
        
        return true;
    }
}
