package algorithm.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Description :
 * Source : https://leetcode.com/problems/encode-and-decode-strings/
 * Created_By : xmpy
 * Time : Aug 29, 2016 7:16:10 PM  
 */
public class EncodeDecodeString {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length());
            sb.append(' ');
            sb.append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<String>();
        int start = 0;
        while(start < s.length()) {
            int end = start;
            for (; end < s.length(); end++) {
                if (s.charAt(end) == ' ') {
                    break;
                }   
            }
            int count = Integer.parseInt(s.substring(start, end));
            res.add(s.substring(end + 1, end + 1 + count));
            start = end + 1 + count;
        }
        return res;
    }
}
