package algorithm.dp;

import java.awt.List;
import java.util.ArrayList;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-7-26 
 * Time : 下午9:15:11
 */
public class Triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
    	
        int length = triangle.size();
        int[][] state = new int[length][length];
        
        for (int i = 0; i < length; i++){
            for(int j = 0; j < length; j++){
                state[i][j] = Integer.MIN_VALUE;
            }
        }        
         
        //创建状态方程
        state[0][0] = triangle.get(0).get(0);
        
        for (int i = 1; i < length; i++){
            for (int j =0; j <= i; j++){
                if((j-1) >= 0 && j < i-1){
                    state[i][j] = Math.min(state[i-1][j-1], state[i-1][j])+ triangle.get(i).get(j);
                } else if(j >= 1){
                    state[i][j] = state[i-1][j-1] + triangle.get(i).get(j);
                } else {
                    state[i][j] = state[i-1][j] + triangle.get(i).get(j);       
                }
            }
        }
        
        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++){
            if (state[length - 1][i] < minVal){
                minVal = state[length - 1][i];
            }
        }
        return minVal;
    }
}
