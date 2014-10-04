package algorithm.highfrequency;

import java.util.List;
import java.util.ArrayList;

import org.junit.Test;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-8-19 
 * Time : 上午1:07:14
 */
public class RestoreIP {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        if (s.length() < 4){
            return result;
        }
        
        
        for (int i = 0; i < s.length() - 3; i++){
            if (!isValid(s.substring(0, i + 1))){
                continue;
            }
            for (int j = i + 1; j < s.length() - 2; j++){
                if (!isValid(s.substring(i + 1, j+ 1))){
                	continue;
                }
                for (int k = j + 1; k < s.length() - 1; k++){
                    if (!isValid(s.substring(j + 1, k+ 1)) || !isValid(s.substring(k + 1))){
                    	continue;
                    }
                    String r = s.substring(0, i + 1) + "." + s.substring(i + 1, j+ 1) + "." + s.substring(j + 1, k+ 1) + "." + s.substring(k + 1);
                    result.add(r);
                }
                
            }
            
        }
        return result;
    }
    public boolean isValid(String s){
        if (s.length() > 3){
            return false;
        }
        int r = Integer.parseInt(s);
        if (s.charAt(0) == '0' && s.length() > 1){
        	return false;
        }
        if (r > 255){
            return false;
        }
        return true;
    } 
    
    @Test
    public void test(){
    	List<String> r = restoreIpAddresses("010010");
    	for (String rr: r){
    		System.out.println(rr);
    	}
    }
    
}
