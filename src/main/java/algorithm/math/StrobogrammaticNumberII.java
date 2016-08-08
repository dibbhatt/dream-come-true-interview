package algorithm.math;

import java.util.ArrayList;
import java.util.List;

public class StrobogrammaticNumberII {
	
	public boolean isPossibleNumber(char c) {
		if (c == '0' || c== '1' || c =='8' || c == '6' || c == '9' ) {
			return true;
		}
		return false;
	}
	
    public boolean isStrobogrammatic(String num) {
        int i = 0;
        int j = num.length() - 1;
        
        while (i <= j) {
        	if (!isPossibleNumber(num.charAt(i)) || !isPossibleNumber(num.charAt(j))) {
        		return false;
        	}
        	
            if (!((num.charAt(i) == num.charAt(j) && (num.charAt(i) == '0' || num.charAt(i) == '1' || num.charAt(i) == '8')) || (num.charAt(i) == '6' && num.charAt(j) == '9') || (num.charAt(i) == '9' && num.charAt(j) == '6'))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public List<String> findStrobogrammatic(int n) {
    	List<String> res = new ArrayList<String>();
        int start = 0;
        int end = 9;
        if (n != 1) {
        	start = 1;
        	for (int i = 0; i < n - 1; i++) {
        		start *= 10;
        		end = end * 10 + 9;
        	}
    	}
    	
    	for(; start <= end; start++) {
    		String str = Integer.toString(start);
    		if (isStrobogrammatic(str)) {
    			res.add(str);
    		}
    	}
    	return res;
    }
}
