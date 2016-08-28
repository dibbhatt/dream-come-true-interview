package algorithm.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinePhoneNumber3 {
    private String[] dict = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        List<Integer> digitList = new ArrayList<Integer>();
        
        for (int i = 0; i < digits.length(); i++) {
        	int d = digits.charAt(i) - '0';
        	if (d != 1) { // Skip "1"
        		digitList.add(d);
        	}
        }
        
        int[] idxes = new int[digitList.size()];
        Arrays.fill(idxes, 0);
        boolean finished = false;
        
        while (true) {
        	//Render the result
    		StringBuilder sb = new StringBuilder();
        	for (int i = 0; i < idxes.length; i++) {
        		sb.append(dict[digitList.get(i)].charAt(idxes[i]));
        	}
        	res.add(sb.toString());
        	
        	for (int i = 0; i < idxes.length; i++) {
        		idxes[i]++;
        		
        		if (idxes[i] == dict[digitList.get(i)].length()) {
        			idxes[i] = 0;
        			if (i == idxes.length - 1) {
        				finished = true;
        			}
        		} else {
        			break;
        		}
        	}
        	if (finished) {
        		break;
        	}
        }
        return res;
    }
}
