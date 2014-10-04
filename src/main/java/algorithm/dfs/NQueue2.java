package algorithm.dfs;

import java.util.ArrayList;

import org.junit.Test;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-9-2 
 * Time : 下午7:50:26
 */
public class NQueue2 {
    public static int sum = 0;
    public int totalNQueens(int n) {
        dfs(new ArrayList<Integer>(), n);
        return sum;
    }
    
    public void dfs(ArrayList<Integer> rows, int n){
        if (rows.size() == n) {
            sum ++;
            return;
        }
    
        int curr = rows.size();
        for (int i = 0; i < n; i++) {
            if (isValid(rows, i,n)) {
                rows.add(i);
                dfs(rows, n);
                rows.remove(rows.size() - 1);
            }
        }
    }
    
    public boolean isValid(ArrayList<Integer> rows, int curr, int n){
        int curr_y = rows.size();
        for (int i = 0; i < rows.size(); i++) {
            int row = rows.get(i);
            if (curr == row){
                return false;
            }
            if (Math.abs(curr_y - i) == Math.abs(curr - row)) {
                return false;
            }
        }
        
        return true;
    }
    
    
    @Test
    public void test(){
    	int r = totalNQueens(8);
    	System.out.println(r);
    }
}
