package algorithm.dp;

import org.junit.Test;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-7-27 
 * Time : 下午3:16:09
 */
public class LongestIncreasingSubsequenceTest {
	private static LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
	
	@Test
	public void testLongestIncreasingSubsequenceTest(){
		int[] a = new int[]{4,2,4,5,3,7};
		int maxLen = lis.longestIncreasingSubsequence(a);
		System.out.println(maxLen);
	}
	
}
