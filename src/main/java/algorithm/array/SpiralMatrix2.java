package algorithm.array;

import java.util.ArrayList;
import java.util.List;
/**
 * Description :
 * Source : https://leetcode.com/problems/spiral-matrix/
 * Created_By : xmpy
 * Time : Aug 15, 2016 9:53:54 PM  
 */
public class SpiralMatrix2 {
    private static int[][] steps = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int offset = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        
        int circleCount = Math.min(m, n) / 2;
        
        for (; offset < circleCount; offset++) {
            int x = offset;
            int y = offset;
            for (int direction = 0; direction < 4; direction++) {
                 int stepCount = n - 2 * offset - 1;
                 if (direction == 1 || direction ==3) {
                     stepCount = m - 2 * offset - 1;
                 }
                 
                 for (int i = 0; i < stepCount; i++) {
                    res.add(matrix[x][y]);
                    x += steps[direction][0];
                    y += steps[direction][1];
                 }
            }
        }
        
        if (n % 2 != 0) {
        	if (m > n) {
        		for (int i = offset; i < m - offset; i++) {
        			res.add(matrix[i][offset]);
        		}
        	} else if (m < n) {
        		for (int i = offset; i < n - offset; i++) {
        			res.add(matrix[offset][i]);
        		}
        	} else {
        		res.add(matrix[offset][offset]);
        	}
        }
        
        return res; 
    }
}
