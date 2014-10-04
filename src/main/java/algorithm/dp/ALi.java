package algorithm.dp;

import org.junit.Test;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-8-29 
 * Time : 下午8:01:37
 */
public class ALi {
	public String longestIncreasingSubsequence(String query, String text) {
		
		int[][] state = new int[query.length()][text.length()];
		
		
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == query.charAt(0)){
				state[0][i] = 1;
			} else {
				state[0][i] = 0;
			}
		}
		
		
		for (int i = 0; i < query.length(); i++) {
			if (query.charAt(i) == text.charAt(0)){
				state[i][0]  = 1;
			} else {
				state[i][0] = 0;
			}
		}
		
		
		for (int i = 1; i < query.length(); i++) {
			for (int j = 1; j < text.length(); j++){
				if (query.charAt(i) == text.charAt(j)){
					state[i][j] = state[i-1][j-1] + 1;
				} else {
					state[i][j] = 0;
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		int maxi = 0;
		int maxj = 0;
		
		for (int i = 1; i < query.length(); i++) {
			for (int j = 1; j < text.length(); j++){    
				if (state[i][j] > max) {
					max = state[i][j];
					maxi = i;
					maxj = j;
				}
				
			}
		}
		System.out.println (max);
		return query.substring(maxi + 1 - max, maxi + 1);
    }
	
	@Test
	public void test(){
		System.out.println (longestIncreasingSubsequence("eabcdek", "deabcde"));
	}
}
