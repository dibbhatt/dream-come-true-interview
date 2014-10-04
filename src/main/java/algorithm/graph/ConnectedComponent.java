package algorithm.graph;

import java.util.HashSet;

import org.junit.Test;

/** 
 * Description : dfs识别连通域
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-9-15 
 * Time : 下午1:01:33
 */
public class ConnectedComponent {
	
	public int count(int[][] input) {
		
		int m = input.length;
		int n = input[0].length;
		
		int result = 1;
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (input[i][j] == 1){
					result++;
					dfs(input, i, j, result);
				}
			}
		}
		
		return result - 1;
	}
	
	public int count_no_dfs(int[][] input) {
		
		int m = input.length;
		int n = input[0].length;
		
		int current = 1;
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				//System.out.println(current);
				if (input[i][j] == 0){
					continue;
				}
			
				if (i > 0 && j > 0 && input[i-1][j] != 0 && input[i][j-1] != 0){
					int minIndex = Math.min(input[i-1][j], input[i][j-1]);
					input[i][j - 1] = minIndex;
					input[i-1][j] = minIndex;
					input[i][j] = minIndex;
				} else if (i > 0 && input[i-1][j] != 0) {
					input[i][j] = input[i-1][j];
				} else if (j > 0 && input[i][j-1] != 0){
					input[i][j] = input[i][j-1];
				} else {
					current++;
					input[i][j] = current; 
				}
			}
		}
		
		HashSet<Integer> indexes = new HashSet<Integer>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++){
				if (input[i][j] != 0)
					indexes.add(input[i][j]);
				
			}
			
		}
		
		return indexes.size();
	}

	
	public void dfs(int[][] input, int i, int j, int val) {
		int m = input.length;
		int n = input[0].length;
		if (i >= m || i < 0 || j >= n || j < 0) {
			return;
		}
		
		if (input[i][j] == 1) {
			input[i][j] = val;
		} else {
			return;
		}
		
		dfs(input, i + 1, j, val);
		dfs(input, i - 1, j, val);
		dfs(input, i, j + 1, val);
		dfs(input, i, j - 1, val);
	}
	
	@Test
	public void test(){
		int[][] a = new int[7][];
		a[0] = new int[]{1,0,1,0,1,0,1};
		a[1] = new int[]{1,1,0,1,1,0,1};
		a[2] = new int[]{1,0,1,0,1,0,1};
		a[3] = new int[]{0,0,1,1,0,1,0};
		a[4] = new int[]{1,0,1,1,0,1,1};
		a[5] = new int[]{1,0,1,1,0,1,1};
		a[6] = new int[]{1,1,0,1,0,1,0};
		
		System.out.println(count_no_dfs(a));
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++){
				System.out.print(" "+a[i][j]);
			}
			System.out.println();
		}
	}
	
	
}
