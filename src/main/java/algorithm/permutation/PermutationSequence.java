package algorithm.permutation;

import org.junit.Test;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-9-2 
 * Time : 下午2:13:23
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
    	if (n == 1){
    		return "1";
    	}
        
        int factor = 1;
        for (int i = 1; i < n; i++) {
            factor *= i;
        }
        
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++){
        	//System.out.println(visited[i]);
        }
        StringBuffer sb = new StringBuffer();
        
        k = k - 1;
        for (int i = 0; i < n; i++) {
            int index =  k / factor;
            k = k % factor;
            
            int j = 0;
            for (; j <= index; j++){
                if (visited[j]){
                    index++;
                }
            }
            visited[index] = true;
            sb.append(index + 1);
           // System.out.println(index + 1);
            if (i != n -1)
            	factor /= n - i - 1;
        }
        
        return sb.toString();
    }
    
    @Test
	public void test() {
    	
    	String r = getPermutation(2,2);
    	System.out.println(r);
		
	}
    
}
