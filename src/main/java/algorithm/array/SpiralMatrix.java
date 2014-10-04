package algorithm.array;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-9-4 
 * Time : 下午10:16:15
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> result = new ArrayList<Integer>();
        
        if (matrix.length == 0) {
            return result;
        }
        
        int startX = 0; int startY = 0;
        int endX = matrix.length - 1; int endY = matrix[0].length - 1;
        
        while (startX <= endX && startY <= endY) {
            for (int i = startY; i <= endY; i++) {
                result.add(matrix[startX][i]);
            }
            
            for (int i = startX + 1; i <= endX - 1; i++) {
            
                result.add(matrix[i][endY]);
            }
            if (endX != startX){
                for (int i = endY; i >= startY; i--) {
                    result.add(matrix[endX][i]);
                }
                
                if (startY != endY) {
                	for (int i = endX - 1; i >= startX + 1; i--) {
                		result.add(matrix[i][startY]);
                	}
                }
            }
            
            startX += 1;
            startY += 1;
            
            endX -= 1;
            endY -= 1;
        }
        
        return result;
    }
    
    @Test
    public void test(){
    	int[][] m = new int[10][1];
    	for (int i = 0; i < 10; i++) {
    		m[i][0] = i+ 1;
    	}
    	
    	System.out.println(spiralOrder(m));
    }
    
}
