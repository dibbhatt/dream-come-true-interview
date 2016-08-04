package algorithm.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class JumpGame {
    public int jumpBruteForceBfs(int[] nums) {
    	if (nums == null || nums.length == 0) {
    		return -1;
    	}
    	if (nums.length == 0) {
    		return 0;
    	}
    	boolean[] reached = new boolean[nums.length];
    	Arrays.fill(reached, false);
    	
    	//Bfs
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(0);
        
        int levelId = 1;
        
        while (!queue.isEmpty()) {
        	int levelSize = queue.size();
        	// For each level.
        	for (int i = 0; i< levelSize; i++) {
            	int head = queue.poll();
            	reached[head] = true;
            	for (int j = 0; j < nums[head]; j++) {
            		int reachIdx = head + j + 1;
            		if ( reachIdx == (nums.length - 1)) {
            			return levelId;
            		}
            		if ( reachIdx >= nums.length) {
            			break;
            		}
            		if (!reached[reachIdx]) {
            			queue.add(reachIdx);
            		}
            	}
        		
        	}        	
        	levelId++;
        }
    	return -1;
    }
    
    public int jumpBfs(int[] nums) {
    	if (nums == null || nums.length == 0) {
    		return -1;
    	}
    	if (nums.length == 1) {
    		return 0;
    	}
    	
    	int start = 0; 
    	int end = 0;
    	int maxReach = end;
    	int steps = 1;
    	
    	// While ( Elements in this level exist )
    	while ( start <= end) {
    		for (int i = start; i <= end; i++) {
    			int furthest = i + nums[i];
    			if (furthest >= (nums.length - 1)) {
    				return steps;
    			}
    			if (furthest > maxReach) {
    				maxReach = furthest;
    			}
    		}
    		start = end + 1;
    		end = maxReach;
    		steps++;
    	}
    	return -1;
    }
    
}
