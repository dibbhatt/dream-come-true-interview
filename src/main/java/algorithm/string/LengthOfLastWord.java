package algorithm.string;

import org.junit.Test;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-9-4 
 * Time : 下午9:27:43
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {

        int i = s.length() - 1;
        
        while(i >= 0 && s.charAt(i) == ' '){
        	i--;
        }
        int end = i;
        
        for (; i >= 0; i--){
            if (s.charAt(i) == ' '){

                break;
            }
        }
        return (end + 1) - (i + 1);
   }
    
    
    @Test
    public void test(){
    	System.out.println(lengthOfLastWord("a "));
    	
    }
}
