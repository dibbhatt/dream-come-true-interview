package algorithm.string;

import java.util.HashMap;
import java.util.Map;

public class RansomeNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> countMap = new HashMap<Character, Integer>();
        
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            if (!countMap.containsKey(c)) {
                countMap.put(c, 0);
            }
            countMap.put(c, countMap.get(c) + 1);
        }
        
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (!countMap.containsKey(c) || countMap.get(c) == 0) {
                return false;
            } 
            countMap.put(c, countMap.get(c) - 1);
        }
        return true;
    }
}
