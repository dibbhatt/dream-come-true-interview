package algorithm.array;

import org.junit.Test;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-9-9 
 * Time : 上午12:19:47
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        
        int [][] result = new int[n][n];
        int next = 1;
        
        int start_x = 0; int start_y = 0;
        int end_x = n - 1; int end_y = n - 1;
        
        while(start_x <= end_x && start_y <= end_y) {
            for (int i = start_y; i <= end_y; i++) {
                result[start_x][i] = next;
                next++;
            }
            
            for (int i = start_x + 1; i < end_x; i++) {
                result[i][end_y] = next;
                next++;
            }
            
            if (start_x != end_x) {
                for (int i = end_y; i >= start_y; i--) {
                    result[end_x][i] = next;
                    next++;
                }
            }
            
            if (start_y != end_y) {
                for(int i = end_x - 1; i > start_x; i--) {
                    result[i][start_x] = next;
                    next++;
                }
            }
            start_x += 1; start_y += 1;
            end_x -= 1; end_y -= 1;
        }
        return result;
    }
    
    @Test
    public void test(){
    	int n = 4;
    	int[][] result = generateMatrix(4);
    	
    	for (int i = 0; i < n; i++) {
    		for (int j = 0; j < n; j++) {
    			System.out.print(" ");
    			System.out.print(result[i][j]);
    		}
    		System.out.println();
    		}
    }
}
