package algorithm.permutation;

import java.util.HashMap;
import java.util.Map;

public class PanlindromePermutation {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> countMap = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (!countMap.containsKey(s.charAt(i))) {
                countMap.put(s.charAt(i), 0);
            }
            countMap.put(s.charAt(i), countMap.get(s.charAt(i)) + 1);
        }
        boolean hasOdd = false;
        for (char c : countMap.keySet()) {
            if (countMap.get(c) % 2 != 0) {
            	if (!hasOdd) {
            		hasOdd = true;
            	} else {
            		return false;
            	}
            }
        }
        return true;
    }
}
