package algorithm.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-8-27 
 * Time : 下午11:35:37
 */
public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String S, String[] L) {
        int n = L.length;
        int m = L[0].length();
        
        HashMap<String, Integer> toFind = new HashMap<String, Integer>();
        HashMap<String, Integer> found = new HashMap<String, Integer>();
        
        List<Integer> result = new ArrayList<Integer>();
        
        for (int i = 0; i < n; i++){
            if (toFind.containsKey(L[i])){
                toFind.put(L[i], toFind.get(L[i]) + 1);
            }else {
                toFind.put(L[i], 1);
            } 
        }
        
        for (int i = 0; i <= S.length() - m*n; i++){
            found.clear();
            boolean flag = true;
            
            for (int j = 0; j < n; j++){
                String curr = S.substring(i + j*m, i + (j+1)*m);
                if (!toFind.containsKey(curr)){
                    flag = false;
                    break;
                }
                if (found.containsKey(curr)){
                    found.put(curr, found.get(curr) + 1);
                    if (found.get(curr) > toFind.get(curr)){
                        flag = false;
                        break;
                    }
                }else {
                    found.put(curr, 1);
                } 
                
            }
            if (flag){
                result.add(i);
            }
        }
        
       return result;
    }
    
    @Test
    public void test(){
    	String s = "barfoothefoobarman";
    	String[] l = new String[]{"foo", "bar"};
    	List<Integer> r = findSubstring(s, l);
    	System.out.println(r);
    	
    }
    
    
}
