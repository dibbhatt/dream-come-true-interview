package algorithm.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Description :
 * Source : https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * Created_By : xmpy
 * Time : Aug 28, 2016 7:45:59 PM  
 */
public class CombinePhoneNumber2 {
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
               
        helper(digitList, 0, new int[digitList.size()], res);
        return res;
    }
    
    private void helper(List<Integer> digits, int idx, int[] idxs, List<String> res) {
    	// Render the result
    	if (idx == digits.size()) {
    		StringBuilder sb = new StringBuilder();
    		for (int i = 0; i < idxs.length; i++ ) {
    			sb.append(dict[digits.get(i)].charAt(idxs[i]));
    		}
    		res.add(sb.toString());
    		return;
    	}
    	for (int i = 0; i < dict[digits.get(idx)].length(); i++) {
    		idxs[idx] = i;
    		helper(digits, idx + 1, idxs, res);
    	}
    }	
}
