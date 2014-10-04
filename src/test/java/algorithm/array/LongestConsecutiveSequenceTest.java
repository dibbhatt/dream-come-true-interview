package algorithm.array;

import org.junit.Test;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-8-6 
 * Time : 上午12:32:01
 */
public class LongestConsecutiveSequenceTest {
	LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
	
	@Test
	public void testLongestConsecutive(){
		int[] num = new int[]{100,2,1,200,3,4};
		int r = lcs.longestConsecutive(num);
		System.out.println(r);
	}
	
}
