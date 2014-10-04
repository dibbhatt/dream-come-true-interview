package algorithm.stack;

import java.util.Stack;

import org.junit.Test;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-8-20 
 * Time : 下午2:22:46
 */
public class MaximalRectangle {
	   public int maximalRectangle(char[][] matrix) {
	        if(matrix.length == 0){
	            return 0;
	        }
	        
	        int[][] state = new int[matrix.length][matrix[0].length];
	        
	        for (int j = 0; j < matrix[0].length; j++){
	            if (matrix[0][j] == '1'){
	                state[0][j] = 1;
	            } else {
	                state[0][j] = 0;
	            }
	            
	        }
	        
	        for (int i = 1; i < matrix.length; i++){
	            for (int j = 0; j < matrix[0].length; j++){
	                if (matrix[i][j] == '1'){
	                    state[i][j] = state[i - 1][j] + 1;
	                } else {
	                    state[i][j] = 0;
	                }
	                System.out.println(i+","+j + ":" + state[i][j]);
	            }
	        }
	        int max = 0;
	        for (int i = 0; i < matrix.length; i++){
	            int r = maxRectOnLine(state[i]);
	        	System.out.println(r);

	            if (r > max){
	                max = r;
	            }
	        }
	        return max;
	    }
	    
	    public int maxRectOnLine(int[] height){
	        Stack<Integer> s = new Stack<Integer>();
	        int max = 0;
	        for (int i = 0; i <= height.length; i++){
	            int curr = (i == height.length) ? -1 : height[i];
	            while( s.size() > 0 && height[s.peek()] >= curr) {
	                int h = height[s.pop()];
	                int start = 0;
	                if (s.size() != 0){
	                    start = s.peek() + 1;
	                }
	                int w = i - start;
	                if (h * w > max){
	                    max = h * w;
	                }
	            }
	            s.push(i);
	        }
	        return max;
	    }
	    
	    @Test
	    public void test(){
	    	char[][] in = new char[6][4];
	    	in[0][0] = '0'; in[0][1] = '0'; in[0][2] = '1'; in[0][3] = '0';
	    	in[1][0] = '1'; in[1][1] = '1'; in[1][2] = '1'; in[1][3] = '1';
	    	in[2][0] = '1'; in[2][1] = '1'; in[2][2] = '1'; in[2][3] = '0';
	    	in[3][0] = '1'; in[3][1] = '1'; in[3][2] = '0'; in[3][3] = '0';
	    	in[4][0] = '1'; in[4][1] = '1'; in[4][2] = '1'; in[4][3] = '1';
	    	in[5][0] = '1'; in[5][1] = '1'; in[5][2] = '1'; in[5][3] = '0';
	    	
	    	int score = maximalRectangle(in);
	    	System.out.println(score);
	    	
	    }
}
