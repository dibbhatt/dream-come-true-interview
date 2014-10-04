package algorithm.highfrequency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : Aug 22, 2014 
 * Time : 11:24:28 AM
 */
public class Anagram {
    public List<String> anagrams(String[] strs) {
        HashMap<String, ArrayList<String>>  hash = new HashMap<String,ArrayList<String>>();
        List<String> result = new ArrayList<String>();
        
        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String temp = new String(arr);
            
            if (!hash.containsKey(temp)){
                hash.put(temp, new ArrayList<String>());
            }
            hash.get(temp).add(s);
        }
        
        for (String key : hash.keySet()){
        	ArrayList<String> temp = hash.get(key);
        	if (temp.size() >= 2){
        		for (String t:temp){
        			result.add(t);
        		}
        		
        	}
        	
        }
        
        return result;
    }
}
