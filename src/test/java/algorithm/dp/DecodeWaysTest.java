package algorithm.dp;

import org.junit.Test;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-8-9 
 * Time : 下午4:58:59
 */
public class DecodeWaysTest {
	private DecodeWays dw = new DecodeWays();
	
	@Test
	public void testNumDecodings(){
		int r = dw.numDecodings("10");
		System.out.println(r);
	}
	
}
