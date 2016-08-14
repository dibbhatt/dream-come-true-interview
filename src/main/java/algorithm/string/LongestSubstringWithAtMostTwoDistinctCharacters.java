package algorithm.string;

public class LongestSubstringWithAtMostTwoDistinctCharacters {
	  public int lengthOfLongestSubstringTwoDistinct(String s) {
	        if (s == null || s.length() == 0) {
	    		return 0;
	    	}
	        Character firstChar = s.charAt(0);
	        Character secondChar = null;
	        
	        int firstEnd = 0;
	        int secondEnd = 0;
	        for (int i = 1; i < s.length(); i++) {
	            if (s.charAt(i) == firstChar){
	                firstEnd++;
	            } else {
	                break;   
	            }
	        }
	        
	        int start = firstEnd + 1;
	        int currStrStart = 0;
	        int maxLen = Integer.MIN_VALUE;
	        
	        while(start < s.length()) {
	        	int i = start;
	            for (; i < s.length(); i++) {
	                char c = s.charAt(i);
	                if (c != firstChar) {
	                    if (secondChar == null) {
	                        secondChar = c;
	                        secondEnd = i;
	                    } else {
	                        if (c == secondChar) { // Is second char
	                            secondEnd = i;
	                        } else {
	                            maxLen = Math.max(maxLen, i - currStrStart);
	                            if (firstEnd > secondEnd) {
	                                currStrStart  = secondEnd + 1;
	                                secondChar = null;
	                            } else {
	                                currStrStart = firstEnd + 1;
	                                firstChar = secondChar;
	                                firstEnd = secondEnd;
	                                secondChar = null;
	                            }
	                            break;
	                        }
	                    }
	                } else { //Is first char
	                	 firstEnd = i;
	                }
	                
	            }
                start = i;
	        }
	        maxLen = Math.max(maxLen, s.length() - currStrStart);
	        
	        return maxLen;
	    }
}
