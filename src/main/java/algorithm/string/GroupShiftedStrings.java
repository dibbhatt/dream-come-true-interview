package algorithm.string;

import java.util.ArrayList;
import java.util.List;

public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<List<String>>();
        
        for (String str : strings) {
            boolean belongs = false;
            for (List<String> group : result) {
                if (belongs(str, group)) {
                    group.add(str);
                    belongs = true;
                    break;
                }
            }
            if (!belongs) {
                List<String> r = new ArrayList<String>();
                r.add(str);
                result.add(r);
            }
        }
        return result;
    }
    
    public boolean belongs(String str, List<String> group) {
        String base = group.get(0);
        if (str.length() != base.length()) {
            return false;
        }
        if (str.length() == 0) {
            return true;
        }
        
        int diff = str.charAt(0) - base.charAt(0);
        diff = diff < 0 ? diff + 26 : diff;
        for (int i = 1; i < base.length(); i++) {
        	char targetChar = (char) (base.charAt(i) + diff > 'z' ? base.charAt(i) + diff - 26 : base.charAt(i) + diff);
            if (str.charAt(i) != targetChar) {
                return false;
            }
        }
        return true;
    }
}
