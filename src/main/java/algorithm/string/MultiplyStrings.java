package algorithm.string;

import org.junit.Test;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-8-28 
 * Time : 下午9:41:32
 */
public class MultiplyStrings {
    public int jin(int[] output, int n, int carries) {
        
        while (carries != 0) {
            int curr = output[n] + carries;
            output[n] = curr % 10;
            carries = curr / 10;
            n++;
        }
        
       return n--;
    }
    
    
    public String multiply(String num1, String num2) {
        int[] output = new int[num1.length() + num2.length()];
        
        String rst = "";
        int carries = 0;
        

        int start = 0;
        int end = 0;
        
        for (int i = num1.length() - 1; i >= 0; i--) {
            int begin = 0;
            for (int j = num2.length() - 1; j >= 0; j--) {
                int a = num1.charAt(i) - '0';
                int b = num2.charAt(j) - '0';
                int curr = a*b + output[start + begin] + carries;
                
                output[start + begin] = curr % 10;
                carries = curr / 10;
                begin++;
            }
            
            end = jin(output, start + begin, carries);
            carries = 0;
           /// end = start + begin;
            start++;
        }
        
        while(end > 0 && output[end - 1] == 0){
        	end--;
        }
        if (end == 0){
        	return "0";
        }
        
        for (int i = 0; i < end; i++){
            char c = (char) (output[i] + '0');
            rst = c + rst;
        }
        return rst;
    }
    
    @Test
    public void test(){
    	String r = multiply("999999", "0");
    	System.out.println(r);
    }
}
