package algorithm.sort;
/** 
 * Description : 
 * Source : itint5
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-9-30 
 * Time : 下午4:32:44
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

public class JobScheduler {
    /*
     * deps[id]表示任务id所依赖的任务
     * 如果存在合法的任务完成序列，返回true，否则返回false
     * 合法的任务序列请存放在参数result中（已经分配空间）
     */
    public boolean jobSchedule(Map<Integer, List<Integer>> deps, int n,
                                int[] result) {
    	
    	Map<Integer, List<Integer>> leads = new HashMap<Integer, List<Integer>>();
    	
    	int[] ins = new int[n];
    	Arrays.fill(ins, 0);
    	
    	Iterator iter = deps.entrySet().iterator(); 
    	
    	while (iter.hasNext()) {
    		Map.Entry<Integer, List<Integer>> entry = (Entry<Integer, List<Integer>>) iter.next();
    		ins[entry.getKey() - 1] = entry.getValue().size();
    		
    		for(Integer ii : entry.getValue()) {
    			
    			if (! leads.containsKey(ii)) {
    				leads.put(ii, new ArrayList<Integer>());
    			}
    			
    			leads.get(ii).add(entry.getKey());
    		}
    		
    	}
    	int start = 0;
    	int end = 0;
    	for (int i = 0; i < n; i++) {
    		if (ins[i] == 0) {
    			result[end] = i + 1;
    			end++;
    		}
    	}
		while (end != n && end != start) {
			int _start = end;
			int _end = _start;
			for (int i = start; i < end; i++) {
				if (!leads.containsKey(result[i])){
					continue;
				}
				for (int ii : leads.get(result[i])){
					ins[ii - 1] = ins[ii - 1] - 1;
					if (ins[ii - 1] == 0) {
						result[_end] = ii;  
						_end++;
					}
				}
			}			
			start = _start;
			end = _end;
		}
		
		if (end == n){
			return true;
		}
		
    	return false;
    }

    @Test
    public void test(){
    	//jobSchedule()
    }
}