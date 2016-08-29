package algorithm.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Description :
 * Source : https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * Created_By : xmpy
 * Time : Aug 28, 2016 7:16:10 PM  
 */
public class CombinePhoneNumber{
    private String[] dict = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();

        if (digits == null || digits.length() == 0) {
            return res;
        }
        List<String> preRes = new ArrayList<String>();
        preRes.add("");
        
        for (int i = digits.length() - 1; i >= 0; i--) {
            res = new ArrayList<String>();
            int digit = digits.charAt(i) - '0';
            for (int j = 0; j < dict[digit].length(); j++) {
                for (int k = 0; k < preRes.size(); k++) {
                    res.add(dict[digit].charAt(j) + preRes.get(k));
                }
            }
            preRes = res;
        }
        return res;
    }
}
