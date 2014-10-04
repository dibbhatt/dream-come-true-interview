package algorithm.highfrequency;

import org.junit.Test;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-8-21 
 * Time : 上午12:12:36
 */
public class AddBinary {
    public String addBinary(String a, String b) {
    	int alen = a.length();
    	int blen = b.length();
    	
    	
    	int len = Math.max(alen, blen) + 1;
    	
    	char[] output = new char[len];
    	
    	int i = alen - 1;
    	int j = blen - 1;
    	int jin = 0;
    	int wei = 0 ;
    	
    	while (i >= 0 || j >= 0){
    		int aa = 0;
    		int bb = 0;
    		if (i >= 0)
    			aa = a.charAt(i) == '1' ? 1 :0;
    		if (j >= 0)
    			bb = b.charAt(j) == '1' ? 1 :0;
    		
    		int curr = (aa + bb + jin) % 2;
    		jin = (aa + bb + jin) / 2;
    		
    		output[wei] = curr == 1 ? '1' : '0'; 
    		
    		wei++;
    		i--;
    		j--;
    	}
    	if (jin == 1){
    		output[wei] = '1';
    		wei++;
    	}
    	

    	StringBuffer sb = new StringBuffer();
    	
    	for (int k = wei - 1; k >= 0; k--){
    		sb.append(output[k]);
    	}
    	return sb.toString();
    }

    
    
    @Test
    public void test(){
    	String r = addBinary("11", "1");
    	System.out.println(r);
    }
}
