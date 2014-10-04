package algorithm.bfs;

import java.util.ArrayList;
import java.util.List;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-9-19 
 * Time : 下午4:03:28
 */
public class WordLadder2 {
	
	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
    	ArrayList<List<String>> result = new ArrayList<List<String>>();
    	int level = getShortestLen(start, end, dict);
    	ArrayList<String> path = new ArrayList<String>();
    	path.add(start);
    	Set<String> visited = new HashSet<String>();
    	visited.add(start);
    	dfs(result, path, visited, start, end ,level,dict );
    	return result;
    }
    
    public int getShortestLen(String start, String end, Set<String> d){
    	Set<String> dict = new HashSet<String>(d);
    	Queue<String> q = new LinkedList<String>();
    	int level = 0;
    	
    	q.add(start);
    	
    	while(!q.isEmpty()){
       		int s = q.size();
   			level += 1;
       		for (int l = 0; l < s; l++){
           		String wo = q.poll();
	    		for (int i = 0; i < wo.length(); i++){
	           		String w = new String(wo);
	        		char[] warr = w.toCharArray();
	    			for (char c = 'a'; c <= 'z'; c++){
	    				warr[i] = c;
	    				String temp = new String(warr);

	    				if (dict.contains(temp)){
	    					q.add(temp);

	    					dict.remove(temp);
	    				}
    					if (temp.equals(end)){
    						return level;
    					}
	    			}
	    			
	    			
	    		}
       		}
    	}
    	
    	
    	return level;
    }
    
    
    public boolean canReach(String w, String end){
		for (int i = 0; i < w.length(); i++){
    		char[] warr = w.toCharArray();
			for (char c = 'a'; c <= 'z'; c++){
				warr[i] = c;
				String temp = new String(warr);
				if (temp.equals(end)){
					return true;
				}
			}
		}
		return false;
    }
    
    
    public void dfs(ArrayList<List<String>> result, ArrayList<String> path, Set<String> visited, String start, String end, int sl,Set<String> dict){
    	if(path.size() == sl){

    		if(canReach(start,end)){
    			path.add(end);
    			result.add(new ArrayList<String>(path));
    			path.remove(path.size() - 1);
    		}
    		return ;
    	}
		for (int i = 0; i < start.length(); i++){
    		String o = new String(start);
			char[] warr = o.toCharArray();
			for (char c = 'a'; c <= 'z'; c++){
				warr[i] = c;
				String temp = new String(warr);
				if (dict.contains(temp)){
					visited.add(temp);
					path.add(temp);

			    	dfs(result, path, visited, temp, end, sl, dict);
			    	visited.remove(temp);
			    	path.remove(path.size() - 1);
				}
			}
		}
		
    }
}
