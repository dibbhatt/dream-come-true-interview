package algorithm.dfs;

import org.junit.Test;

public class StrobogrammaticNumberIII {
    private static final String[] n1 = new String[]{"0", "1", "8"};
	private static final String[] n2 = new String[]{"00", "11", "69", "88", "96"};
	private int count = 0; 
    public boolean isStrobogrammatic(String num) {
        int i = 0;
        int j = num.length() - 1;
        
        while (i <= j) {
            if (!((num.charAt(i) == num.charAt(j) && (num.charAt(i) == '0' || num.charAt(i) == '1' || num.charAt(i) == '8')) || (num.charAt(i) == '6' && num.charAt(j) == '9') || (num.charAt(i) == '9' && num.charAt(j) == '6'))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
	public boolean dfs(int high, int low, char[] curr, long n) {
		// Only one
	    if (high == low) {
	    	for (String num : n1) {
	    		curr[high] = num.charAt(0);
	    		if (Long.parseLong(new String(curr)) < n) {
	    			count++;
	    		} else {
	    			return true;
	    		} 
	    	}
			return false;
	    }
	    // Two 
	    if ((high + 1) == low) {
	    	int i = curr.length == 2 ? 1 : 0;
	    	for (; i < n2.length; i++) {
	    		curr[high] = n2[i].charAt(0);
	    		curr[low] = n2[i].charAt(1);
	    		if (Long.parseLong(new String(curr)) < n) {
	    			count++;
	    		} else {
	    			return true;
	    		} 
	    	}
			return false;
	    }
    	int i = (low == curr.length - 1 ) ? 1 : 0;
    	for (; i < n2.length; i++) {
    		curr[high] = n2[i].charAt(0);
    		curr[low] = n2[i].charAt(1);
    		if (dfs(high + 1, low - 1, curr, n)) {
    			return true;
    		}
    	}
	    
	    return false;
	}
	
    public int findIdx(String n) { 
    	char[] curr = new char[n.length()];
    	dfs(0, n.length() - 1, curr, Long.parseLong(n));
    	int res = count;
    	count = 0;
    	return res;
    }
    
    public int countInLevel(int len) {
    	if (len == 1) {
    		return 3;
    	}
    	if (len == 2) {
    		return 4;
    	}
    	if (len % 2 == 0) {
    		return (int) ((Math.pow(5, len / 2 - 1)) * 4);
    	}
    	return (int) (3 * Math.pow(5, len / 2 - 1) * 4);
    }
    
    public int strobogrammaticInRange(String low, String high) {
    	if ( Long.parseLong(low) >   Long.parseLong(high)) {
    		return 0;
    	}
    	
    	int res = 0;
        for (int i = low.length() + 1; i < high.length(); i++) {
        	res += countInLevel(i);
        }
        
        res += findIdx(high);
        if (isStrobogrammatic(high)) {
        	res += 1;
        }
        res += countInLevel(low.length()) - findIdx(low);
        
        if (low.length() == high.length()) {
        	res -= countInLevel(low.length());
        }
        
        return res;
    }
}
