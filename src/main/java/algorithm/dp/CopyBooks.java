package algorithm.dp;

import java.util.Scanner;

import org.junit.Test;

/** 
 * Description:
 * 有n本书和k个抄写员。要求n本书必须连续的分配给这k个抄写员抄写。也就是说前a1本书分给第一个抄写员，
 * 接下来a2本书分给第二个抄写员，如此类推（a1,a2需要你的算法来决定）。
 * 给定n,k和每本书的页数p1,p2..pn，假定每个抄写员速度一样（每分钟1页），k个抄写员同时开始抄写，
 * 问最少需要多少时间能够将所有书全部抄写完工？
 * （提示：本题有很多种算法可以在不同的时间复杂度下解决，需要尽可能的想到所有的方法）
 * (1)DP (2)二分法
 * 
 * From: 九章算法面试题2抄书问题
 * 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-9-21 
 * Time : 下午2:47:46
 */
public class CopyBooks {

	
	public int shortestTime(int[] pages, int k) {
		int n = pages.length;
		
		int[][] states = new int[k + 1][n + 1];
		int[] sums = new int[n + 1];
		
		sums[0] = 0;
		sums[1] = pages[0];
		states[1][1] = pages[0];
		
		for (int i = 2; i <= n; i++) {
			sums[i] = sums[i-1] + pages[i-1];
			states[1][i] = sums[i];
			//System.out.println(sums[i]);
		}		
		

		
		for (int i = 2; i <= k; i++) {
			for (int j = 1; j <= n; j++) {
				int minVal = Integer.MAX_VALUE;
				
				for (int jj = 0; jj <= j; jj++){
					int val = Math.max(states[i-1][j - jj] , sums[j] - sums[j-jj]);
					if (val < minVal){
						minVal = val;
					}
				}
				
				states[i][j] = minVal;
			}
		}
		
		return states[k][n];
	}
	
	@Test
	public  void main() {
		
		CopyBooks cb = new CopyBooks();
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        while(in.hasNext()) {
	        for (int k = 0; k < n; k++){
	        		int m = in.nextInt(); int kk = in.nextInt();
	        		int[] input =  new int[m];
	        		for (int i = 0; i < m; i++) {
	        			input[i] = in.nextInt();
	        		}
	        		int r = cb.shortestTime(input, kk);
	        		System.out.println(r);
	        }
	        	
	     }
    }
}
