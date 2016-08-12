package algorithm.permutation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PanlidromePermutationII {
    public List<String> generatePalindromes(String s) {
        Map<Character, Integer> countMap = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (!countMap.containsKey(s.charAt(i))) {
                countMap.put(s.charAt(i), 0);
            }
            countMap.put(s.charAt(i), countMap.get(s.charAt(i)) + 1);
        }
        boolean isPalindrome = true;
        Character oddChar = null;
        int count = 0;
        for (char c : countMap.keySet()) {
            if (countMap.get(c) % 2 != 0) {
            	if (oddChar == null)  {
            		oddChar = c;
                	countMap.put(oddChar, countMap.get(oddChar) - 1);
            	} else {
            		isPalindrome = false;
            		break;
            	}
            }
           countMap.put(c, countMap.get(c) / 2);
           count += countMap.get(c);
        }

        List<String> result = new ArrayList<String>();
        if (!isPalindrome) {
            return result;
        }
        
        List<List<Character>> res = new ArrayList<List<Character>>();
        dfs(count, countMap, new ArrayList<Character>(), res);
        
        for (List<Character> r : res) {
            StringBuffer sb = new StringBuffer();
            for (int i = r.size() - 1; i >= 0; i--) {
                sb.append(r.get(i));
            }
            if(oddChar != null) {
                sb.append(oddChar);
            }
            for(char c : r) {
                sb.append(c);
            }
            result.add(sb.toString());
        }
        return result;
    }
    
    public void dfs(int n, Map<Character, Integer> countMap, List<Character> curr, List<List<Character>> result) {
        if (curr.size() == n) {
           List<Character> copy = new ArrayList<Character>();
           copy.addAll(curr);
           result.add(copy);
           return;
        }
        
        for (char num : countMap.keySet()) {
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
