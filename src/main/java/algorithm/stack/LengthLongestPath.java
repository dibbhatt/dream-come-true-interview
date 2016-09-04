package algorithm.stack;

import java.util.Deque;
import java.util.LinkedList;

public class LengthLongestPath {
    public int lengthLongestPath(String input) {
        int longest = 0;
        int start = 0;
        Deque<String> stack = new LinkedList<String>();
        while (start < input.length()) {
        	int end = start + input.substring(start).indexOf("\n");
          	if (input.substring(start).indexOf("\n") == -1) {
          		end = input.length();
          	}
        	String pathPart = input.substring(start, end);
        	int tabCount = 0;
        	int pathNameStart = 0;
        	 for (int i = 0; i < pathPart.length(); i++) {
        		 if (pathPart.charAt(i) == '\t') {
        			 pathNameStart++;
        			 tabCount++;
        		 } else {
        			 break;
        		 }
        	 }
        	if (tabCount + 1 <= stack.size()) {
        		if (stack.peekFirst().indexOf('.') != -1) {
	        		int len = 0;
	        		for (String s : stack) {
	        			len += s.length();
	        		}
	        		longest = Math.max(longest, len + stack.size() - 1 );
        		}
        		// Pop out
        		int stacklen = stack.size();
        		for (int i = 0; i < stacklen- tabCount; i++) {
        			stack.removeFirst();
        		} 
        		stack.addFirst(pathPart.substring(pathNameStart));
        		
        	} else {
        		stack.addFirst(pathPart.substring(pathNameStart));
        	}
        	start += pathPart.length() + 1;
        }
		if (stack.peekFirst().indexOf('.') != -1) {
	        int len = 0;
			for (String s : stack) {
				len += s.length();
			}
			longest = Math.max(longest, len + stack.size() - 1 );
		}
		return longest;
    }
}
