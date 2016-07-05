package algorithm.dp;

import java.util.Arrays;

/** 
 * Description :
 * Source : 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-10-11 
 * Time : 下午10:53:02
 */
public class DistinctSubsequence {
	public int numDistinct(String S, String T) {
		if (S.length() == 0 || T.length() == 0){
			return 0;
		}
		
		int[][] state = new int[S.length()][T.length()];

		for (int i = 0; i < S.length(); i++) {
			Arrays.fill(state[i], 0);
		}
		
		if (S.charAt(0) == T.charAt(0)) {
			state[0][0] = 1;
		}
		
		for (int i = 1; i < S.length(); i++) {
			for (int j = 0; j < T.length(); j++) {
				if (S.charAt(i) == T.charAt(j)) {
					if (j == 0) {
						state[i][j] = 1 + state[i - 1][j];
					}else {
						state[i][j] = state[i - 1][ j -1] + state[i - 1][j];
					}
				} else {
					state[i][j] = state[i - 1][j];
				}
			}
		}
		
		return state[S.length() - 1][T.length() - 1];
    }
}
