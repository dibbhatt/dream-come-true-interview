package algorithm.string;

import org.junit.Test;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-8-16 
 * Time : 下午4:24:48
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }
        
        if (strs.length == 1){
            return strs[0];
        }
        boolean flag = true;
        int index = 0;

        for (int i = 0; i < strs[0].length() && flag; i++){
            char t = strs[0].charAt(i);
            for (int j = 1; j < strs.length && flag; j++){
                if (i >= strs[j].length() ||strs[j].charAt(i) != t){
                    flag = false;
                    index = i;
                }
            }
        }
        if (flag){
        	return strs[0];
        }
        if (index == 0){
        	return "";
        }
        return strs[0].substring(0, index  );
    }
    
    @Test
    public void test(){
    	String[] a = new String[]{"c", "c"};
    	String r = longestCommonPrefix(a);
    	System.out.println(r);
    }
}
