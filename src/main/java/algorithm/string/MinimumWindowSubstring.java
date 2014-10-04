package algorithm.string;

import java.util.HashMap;

import org.junit.Test;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-8-31 
 * Time : 下午5:02:40
 */
public class MinimumWindowSubstring {
    public String minWindow(String S, String T) {
        
        HashMap<Character, Integer> toFind = new HashMap<Character, Integer>();
        HashMap<Character, Integer> found = new HashMap<Character, Integer>();
        
        int minLen = Integer.MAX_VALUE;
        String minStr = "";
        
        
        for (int i = 0; i < T.length(); i++){
            if (!toFind.containsKey(T.charAt(i))){
                toFind.put(T.charAt(i), 1);
            } else {
                toFind.put(T.charAt(i), toFind.get(T.charAt(i)) + 1);
            }
        }
        
        System.out.println(toFind);
        int start = 0;
        int aimed = 0;
        int leftBound = 0;
        while (start < S.length()) {
            //found.clear();
            int i = 0;

            while (start + i < S.length()) {
            	System.out.println("+" + found);
            	System.out.println("+" + aimed);
                char curr = S.charAt(start + i);
                if (toFind.containsKey(curr)) {

                	if (!found.containsKey(curr)){
                        found.put(curr, 1);
                    } else {
                        found.put(curr, found.get(curr) + 1);
                    }
                    
                    if (found.get(curr) <= toFind.get(curr)) {
                    	aimed++;
                    }
                } 
                i++;
                if (aimed == T.length()){
                	System.out.println("+" + aimed);
                    break;
                }
            
            }
            
            System.out.println("!" + found);
            if (aimed == T.length()){
            	int k = leftBound;
                for(; k < start + i; k++) {
                    char curr = S.charAt(k);
                    if (toFind.containsKey(curr)){
                            found.put(curr, found.get(curr) - 1);
                            if (found.get(curr) < toFind.get(curr)) {
                            	aimed--;
                            	break;
                            	
                            }                  
                    }
            
                }
                leftBound = k;
                if (start + i - k < minLen){
                    minLen = start + i - k;
                    minStr = S.substring(k, start + i);
                }
                
                leftBound = k + 1;
                start = start + i;
            }
            
            
            else {
               break;
            }
        }
        return minStr;
    }
    
    @Test
    public void test(){
    	String s = "bdab";
    	String t = "ab";
    	String r = minWindow(s, t);
    	System.out.println(r);
    }
    
}
