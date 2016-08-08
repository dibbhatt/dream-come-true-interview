package algorithm.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistanceII {
    private Map<String, List<Integer>> idxMap = new HashMap<String, List<Integer>>();
	
	public ShortestWordDistanceII(String[] words) {
        for (int i = 0; i < words.length; i++) {
        	String word = words[i];
        	if (idxMap.containsKey(word)) {
        	} else {
        		idxMap.put(word, new ArrayList<Integer>());
        	}
    		idxMap.get(word).add(i);        	
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> idxList1 = idxMap.get(word1);
        List<Integer> idxList2 = idxMap.get(word2);
        
        int i = 0;
        int j = 0;
        
        int diff = Integer.MAX_VALUE;
        
        while(i != idxList1.size() && j != idxList2.size()) {
        	diff = Math.min(diff, Math.abs(idxList1.get(i) - idxList2.get(j)));
        	if (idxList1.get(i) < idxList2.get(j)) {
        		i++;
        	} else {
        		j++;
        	}
        }
        return diff;
    }

	// Your WordDistance object will be instantiated and called as such:
	// WordDistance wordDistance = new WordDistance(words);
	// wordDistance.shortest("word1", "word2");
	// wordDistance.shortest("anotherWord1", "anotherWord2");
}
