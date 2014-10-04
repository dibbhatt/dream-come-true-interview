package algorithm.dp;

import org.junit.Test;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-6-15 
 * Time : 下午8:27:27
 */
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0)
            return 0;
        int[][] state = new int[grid.length][grid[0].length];
        int sum = 0;
        for (int i = 0; i < grid[0].length; i++){
            sum += grid[0][i];
            state[0][i] = sum;
        }
        sum = 0;
        for (int j = 1; j < grid.length; j++){
            sum += grid[j][0];
            state[j][0] = sum;
        }
        for (int i = 1; i < grid.length; i++){
            for (int j = 1; j < grid[0].length; j++){
                state[i][j] = Math.min(state[i-1][j], state[i][j-1]) + grid[i][j];
            }
        }
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
            	System.out.println("!!" + state[i][j]);
            }
        }
        
        return state[grid.length - 1][grid[0].length - 1];
    }
    
    @Test
    public  void test(){
    	MinPathSum m = new MinPathSum();
    	int [][] grid = new int[2][2];
    	grid[0][0] = 1; grid[0][1] = 2; grid[1][0] = 1; grid[1][1] = 1;
    	m.minPathSum(grid);
    }
}
